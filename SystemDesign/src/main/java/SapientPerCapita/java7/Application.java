package SapientPerCapita.java7;

import SapientPerCapita.java8.domain.Income;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/System_Input.csv");
            BufferedReader br= new BufferedReader(reader);
            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line=br.readLine();
                Income income = null;
                HashMap<String, List<Income>> hashMap =new HashMap<>();
                String country ="";
                if (!hashMap.containsKey(country)) {
                    List<Income> list = new ArrayList<Income>();
                    income =new Income();
                    list.add(income);
                    hashMap.put(country, list);
                } else {
                    hashMap.get(country).add(income);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
