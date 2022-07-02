package com.ankur.interview.practice.trees;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Median {
    static class ContinuousMedianHandler {
        double median = 0;
        Heap lowers = new Heap(Heap::MAX_HEAP_FUNC, new ArrayList<Integer>());
        Heap greaters = new Heap(Heap::MIN_HEAP_FUNC, new ArrayList<Integer>());

        public void insert(int number) {
            // Write your code here.
            if (lowers.length == 0 || lowers.peek() > number) {
                lowers.insert(number);
            } else {
                greaters.insert(number);
            }
            rebalanceHeaps();
            updateMedian();
        }

        private void updateMedian() {
            if (lowers.length == greaters.length) {
                median = ((double) lowers.peek() + (double) greaters.peek()) / 2;
            } else if (lowers.length > greaters.length) {
                median = lowers.peek();
            } else {
                median = greaters.peek();
            }
        }

        private void rebalanceHeaps() {
            if (lowers.length - greaters.length == 2) {
                greaters.insert(lowers.remove());
            } else if (greaters.length - lowers.length == 2) {
                lowers.insert(greaters.remove());
            }
        }

        public double getMedian() {
            return median;
        }

    }

    static class Heap {
        List<Integer> heap = new ArrayList<>();
        BiFunction<Integer, Integer, Boolean> compareFunction;
        int length;

        public Heap(BiFunction<Integer, Integer, Boolean> biFunction, List<Integer> array) {
            compareFunction = biFunction;
            heap = buildHeap(array);
            length = heap.size();
        }

        private List<Integer> buildHeap(List<Integer> array) {
            int first = (array.size() - 2) / 2;
            for (int current = first; current >= 0; current--) {
                siftDown(current, array.size() - 1, array);
            }
            return array;
        }

        private void siftDown(int current, int end, List<Integer> array) {
            int left = current * 2 + 1;
            while (left <= end) {
                int right = current * 2 + 2 <= end ? current * 2 + 2 : -1;
                int toSwap;
                if (right != -1 && compareFunction.apply(array.get(right), array.get(left)))
                    toSwap = right;
                else
                    toSwap = left;
                if (compareFunction.apply(array.get(toSwap), array.get(current))) {
                    swap(toSwap, current, array);
                    current = toSwap;
                    left = current * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void siftUp(int current, List<Integer> array) {
            int parent = (current - 1) / 2;
            while (current > 0) {
                if (compareFunction.apply(heap.get(current), heap.get(parent))) {
                    swap(current, parent, array);
                    current = parent;
                    parent = (current - 1) / 2;
                } else {
                    return;
                }
            }
        }

        private void swap(int toSwap, int current, List<Integer> array) {
            int temp = array.get(toSwap);
            array.set(toSwap, array.get(current));
            array.set(current, temp);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            length--;
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            length++;
            siftUp(heap.size() - 1, heap);
        }

        public static Boolean MIN_HEAP_FUNC(Integer a, Integer b) {
            return a < b;
        }

        public static Boolean MAX_HEAP_FUNC(Integer a, Integer b) {
            return a > b;
        }

        public Integer peek() {
            return heap.get(0);
        }
    }
}
