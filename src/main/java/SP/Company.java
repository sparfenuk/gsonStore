package SP;

import Kalchenya.Shop;
import Kurylo.FileLoader;
import Kurylo.Fruit;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {
    private List<Shop> shops;
    private long moneyBalance;

    public Company(List<Shop> shops, long moneyBalance) {
        this.shops = shops;
        this.moneyBalance = moneyBalance;
    }

    public List<Shop> getShops() {
        return shops;
    }


    public long getMoneyBalance() {
        return moneyBalance;
    }


    public void save(String pathToJsonFile){
        try {
            Gson gson = new Gson();
            gson.toJson(this, new FileWriter(pathToJsonFile));
        }
        catch (Exception e){e.printStackTrace();}
    }
    public void load(String pathToJsonFile){
        try {
            Gson gson = new Gson();
            Company c = gson.fromJson(FileLoader.loadJsonFromFile(pathToJsonFile),Company.class);
            this.shops = c.getShops();
            this.moneyBalance = c.getMoneyBalance();
        }
        catch (Exception e){e.printStackTrace();}
    }

    public Shop getShop(int index) {
        return shops.get(index);
    }


    public int getCompanyBalance(){
        int balance = 0;
        for (Shop s:shops) {
            balance+=s.getMoneyBalance();
        }
        return balance;
    }

    public List<Fruit> getSpoiledFruits(Date date){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getSpoiledFruits(date));
        }
        return spoiled;
    }

    public List<Fruit> getSpoiledFruits(Date date,Type type){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getSpoiledFruits(date,type));
        }
        return spoiled;
    }

    public List<Fruit> getAvailableFruits(Date date){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getAvailableFruits(date));
        }
        return spoiled;
    }

    public List<Fruit> getAvailableFruits(Date date,Type type){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getAvailableFruits(date,type));
        }
        return spoiled;
    }

    public List<Fruit> getAddedFruits(Date date,Type type){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getAddedFruits(date,type));
        }
        return spoiled;
    }

    public List<Fruit> getAddedFruits(Date date){
        List<Fruit> spoiled = new ArrayList<Fruit>();
        for (Shop s:shops) {
            spoiled.addAll(s.getAddedFruits(date));
        }
        return spoiled;
    }
}
