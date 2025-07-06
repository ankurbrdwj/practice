package com.ankur.interview.practice.heaps;

import java.util.ArrayList;
import java.util.List;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
public class MinHeapApi {
    public static class MinHeap {
        public List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int first = (array.size() - 2) / 2; // the root
            for (int current = first; current >= 0; current--) {
                siftDown(current, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int leftChild = currentIdx * 2 + 1;
            while (leftChild <= endIdx) {
                int rightChild = (currentIdx * 2 + 2) <= endIdx ? currentIdx * 2 + 2 : -1;
                int toSwap = 0;
                if (rightChild != -1 && heap.get(rightChild) < heap.get(leftChild))
                    toSwap = rightChild;
                else
                    toSwap = leftChild;
                if (heap.get(toSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, toSwap, heap);
                    currentIdx = toSwap;
                    leftChild = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }

        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            this.siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            this.siftUp(heap.size() - 1, heap);
        }

        private void swap(int first, int second, List<Integer> heap) {
            Integer temp = heap.get(first);
            heap.set(first, heap.get(second));
            heap.set(second, temp);
        }
    }
}


