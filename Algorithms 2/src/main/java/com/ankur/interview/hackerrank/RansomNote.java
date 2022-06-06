package com.ankur.interview.hackerrank;

import java.util.Scanner;

/*
inputformat
6 4
give me one grand today night
give one one grand today
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
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        checkMagazine(magazine, note);
        scanner.close();
    }

     static void checkMagazine(String[] magazine, String[] note) {

        // loop note first
         // feq in note
         int[] noteCount = new int[note.length];
         int[] magazineCount  = new int[note.length];
         String[] words = new String[note.length];
         words[0]=note[0];
                noteCount[0]=1;
         for (int j = 1, i = 0; j < note.length; j++) {
                if(words[i].equals(note[j])){
                    noteCount[i]++;
                }else{
                    i++;
                    words[i]=note[j];
                    noteCount[i]=1;
                }
         }

         for(int i=0;i<note.length;i++) {
             for (int k = 0; k < magazine.length; k++) {
                 if (note[i].equals(magazine[k])) {
                    magazineCount[i]++;
                 }
             }
         }
         boolean ransom = false;
         for(int j=0;j<note.length;j++){
             if(noteCount[j]>magazineCount[j]){
                 ransom=true;
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

