package com.ankur.interview.algexp.dyanamicprogramming;

import com.ankur.interview.algexp.dynamicprogramming.ArrayPermutations2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayPermutations2 {
    // Add, edit, or remove tests in this file.
// Treat it as your playground!


    @Test
    public void TestCase1() {
        List<Integer> input = new ArrayList<Integer>();
        List<List<Integer>> perms = ArrayPermutations2.getPermutations(input);
        Assertions.assertTrue(perms.size() == 0);
    }

    @Test
    public void TestCase2() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1));
        List<List<Integer>> perms = ArrayPermutations2.getPermutations(input);
        Assertions.assertTrue(perms.size() == 1);
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1))));
    }

    @Test
    public void TestCase3() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2));
        List<List<Integer>> perms = ArrayPermutations2.getPermutations(input);
        Assertions.assertTrue(perms.size() == 2);
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1))));
    }

    @Test
    public void TestCase4() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = ArrayPermutations2.getPermutations(input);
        Assertions.assertTrue(perms.size() == 6);
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 1))));
    }

    @Test
    public void TestCase5() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> perms = ArrayPermutations2.getPermutations(input);
        Assertions.assertTrue(perms.size() == 24);
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 4, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 2, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 4, 3, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 4, 2, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 3, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 1, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 4, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 4, 1, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 4, 3, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 2, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 4, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 4, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 4, 1, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 4, 2, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 1, 2, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 1, 3, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 2, 1, 3))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 2, 3, 1))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 3, 1, 2))));
        Assertions.assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(4, 3, 2, 1))));
    }

    public boolean contains(List<List<Integer>> arr1, List<Integer> arr2) {
        for (List<Integer> subArray : arr1) {
            if (subArray.equals(arr2)) {
                return true;
            }
        }
        return false;
    }
}
