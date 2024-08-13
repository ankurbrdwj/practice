package com.ankur.interview.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIP {

    public static List<String> getAllValidIP(String string) {
        List<String> validIp = new ArrayList<>();
        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currIP = new String[]{"", "", "", ""};
            currIP[0] = string.substring(0, i);
            if (!isValidIp(currIP[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min(4, string.length() - i); j++) {
                currIP[1] = string.substring(i, j);
                if (!isValidIp(currIP[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min(4, string.length() - j); k++) {
                    currIP[2] = string.substring(j, k);
                    currIP[3] = string.substring(k, string.length());
                    if (isValidIp(currIP[2]) && isValidIp(currIP[3])) {
                        validIp.add(currIP[0] + "." + currIP[1] + "." + currIP[2] + "." + currIP[3]);

                    }
                }
            }
        }

        return validIp;
    }

    private static boolean isValidIp(String s) {
        Integer value = Integer.parseInt(s);
        if (value > 255)
            return false;
        else
            return s.length() == value.toString().length();
    }

    public static void main(String[] args) {
        List<String> result = getAllValidIP("1921680");
        result.stream()
                .forEach(System.out::println);
        System.out.println("ankurbhardwaj".lastIndexOf('a'));
        StringBuilder current = new StringBuilder();
    }
}
