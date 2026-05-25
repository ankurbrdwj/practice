package com.ankur.interview.practice.lists;

public class AddTwoNumbers {

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Input lists are in reverse order (head = least significant digit):
    //
    //   l1:  2 -> 4 -> 3        represents  3 4 2
    //   l2:  5 -> 6 -> 4        represents  4 6 5
    //                                       -----
    //                                       8 0 7  =  result 8 0 7
    //   out: 7 -> 0 -> 8        represents  8 0 7
    //
    // We walk both lists left-to-right (ones → tens → hundreds …),
    // adding digit-by-digit and forwarding any carry to the next position:
    //
    //   step 1:  l1=2  l2=5  carry=0  →  sum=7   node(7)  carry=0
    //   step 2:  l1=4  l2=6  carry=0  →  sum=10  node(0)  carry=1
    //   step 3:  l1=3  l2=4  carry=1  →  sum=8   node(8)  carry=0
    //   done  →  result: dummy -> 7 -> 0 -> 8
    //
    // Edge case — carry outlives both lists (999 + 1 = 1000):
    //   step 1:  l1=9  l2=1  carry=0  →  sum=10  node(0)  carry=1
    //   step 2:  l1=9  l2=∅  carry=1  →  sum=10  node(0)  carry=1
    //   step 3:  l1=9  l2=∅  carry=1  →  sum=10  node(0)  carry=1
    //   step 4:  l1=∅  l2=∅  carry=1  →  sum=1   node(1)  carry=0   ← extra node
    //   result: 0 -> 0 -> 0 -> 1
    public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) {
        LinkedList dummy = new LinkedList(0); // sentinel so we never need a null-head check
        LinkedList current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            carry = sum / 10;           // 0 or 1
            current.next = new LinkedList(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}