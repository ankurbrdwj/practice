package com.ankur.interview.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(getSafePosition(10000000,666));
        List<Integer> list= new ArrayList<>();
    }

    public static long getSafePosition(long n, long k) {
        long sum = 0, i;
        // For finding out the removed
        // chairs in each iteration
        for (i = 2; i <= n; i++)
            sum = (sum + k) % i;
        return sum + 1;
    }
}

