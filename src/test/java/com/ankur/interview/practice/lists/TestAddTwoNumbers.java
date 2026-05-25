package com.ankur.interview.practice.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAddTwoNumbers {

    private AddTwoNumbers.LinkedList list(int... digits) {
        AddTwoNumbers.LinkedList dummy = new AddTwoNumbers.LinkedList(0);
        AddTwoNumbers.LinkedList cur = dummy;
        for (int d : digits) {
            cur.next = new AddTwoNumbers.LinkedList(d);
            cur = cur.next;
        }
        return dummy.next;
    }

    private int[] toArray(AddTwoNumbers.LinkedList head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        while (head != null) {
            result.add(head.value);
            head = head.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void basicAddition() {
        // 342 + 465 = 807  =>  [7, 0, 8]
        Assertions.assertArrayEquals(
            new int[]{7, 0, 8},
            toArray(AddTwoNumbers.addTwoNumbers(list(2, 4, 3), list(5, 6, 4)))
        );
    }

    @Test
    public void carryPropagates() {
        // 999 + 1 = 1000  =>  [0, 0, 0, 1]
        Assertions.assertArrayEquals(
            new int[]{0, 0, 0, 1},
            toArray(AddTwoNumbers.addTwoNumbers(list(9, 9, 9), list(1)))
        );
    }

    @Test
    public void differentLengths() {
        // 9999 + 1 = 10000  =>  [0, 0, 0, 0, 1]
        Assertions.assertArrayEquals(
            new int[]{0, 0, 0, 0, 1},
            toArray(AddTwoNumbers.addTwoNumbers(list(9, 9, 9, 9), list(1)))
        );
    }

    @Test
    public void bothZero() {
        Assertions.assertArrayEquals(
            new int[]{0},
            toArray(AddTwoNumbers.addTwoNumbers(list(0), list(0)))
        );
    }
}