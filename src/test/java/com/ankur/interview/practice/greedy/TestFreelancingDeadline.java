package com.ankur.interview.practice.greedy;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFreelancingDeadline {

    @Test
    public void TestCase1() {
      HashMap[] input = new HashMap[7];
      HashMap<String, Integer> job = new HashMap<String, Integer>();
      job.put("deadline", 1);
      job.put("payment", 1);
      input[0] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 2);
      job.put("payment", 2);
      input[1] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 2);
      job.put("payment", 2);
      input[2] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 7);
      job.put("payment", 1);
      input[3] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 4);
      job.put("payment", 3);
      input[4] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 4);
      job.put("payment", 5);
      input[5] = job;
      job = new HashMap<String, Integer>();
      job.put("deadline", 3);
      job.put("payment", 1);
      input[6] = job;

      var expected = 13;
      var actual = new FreelancingProfit().freelanceMaxProfit(input);
      Assertions.assertEquals(expected ,actual);
    }
  }
