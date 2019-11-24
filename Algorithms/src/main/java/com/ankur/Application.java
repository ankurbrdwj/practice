package com.ankur;

import java.util.Scanner;

public class Application {

    public int a=0;
    public Application (String text){
        a=100;
    }

    public Application() {

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner = scanner.useDelimiter("\\n");
int a=100;
      /*  while (scanner.hasNextLine()) {
            String out = scanner.nextLine();
            System.out.println(out);
            // System.exit(0);
        }*/
        Application app =new Application();
        System.out.println(a);
        scanner.close();
        System.out.close();
        System.exit(0);

    }
}
