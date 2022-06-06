package com.ankur.interview.algexp.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.ankur.interview.algexp.lists.LRUCache.*;

public class TestLRUCache {

    @Test
    public void testLRUCache(){
        LRUCache cache= new LRUCache(3);
        cache.insertKeyValuePair("a",1);
        cache.insertKeyValuePair("b",2);
        cache.insertKeyValuePair("c",3);
        Assertions.assertSame("c", cache.getMostRecentKey());
        assert cache.getValueFromKey("a") != null;
        Assertions.assertSame(1, cache.getValueFromKey("a").value);
        Assertions.assertSame("a", cache.getMostRecentKey());
        cache.insertKeyValuePair("d",4);
        //Assertions.assertSame(null, cache.getValueFromKey("b").value);
        cache.insertKeyValuePair("a",5);
        Assertions.assertSame(5, cache.getValueFromKey("a").value);
    }
}
