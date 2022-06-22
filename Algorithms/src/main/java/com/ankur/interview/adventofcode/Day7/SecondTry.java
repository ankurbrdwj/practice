package com.ankur.interview.adventofcode.Day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTry {
    public static void main(String[] args) {
        InputReader ir = new InputReader("src/main/java/com/ankur/interview/adventofcode/Day7/input.txt");
        ir.loadFile();

        BagPacker bagPacker = new BagPacker(ir.toArrayList());
        System.out.println("Part 1: " + bagPacker.runPart1());
        System.out.println("Part 2: " + bagPacker.runPart2());
    }

    private static class BagPacker{
        private List<Bag> bags = new ArrayList<>();
        private HashMap<String, Bag> bagMap = new HashMap<>();

        public BagPacker(ArrayList<String> input) {
            for (String line:input) {
                Bag tmpBag = new Bag(line);
                this.bags.add(tmpBag);
                this.bagMap.put(tmpBag.getBagColour(), tmpBag);
            }
        }

        private int getBags(Bag parent) {
            int numBags = 1;

            for (Map.Entry<String, Integer> entry : parent.getChildren().entrySet()) {
                int someNum = getBags(this.bagMap.get(entry.getKey()));
                numBags += someNum * entry.getValue();
            }

            return numBags;
        }

        public int runPart1() {
            ArrayList<String> validBags = new ArrayList<>();
            boolean bagFound = false;

            for(Bag tryBag: this.bags) {
                String vBag = tryBag.canContainThisBag("shiny gold");
                if(vBag != null && !validBags.contains(vBag)) {
                    validBags.add(vBag);
                }
            }

            do {
                ArrayList<String> tmpValid = new ArrayList<>();
                for(String bag: validBags) {
                    for(Bag tryBag: this.bags) {
                        String vBag = tryBag.canContainThisBag(bag);
                        if(vBag != null && !tmpValid.contains(vBag) && !validBags.contains(vBag)) {
                            tmpValid.add(vBag);
                        }
                    }
                }
                if (tmpValid.size() > 0) {
                    bagFound = true;
                    validBags.addAll(tmpValid);
                } else {
                    bagFound = false;
                }

            } while(bagFound);

            return validBags.size();
        }

        public int runPart2() {
            return getBags(this.bagMap.get("shiny gold")) -1;
        }
    }
    private static class Bag{
        private String bagColor;
        private HashMap<String, Integer> contains = new HashMap<>();

        public Bag(String bag) {

            Pattern p = Pattern.compile("^([\\w\\s]+) bags contain");
            Matcher m1 = p.matcher(bag);

            m1.find();
            this.bagColor = m1.group(1);

            p = Pattern.compile("(\\d) ([\\w\\s]+) bags?");
            m1 = p.matcher(bag);
            while(m1.find()) {
                this.contains.put(m1.group(2), Integer.valueOf(m1.group(1)));
            }
        }

        public String canContainThisBag(String bag) {
            if (this.contains.containsKey(bag)) {
                return this.bagColor;
            }

            return null;
        }

        public String getBagColour() {
            return this.bagColor;
        }

        public HashMap<String, Integer> getChildren() {
            return this.contains;
        }

        public int getNumChildren() {
            return this.contains.size();
        }
    }
}
