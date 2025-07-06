package com.ankur.interview.practice.trees.binarytrees;

import com.ankur.interview.practice.heaps.MinHeapApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestMinHeapApi {
    // Add, edit, or remove tests in this file.
// Treat it as your playground!

    MinHeapApi.MinHeap test1 = new MinHeapApi.MinHeap(new ArrayList<Integer>(Arrays.asList(2, 3, 1)));

    MinHeapApi.MinHeap test2 =
            new MinHeapApi.MinHeap(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));

    MinHeapApi.MinHeap test3 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));

    MinHeapApi.MinHeap test4 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(
                                    -4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8)));

    MinHeapApi.MinHeap test5 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8)));

    MinHeapApi.MinHeap test6 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(
                                    427, 787, 222, 996, -359, -614, 246, 230, 107, -706, 568, 9, -246, 12, -764, -212,
                                    -484, 603, 934, -848, -646, -991, 661, -32, -348, -474, -439, -56, 507, 736, 635,
                                    -171, -215, 564, -710, 710, 565, 892, 970, -755, 55, 821, -3, -153, 240, -160,
                                    -610, -583, -27, 131)));

    MinHeapApi.MinHeap test7 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(
                                    991, -731, -882, 100, 280, -43, 432, 771, -581, 180, -382, -998, 847, 80, -220,
                                    680, 769, -75, -817, 366, 956, 749, 471, 228, -435, -269, 652, -331, -387, -657,
                                    -255, 382, -216, -6, -163, -681, 980, 913, -169, 972, -523, 354, 747, 805, 382,
                                    -827, -796, 372, 753, 519, 906)));

    MinHeapApi.MinHeap test8 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(
                                    544, -578, 556, 713, -655, -359, -810, -731, 194, -531, -685, 689, -279, -738,
                                    886, -54, -320, -500, 738, 445, -401, 993, -753, 329, -396, -924, -975, 376, 748,
                                    -356, 972, 459, 399, 669, -488, 568, -702, 551, 763, -90, -249, -45, 452, -917,
                                    394, 195, -877, 153, 153, 788, 844, 867, 266, -739, 904, -154, -947, 464, 343,
                                    -312, 150, -656, 528, 61, 94, -581)));

    MinHeapApi.MinHeap test9 =
            new MinHeapApi.MinHeap(
                    new ArrayList<Integer>(
                            Arrays.asList(
                                    -823, 164, 48, -987, 323, 399, -293, 183, -908, -376, 14, 980, 965, 842, 422, 829,
                                    59, 724, -415, -733, 356, -855, -155, 52, 328, -544, -371, -160, -942, -51, 700,
                                    -363, -353, -359, 238, 892, -730, -575, 892, 490, 490, 995, 572, 888, -935, 919,
                                    -191, 646, -120, 125, -817, 341, -575, 372, -874, 243, 610, -36, -685, -337, -13,
                                    295, 800, -950, -949, -257, 631, -542, 201, -796, 157, 950, 540, -846, -265, 746,
                                    355, -578, -441, -254, -941, -738, -469, -167, -420, -126, -410, 59)));

    public TestMinHeapApi() {
        test3.insert(76);
        test3.remove();
        test3.remove();
        test3.insert(87);
        test5.remove();
        test5.insert(-8);
        test5.remove();
        test5.insert(8);
        test7.remove();
        test7.remove();
        test7.remove();
        test7.insert(992);
        test9.insert(2);
        test9.insert(22);
        test9.insert(222);
        test9.insert(2222);
        test9.remove();
        test9.remove();
        test9.remove();
        test9.remove();
    }

    @Test
    public void TestCase1() {
        Assertions.assertTrue(Collections.min(test1.heap) == test1.heap.get(0));
        for (int currentIdx = test1.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test1.heap.get(currentIdx) >= test1.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase2() {
        Assertions.assertTrue(Collections.min(test2.heap) == test2.heap.get(0));
        for (int currentIdx = test2.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test2.heap.get(currentIdx) >= test2.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase3() {
        Assertions.assertTrue(Collections.min(test3.heap) == test3.heap.get(0));
        for (int currentIdx = test3.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test3.heap.get(currentIdx) >= test3.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase4() {
        Assertions.assertTrue(Collections.min(test4.heap) == test4.heap.get(0));
        for (int currentIdx = test4.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test4.heap.get(currentIdx) >= test4.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase5() {
        Assertions.assertTrue(Collections.min(test5.heap) == test5.heap.get(0));
        for (int currentIdx = test5.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test5.heap.get(currentIdx) >= test5.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase6() {
        Assertions.assertTrue(Collections.min(test6.heap) == test6.heap.get(0));
        for (int currentIdx = test6.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test6.heap.get(currentIdx) >= test6.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase7() {
        Assertions.assertTrue(Collections.min(test7.heap) == test7.heap.get(0));
        for (int currentIdx = test7.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test7.heap.get(currentIdx) >= test7.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase8() {
        Assertions.assertTrue(Collections.min(test8.heap) == test8.heap.get(0));
        for (int currentIdx = test8.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test8.heap.get(currentIdx) >= test8.heap.get(parentIdx));
        }
    }

    @Test
    public void TestCase9() {
        Assertions.assertTrue(Collections.min(test9.heap) == test9.heap.get(0));
        for (int currentIdx = test9.heap.size() - 1; currentIdx >= 0; currentIdx--) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                break;
            }
            Assertions.assertTrue(test9.heap.get(currentIdx) >= test9.heap.get(parentIdx));
        }
    }
}
