package com.ankur.interview.adventofcode;

import com.ankur.interview.adventofcode.Day8.Accumulator;
import com.ankur.interview.adventofcode.Day8.Computer;
import com.ankur.interview.adventofcode.Day8.Instruction;
import com.ankur.interview.adventofcode.Day8.Jumper;
import com.ankur.interview.adventofcode.Day8.NoOperation;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day10/input.txt"));
        List<Integer> intList = data.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        solvePart1(intList);
        solvePart2(intList);
    }

    private static void solvePart1(List<Integer> intList) {
        IntSummaryStatistics summary = intList.stream().mapToInt(i -> i).summaryStatistics();
        int deviceJolt = summary.getMax() + 3;
        int outletJolt = 0;
        Collections.sort(intList, Comparator.naturalOrder());
        int diff1 = 0;
        int diff3 = 0;
        int lastSelected = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == lastSelected + 1) {
                diff1++;
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else if (intList.get(i) == lastSelected + 2) {
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else if (intList.get(i) == lastSelected + 3) {
                diff3++;
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else {
                System.out.println("cannot be chained");
            }
        }
        System.out.println(deviceJolt);
        System.out.println(diff1);
        System.out.println(diff3);
        System.out.println(diff1 + diff3);
        System.out.println(diff1 * diff3);
        System.out.println(outletJolt);
    }

   /* public Integer getWithMinDiff(Integer effectiveRating, List<Integer> list) {

    }*/

    static void solvePart2(List<Integer> intList) {
        /*int count = 1;
        Collections.sort(intList,Comparator.naturalOrder());
        intList.add(0, 0);
        intList.add(intList.get(intList.size()-1)+3);
        for (int i = 0; i < intList.size()-2; i++) {
            int pick = intList.get(i);
            if(intList.get(i+2)- intList.get(i)<=3){
                count++;
            }
        }
        System.out.println(count);*/
        Collections.sort(intList, Comparator.naturalOrder());
        /*final long[] sums = new long[intList.get(intList.size() - 1) + 1];
        sums[0] = 1;
        for (int i = 0; i < intList.size(); i++) {
            final long x = intList.get(i) >= 3 ? sums[intList.get(i) - 3] : 0;
            final long y = intList.get(i) >= 2 ? sums[intList.get(i) - 2] : 0;
            final long z = intList.get(i) >= 1 ? sums[intList.get(i) - 1] : 0;
            sums[intList.get(i)] = x + y + z;
        }

        System.out.println(sums[sums.length - 1]);*/
        int i = 0;
        List<Long> sums = new ArrayList<>();
        long result = dp(i, intList, sums);
    }

    private static long dp(int i, List<Integer> list, List<Long> sums) {
        if (i == list.size() - 1) {
            return 1;
        }
        if (sums.contains(i)) {
            for (Long j:sums) {
                if(j==i){
                    return j;
                }
            }
        }
        long ans=0;
        for(int k=i+1;k<list.size();k++){
            if(list.get(k)==list.get())
        }
    }

}
