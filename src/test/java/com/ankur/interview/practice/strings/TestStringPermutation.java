package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestStringPermutation {


    @Test
    public void testCase1() {
        StringPermutations sp = new StringPermutations();
        List<String> result = sp.getStringPermutations("AABC");
        result.forEach(s -> System.out.println(s));
    }
}
