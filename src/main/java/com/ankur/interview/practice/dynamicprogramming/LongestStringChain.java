package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
    static class StringChain {
      String nextString;
      Integer maxChainLength;
      public StringChain(String nextString,Integer length){
        this.nextString = nextString;
        this.maxChainLength= length;
      }

    }

    public static List<String> longestStringChain(List<String> strings) {
      // Write your code here.
      //  get them in map ,
      Map<String,StringChain> map = new HashMap<>();
      for(String item:strings){
        map.put(item,new StringChain("",1));
      }
       /* We will build from smallest string
      as we will just add these chains if found
      every string has its unique chain
      it might be repetitive but they are seperate
      "abcd" abcd -> abd -> ab -> a
      "abd"  abd -> ab -> a/
       */
      List<String> sortedStrings= new ArrayList<>(strings);
      sortedStrings.sort(Comparator.comparingInt(String::length));

      for(String item:sortedStrings){
        findLongestStringChain(item,map);
      }

      return buildLongestChain(strings,map);
    }
    public static void findLongestStringChain(String string ,Map<String,StringChain> map)
    {
      for(int i=0;i<string.length();i++){
        //Remove every single character for each string
        String smallerString = getSmallerString(string,i);
        if(!map.containsKey(smallerString)) continue;
        //if its in list the build chain
        tryUpdateLongestStringChain(string,smallerString,map);
      }
    }
    public static String getSmallerString(String string,int index){
      return string.substring(0,index)+string.substring(index+1);
    }
    public static void tryUpdateLongestStringChain(String string,String smallerString,Map<String,StringChain> map){
      int smallChainLength = map.get(smallerString).maxChainLength;
      int currentChainLength = map.get(string).maxChainLength;
      // if the length makes difference just add the chain as this is longer
      if(smallChainLength + 1> currentChainLength){
        map.get(string).maxChainLength = smallChainLength+1;
        map.get(string).nextString = smallerString;
      }
    }
    public static List<String> buildLongestChain( List<String> strings,Map<String,StringChain> stringChains
    ){
      int maxChainLength = 0;
      String chainStartString = "";
      // find the largest length
      for(String item:strings){
        if(stringChains.get(item).maxChainLength >maxChainLength){
          maxChainLength = stringChains.get(item).maxChainLength;
          chainStartString = item;
        }
      }
      List<String> longest = new ArrayList<>();
      // from the longest above build the chian
      String currentString = chainStartString;
      while(currentString!=""){
        longest.add(currentString);
        currentString = stringChains.get(currentString).nextString;
      }
      return longest.size()==1? new ArrayList<>():longest;
    }
  }

