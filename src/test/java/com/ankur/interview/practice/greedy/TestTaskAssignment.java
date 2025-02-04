package com.ankur.interview.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTaskAssignment {

  @Test
  public void TestCase1() {
    var k = 3;
    var tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
    var expected = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
    ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
    ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
    expected.add(subarr);
    expected.add(subarr2);
    expected.add(subarr3);
    var actual = new AssignTasks().taskAssignment(k, tasks);
    Assertions.assertTrue(expected.equals(actual));
  }
}
