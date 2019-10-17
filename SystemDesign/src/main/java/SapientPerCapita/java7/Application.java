package SapientPerCapita.java7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/System_Input.csv");
            BufferedReader br= new BufferedReader(reader);
            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line=br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
