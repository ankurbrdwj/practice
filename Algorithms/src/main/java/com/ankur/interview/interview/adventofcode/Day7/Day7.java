package com.ankur.interview.adventofcode.Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 {
    public static void main(String[] args) throws IOException {
//		copy and paste the input data into a file and read from it
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day7/input.txt"));
        HashMap<String, Bag> map = new HashMap<>();
        for (String line : data) {
            String[] kv = line.split(" bags contain ");
            String[] values = kv[1].substring(0, kv[1].length() - 1).split(", ");
            if (!map.containsKey(kv[0])) {
                map.put(kv[0], new Bag(kv[0]));
            }

            for (String v : values) {
                if (v.equals("no other bags")) {
                    continue;
                }

                final int count = Integer.parseInt(v.substring(0, v.indexOf(" ")));
                final String name = v.substring(v.indexOf(" ") + 1, v.lastIndexOf(" "));
                if (!map.containsKey(name)) {
                    map.put(name, new Bag(name));
                }
                map.get(kv[0]).addBags(map.get(name), count);
            }
        }
        solvedPart1(map);
        solvedPart2(map);
    }

    private static void solvedPart2(HashMap<String, Bag> map) {
        System.out.println(map.get("shiny gold").countBags());

    }

    private static void solvedPart1(HashMap<String, Bag> map) {
        int total = 0;
        ArrayList<String> validBags = new ArrayList<>();
        List<String> bagNames = new ArrayList<>();
        for (Map.Entry<String, Bag> e : map.entrySet()) {
            //total += ((Bag)e.getValue()).containsBag("shiny gold") ? 1 : 0;
            bagNames.add((String) e.getKey());
        }
        ArrayList<String> tempBags = new ArrayList<>();
        for (String bagName : bagNames) {
            for(Map.Entry<String,Bag> e : map.entrySet()){
                String vBag= e.getValue().containsBag(bagName);
                if(vBag!=null && !tempBags.contains(vBag) && !validBags.contains(vBag))
                    tempBags.add(vBag);
            }
        }
        boolean bagFound;
        if (tempBags.size() > 0) {
            bagFound = true;
            validBags.addAll(tempBags);
        } else {
            bagFound = false;
        }

        System.out.println(validBags.size());
    }

    private static class Bag {
        private Map<Bag, Integer> map = new HashMap<>();
        private String name;

        public Bag(String name) {
            this.name = name;
        }

        public void addBags(Bag bag, int count) {
            this.map.put(bag, count);
        }

        public String containsBag(String name) {
            if (this.name.equalsIgnoreCase(name))
                return null;
            for (Bag bag : this.map.keySet()) {
                if (bag.name.equalsIgnoreCase(name))
                    return bag.name;
            }
            return null;
        }

        public int countBags() {
            int total = 0;
            for (Map.Entry<Bag, Integer> entry : this.map.entrySet()) {
                total += entry.getValue() + entry.getValue() * entry.getKey().countBags();
            }
            return total;
        }
    }
}
