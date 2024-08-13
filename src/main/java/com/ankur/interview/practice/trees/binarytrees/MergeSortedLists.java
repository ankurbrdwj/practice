package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        List<Integer> result = new ArrayList();
        List<Item> smallItems = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            smallItems.add(new Item(i, 0, arrays.get(i).get(0)));
        }
        MinHeap minHeap = new MinHeap(smallItems);
        while (!minHeap.isEmpty()) {
            Item smallest = minHeap.remove();
            result.add(smallest.num);
            if (smallest.elementIdx >= arrays.get(smallest.arrayIdx).size() - 1) continue; // we finished a row.
            minHeap.insert(
                    new Item(smallest.arrayIdx,
                            smallest.elementIdx + 1,  // next from row
                            arrays.get(smallest.arrayIdx).get(smallest.elementIdx + 1))
            );

        }
        return result;
    }

    static class Item {
        int arrayIdx;
        int elementIdx;
        int num;

        public Item(int arrayIdx, int elementIdx, Integer integer) {
            this.arrayIdx = arrayIdx;
            this.elementIdx = elementIdx;
            this.num = integer;
        }
    }

    static class MinHeap {
        List<Item> heap = new ArrayList<>();

        public MinHeap(List<Item> array) {
            heap = buildHeap(array);
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        private List<Item> buildHeap(List<Item> array) {
            int first = (array.size() - 2) / 2;
            for (int currentIdx = first; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        private void siftDown(int currentIdx, int end, List<Item> array) {
            int left = currentIdx * 2 + 1;
            while (left <= end) {
                int right = currentIdx * 2 + 2 <= end ? currentIdx * 2 + 2 : -1;
                int toSwap;
                if (right != -1 && array.get(right).num < array.get(left).num) {
                    toSwap = right;
                } else {
                    toSwap = left;
                }
                if (array.get(toSwap).num < array.get(currentIdx).num) {
                    swap(toSwap, currentIdx, array);
                    currentIdx = toSwap;
                    left = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        private void swap(int toSwap, int currentIdx, List<Item> array) {
            Item temp = array.get(toSwap);
            array.set(toSwap, array.get(currentIdx));
            array.set(currentIdx, temp);
        }

        public void insert(Item item) {
            heap.add(item);
            siftUp(heap.size() - 1, heap);
        }

        private void siftUp(int current, List<Item> heap) {
            int parent = (current - 1) / 2;
            while (current > 0 && heap.get(current).num < heap.get(parent).num) {
                swap(current, parent, heap);
                current = parent;
                parent = (current - 1) / 2;
            }
        }

        public Item remove() {
            swap(0, heap.size() - 1, heap);
            Item itemToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return itemToRemove;
        }
    }
}
