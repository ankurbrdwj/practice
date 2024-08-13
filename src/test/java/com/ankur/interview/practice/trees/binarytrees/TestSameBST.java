package com.ankur.interview.practice.trees.binarytrees;
import com.ankur.interview.practice.trees.binarysearchtrees.AreSameBST;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSameBST {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!


    @Test
    public void TestCase1() {
      List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
      List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
      assertTrue(AreSameBST.sameBsts(arrayOne, arrayTwo));
    }
  }

