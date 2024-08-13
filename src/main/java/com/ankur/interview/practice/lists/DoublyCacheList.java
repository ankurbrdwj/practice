package com.ankur.interview.practice.lists;

public class DoublyCacheList {
    CacheNode head;
    CacheNode tail;

    public void setHeadTo(CacheNode node) {
        if (head == node) {
            return;
        } else if (head == null) {
            head = node;
            tail = node;
        } else if (head == tail) {
            tail.prev = node;
            head = node;
            head.next = node;
        } else {
            if (tail == node) {
                removeTail();
            }
            node.removeBindings();
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    void removeTail() {
        if (tail == null) {
            return;
        }
        if (tail == head) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    static class CacheNode {
        String key;
        int value;
        CacheNode prev;
        CacheNode next;

        public CacheNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            prev = null;
            next = null;
        }


    }

}

