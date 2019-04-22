package Kalchenya;

import Kurylo.Fruit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Fruit> fruits ;
    private String path;


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



}
