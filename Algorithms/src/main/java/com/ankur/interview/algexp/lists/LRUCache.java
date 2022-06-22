package com.ankur.interview.algexp.lists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<String, DoublyCacheList.CacheNode> cache = new HashMap<String, DoublyCacheList.CacheNode>();
    int maxSize;
    int currentSize = 0;
    private DoublyCacheList listOfMostRecent = new DoublyCacheList();

    public LRUCache(int maxSize) {
        this.maxSize = Math.max(maxSize, 1);
    }

    public void insertKeyValuePair(String key, int value) {
        if (!cache.containsKey(key)) {
            if (currentSize == maxSize) {
                evictLastRecent();
            } else {
                currentSize++;
            }
            cache.put(key, new DoublyCacheList.CacheNode(key, value));
        } else {
            replaceKey(key, value);
        }
        updateMostRecent(cache.get(key));
    }

    public LRUResult getValueFromKey(String key) {
        if (!cache.containsKey(key)) {
            return new LRUResult(false, -1);
        } else {
            updateMostRecent(cache.get(key));
            return new LRUResult(true, cache.get(key).value);
        }
    }

    public String getMostRecentKey() {
        if (listOfMostRecent.head == null) {
            return "";
        }
        return listOfMostRecent.head.key;
    }

    public void evictLastRecent() {
        String keyToRemove = listOfMostRecent.tail.key;
        listOfMostRecent.removeTail();
        cache.remove(keyToRemove);
    }

    public void updateMostRecent(DoublyCacheList.CacheNode node) {
        listOfMostRecent.setHeadTo(node);
    }

    public void replaceKey(String key, int value) {
        if (!cache.containsKey(key)) {
            return;
        }
        cache.get(key).value = value;
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean b, int i) {
            this.found = b;
            this.value = i;
        }
    }
}

