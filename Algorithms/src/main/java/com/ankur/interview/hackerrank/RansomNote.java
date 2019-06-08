package com.ankur.interview.hackerrank;

import java.util.Scanner;

/*
inputformat
6 4
give me one grand today night
give one grand today
Output yes No
 */
public class RansomNote {
     private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] magazine = new String[m];
        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }
        String[] note = new String[n];
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        checkMagazine(magazine, note);
        scanner.close();
    }

     static void checkMagazine(String[] magazine, String[] note) {

        // loop note first
         String[] words = new String[note.length];
         int[] counts = new int[note.length];
         int[] magazineCount = new int[note.length];
         for (int i = 0, j = 0; i < note.length; i++) {
             if (words[j].equals(note[i])) {
                 counts[j]++;
             } else {
                 j++;
                 words[j] = note[i];
                 counts[j] = 1;
             }
         }
         for (int j = 0; j < note.length; j++) {
             for (int i = 0; i < magazine.length; i++) {
                 if (note[j].equals(magazine[i])) {
                     magazineCount[j]++;
                 }
             }
         }
         boolean ransom = false;
         for (int i = 0; i < magazineCount.length; i++) {
             if (magazineCount[i] == 0) {
                 ransom = true;
                 break;
             }
         }
         if (ransom) {
             System.out.println("No");
         } else {
             System.out.println("Yes");
         }



/*         Map<String, Integer> map = new HashMap<>();
         for (String w : note) {
             Integer n = map.get(w);
             n = (n == null) ? 1 : ++n;
             map.put(w, n);
         }
         Map<String, Integer> map2 = new HashMap<>();
         for (String w : magazine) {
             Integer n = map2.get(w);
             n = (n == null) ? 1 : ++n;
             map2.put(w, n);
         }

         if(map2.entrySet().containsAll(map.entrySet())){
             System.out.println("Yes");
         }else{
             System.out.println("No");
         }*/

    }
}

