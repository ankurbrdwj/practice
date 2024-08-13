package com.ankur.interview.practice.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestListPalindrome {

    @Test
    public void TestCase1() {
      var head = new LinkedListPalindrome.LinkedList(0);
      head.next = new LinkedListPalindrome.LinkedList(1);
      head.next.next = new LinkedListPalindrome.LinkedList(2);
      head.next.next.next = new LinkedListPalindrome.LinkedList(2);
      head.next.next.next.next = new LinkedListPalindrome.LinkedList(1);
      head.next.next.next.next.next = new LinkedListPalindrome.LinkedList(0);
      var expected = true;
      var actual = new LinkedListPalindrome().listPalindrome(head);
      Assertions.assertTrue(expected == actual);
    }
  }
