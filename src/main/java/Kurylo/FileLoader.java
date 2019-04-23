package Kurylo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class FileLoader {
    public static String loadJsonFromFile(String pathToJsonFile){
        String str = "";
        try {
            File file = new File(pathToJsonFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                str += st;
        }
        catch (Exception ex){}
        return str;
    }
}
