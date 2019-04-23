package Kalchenya;

import Kurylo.Client;
import Kurylo.ClientBase;
import Kurylo.FileLoader;
import Kurylo.Fruit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Shop {
    private List<Fruit> fruits ;
    private String path;
    private double moneyBalance;

    public Shop(List<Fruit> fruits, String path) {
        this.fruits = fruits;
        this.path = path;
    }
    public void addFruits(String pathToJsonFile,List<Fruit> fruits) throws IOException {
        this.fruits.addAll(fruits);
        File file = new File(pathToJsonFile);
        ObjectMapper om = new ObjectMapper();
        FileWriter fileWriter = new FileWriter(file);
        String content = om.writerWithDefaultPrettyPrinter().writeValueAsString(fruits);
        fileWriter.write(content);
        fileWriter.close();
    }

    public void saveFruits(String pathToJsonFile) throws IOException {
        File file = new File(pathToJsonFile);
        FileWriter fw = new FileWriter(file);
        ObjectMapper om = new ObjectMapper();
        String content = om.writerWithDefaultPrettyPrinter().writeValueAsString(fruits);
        System.out.println("Saved to the file " + fruits.size() + " fruits add to shop");
        fw.write(content);
        fw.close();
    }

    public void loadFruits(String pathToJsonFile) throws IOException {
        System.out.println("List size before loading -  " + fruits.size());
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        fruits = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Fruit.class));
        System.out.println("List size after loading -  " + fruits.size());
    }

    public void sell(String pathToJsonFile)
    {
        String json = FileLoader.loadJsonFromFile(pathToJsonFile);
        ClientBase clientBase = new Gson().fromJson(json, ClientBase.class);
        for (Client client:
             clientBase.clients) {
            for (Fruit fr:
                 fruits) {
                if(fr.getType() == client.getType()){
                    if(fr.getCount() - client.getCount() >= 0){
                        fr.setCount(fr.getCount() - client.getCount());
                        this.moneyBalance += client.getCount() * fr.getPrice();
                        System.out.println("Here your fruits");
                    }
                    else
                        System.out.println("Sorry, there is no such amount of fruits");
                }
            }
        }
    }

}
