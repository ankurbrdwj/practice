package com.ankur.interview.adventofcode.Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Day4 {
    public static void main(String[] args) throws IOException {
//		copy and paste the input data into a file and read from it
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day4/input.txt"));
        solutionToPart1(data);
//        solutionToPart2(data);
    }

    private static void solutionToPart1(List<String> data) {
        StringJoiner joiner = new StringJoiner(" ");
        String item = "";
        List<String> allinput = new ArrayList<>();
        for (String line : data) {
            item = item == "" ? line : item + " " + line;
            if ("".equalsIgnoreCase(line)) {
                allinput.add(item);
                item = "";
            } else {
            }
        }
        allinput.add(item);
        HashSet<String> mandatorySet = new HashSet<>();
        mandatorySet.addAll(Arrays.asList("byr", "eyr", "iyr", "hgt", "hcl", "ecl", "pid"));
        int validCount = 0;
        int fullyValid = 0;
        for (String passport : allinput) {
            String[] tokens = passport.split(" ");
            Map<String, String> map = new HashMap<String, String>();
            for (String token : tokens) {
                if (!"".equalsIgnoreCase(token)) {
                    String[] keyValue = token.split(":");
                    map.put(keyValue[0], keyValue[1]);
                }
            }
            if (map.keySet().containsAll(mandatorySet)) {
                validCount++;
                if (validatePassport(map)) {
                    fullyValid++;
                }
            }
        }
        System.out.println(validCount);
        System.out.println(fullyValid);
    }

    private static boolean validatePassport(Map<String, String> map) {
        if (validBirth(map.get("byr")) && validIssue(map.get("iyr")) && validExpire(map.get("eyr"))
                && validHeight(map.get("hgt")) && validHair(map.get("hcl"))
                && validEye(map.get("ecl")) && validPassport(map.get("pid"))) {
            return true;
        }
        return false;
    }

    private static boolean validPassport(String byr) {
        if (byr == null || byr.length() != 9) {
            return false;
        }
        try {
            int d =  Integer.parseInt(byr);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean validEye(String byr) {
        List<String> list = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        if (list.contains(byr))
            return true;
        return false;
    }

    private static boolean validHair(String hair) {
        if (hair.charAt(0) == '#' &&  hair.length() == 7)
            return true;
        return false;
    }

    private static boolean validHeight(String hgt) {
        if (hgt.endsWith("cm")) {
            int len = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            if (len >= 150 && len <= 193)
                return true;
        }
        if (hgt.endsWith("in")) {
            int len = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            if (len >= 59 && len <= 76)
                return true;
        }
        return false;
    }

    private static boolean validExpire(String eyr) {
        return Integer.parseInt(eyr) >= 2020 && Integer.parseInt(eyr) <= 2030;
    }

    private static boolean validIssue(String issue) {
        return Integer.parseInt(issue) >= 2010 && Integer.parseInt(issue) <= 2020;

    }

    private static boolean validBirth(String byr) {
        return Integer.parseInt(byr) >= 1920 && Integer.parseInt(byr) <= 2002;

    }
}
