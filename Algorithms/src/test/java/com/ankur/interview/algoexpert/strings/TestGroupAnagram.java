package com.ankur.interview.algoexpert.strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGroupAnagram {

    @Test
    public void testCase1() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<String> result = GroupAnagrams.groupAnagrams(new ArrayList(){});
        result.forEach(s -> System.out.println(s));
    }
}
