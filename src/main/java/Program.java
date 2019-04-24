import Kalchenya.Shop;
import Kurylo.FileLoader;
import Kurylo.Fruit;
import SP.Company;
import SP.Type;
import com.google.gson.Gson;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {


    public static void main(String[] args){
        try {
            Gson gson = new Gson();
            Shop arrivement = gson.fromJson(FileLoader.loadJsonFromFile("test"), Shop.class);

            System.out.println(arrivement.getFruits().get(1).getDate());

            System.out.println( arrivement.getSpoiledFruits(new Date(), Type.Apple).get(0).getShelfLife());
            System.out.println( arrivement.getAvailableFruits(new Date(), Type.Banana).get(0).getShelfLife());

            System.out.println(arrivement.getAddedFruits(new SimpleDateFormat("dd/MM/yyyy").parse("24/04/2019"),Type.Banana).get(0).getType());
            arrivement.saveFruits("fruits.json");

            List<Shop> shopList = new ArrayList<>();
            shopList.add(arrivement);
            Company c = new Company(shopList,0L);
            c.save("company");
            System.out.println(c.getShops().get(0).getFruits().get(1).getType());
            c.load("company");
            System.out.println(c.getShops().get(0).getFruits().get(1).getType());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
