package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.FindSquareOfZeroes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSquareOfZeroes {

  @Test
  public void TestCase1() {
    List<List<Integer>> test = new ArrayList<List<Integer>>();
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      1, 1, 1, 0, 1, 0})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 0, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 1, 1, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 1, 1, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 0, 0, 1})));
    Assertions.assertTrue(FindSquareOfZeroes.squareOfZeroes(test));
  }
  @Test
  public void TestCase2() {
    List<List<Integer>> test = new ArrayList<List<Integer>>();
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      1, 1, 1, 0, 1, 0})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 0, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 1, 1, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 1, 1, 1, 0, 1})));
    test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
      0, 0, 0, 0, 0, 1})));
    Assertions.assertTrue(FindSquareOfZeroes.squareOfZeroesBottomUp(test));
  }

}
