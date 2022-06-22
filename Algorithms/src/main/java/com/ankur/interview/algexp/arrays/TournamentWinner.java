package com.ankur.interview.algexp.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String,Integer> winner = new HashMap<String,Integer>();
        String key = "";
        int max = 0 ;
        for( int i = 0 ; i< results.size() ; i++){
            int won= results.get(i);
            if(won == 0) {
                key = competitions.get(i).get(1);
            } else {
                key = competitions.get(i).get(0);
            }
            if(winner.containsKey(key)){
                winner.put(key,winner.get(key)+3);
                if(max < winner.get(key)){
                    max = winner.get(key);
                }
            } else {
                winner.put(key,3);
            }
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : winner.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        System.out.println(TournamentWinner.tournamentWinner(competitions,results));

    }
}
