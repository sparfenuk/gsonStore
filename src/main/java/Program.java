import Kurylo.Fruit;
import SP.Arrivement;
import com.google.gson.Gson;

import java.io.FileReader;

public class Program {

    //    public List<Fruit> getSpoiledFruits(Date date){
//        List<Fruit> spoiled = new ArrayList<Fruit>();
//        for (Fruit f:fruits) {
//            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//        }
//    }
    public static void main(String[] args){
        try {
            Gson gson = new Gson();
            Arrivement arrivement = gson.fromJson(new FileReader("test"), Arrivement.class);
            System.out.println(arrivement.fruits[1].getDate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
