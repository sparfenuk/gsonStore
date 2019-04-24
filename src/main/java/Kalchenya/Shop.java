package Kalchenya;

import Kurylo.*;
import SP.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shop {
    private List<Fruit> fruits;
    private String path;
    private double moneyBalance;



    public Shop(List<Fruit> fruits, String path) {
        this.fruits = fruits;
        this.path = path;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void addFruits(String pathToJsonFile) {
        try {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Fruit>>(){}.getType();
            this.fruits.addAll(gson.fromJson(new FileReader(pathToJsonFile),listType));
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void saveFruits(String pathToJsonFile){
        try (Writer writer = new FileWriter(pathToJsonFile)){
            Gson gson = new Gson();
            gson.toJson(this.fruits,writer);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void loadFruits(String pathToJsonFile){
        try {
            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Fruit>>(){}.getType();
            this.fruits = gson.fromJson(new FileReader(pathToJsonFile),listType);
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void sell(String pathToJsonFile) {
        String json = FileLoader.loadJsonFromFile(pathToJsonFile);
        ClientBase clientBase = new Gson().fromJson(json, ClientBase.class);
        for (Client client :
                clientBase.clients) {
            for (Fruit fr :
                    fruits) {
                if (fr.getType() == client.getType()) {
                    if (fr.getCount() - client.getCount() >= 0) {
                        fr.setCount(fr.getCount() - client.getCount());
                        this.moneyBalance += client.getCount() * fr.getPrice();
                        System.out.println("Here your fruits");
                    } else
                        System.out.println("Sorry, there is no such amount of fruits");
                }
            }
        }
    }


    public List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Fruit f : fruits) {
            long diffInDays = TimeUnit.DAYS.convert(Math.abs(f.getDate().getTime() - date.getTime()), TimeUnit.MILLISECONDS);
            if(diffInDays > f.getShelfLife())
                spoiled.add(f);
        }

        return spoiled;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> available = new ArrayList<Fruit>();
        for (Fruit f : fruits) {
            long diffInDays = TimeUnit.DAYS.convert(Math.abs(f.getDate().getTime() - date.getTime()), TimeUnit.MILLISECONDS);
            if(diffInDays <= f.getShelfLife())
                available.add(f);
        }

        return available;
    }

    public List<Fruit> getSpoiledFruits(Date date, Type type) {
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Fruit f : fruits) {
            long diffInDays = TimeUnit.DAYS.convert(Math.abs(f.getDate().getTime() - date.getTime()), TimeUnit.MILLISECONDS);
            if(diffInDays > f.getShelfLife() && f.getType() == type)
                spoiled.add(f);
        }

        return spoiled;
    }

    public List<Fruit> getAvailableFruits(Date date,Type type) {
        List<Fruit> available = new ArrayList<Fruit>();
        for (Fruit f : fruits) {
            long diffInDays = TimeUnit.DAYS.convert(Math.abs(f.getDate().getTime() - date.getTime()), TimeUnit.MILLISECONDS);
            if(diffInDays <= f.getShelfLife() && f.getType()==type)
                available.add(f);
        }

        return available;
    }

    public List<Fruit> getAddedFruits(Date date){
        List<Fruit> added = new ArrayList<Fruit>();
        for (Fruit f : fruits){
            if(f.getDate().equals(date))
                added.add(f);
        }
        return added;
    }

    public List<Fruit> getAddedFruits(Date date,Type type){
        List<Fruit> added = new ArrayList<Fruit>();
        for (Fruit f : fruits){
            if(f.getDate().equals(date) && f.getType() == type)
                added.add(f);
        }
        return added;
    }

}
