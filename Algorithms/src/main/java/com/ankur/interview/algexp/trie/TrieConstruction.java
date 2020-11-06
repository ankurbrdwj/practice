package com.ankur.interview.algexp.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String word) {
            for(int j=0;j<word.length();j++){
                insert(j,word);
            }
        }

        private  void  insert(int j,String word){
            TrieNode current = root;
            for (int i = j; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.children.containsKey(ch)) {
                    TrieNode newNode = new TrieNode();
                    current.children.put(ch, newNode);
                }
                current = current.children.get(ch);
            }
            //mark the current nodes endOfWord as *
            current.children.put(endSymbol,null);
        }

        public boolean contains(String str) {
            TrieNode current= root;
            for (int i=0;i<str.length();i++){
                char c= str.charAt(i);
                TrieNode node = current.children.get(c);
                if(node==null){
                    return false;
                }else{
                    current= node;
                }
            }
            return current.children.containsKey(endSymbol);
        }
    }




    public static void main(String[] args) {
        TrieConstruction.SuffixTrie trie= new SuffixTrie("babc");
        System.out.println(trie.contains("abc"));
    }
}
