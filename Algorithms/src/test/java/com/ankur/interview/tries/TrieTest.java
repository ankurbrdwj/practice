package com.ankur.interview.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieTest{
    @Test
    void whenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        Trie trie = createExampleTrie();

        assertTrue(trie.search("Programming"));
        trie.delete("Programming");
        assertFalse(trie.search("Programming"));
    }


    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        return trie;
    }
}