package com.ankur.interview.algoexpert.dynamicprogramming;

public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int m=str1.length();
        int n=str2.length();
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();
        int [][] edits = new int [m+1][n+1];
        edits[0][0]=0;
        for(int i=1;i<=m;i++){
            edits[i][0]=edits[i-1][0]+1;
            for(int j=1;j<=n;j++){
                if(char1[i-1]==char2[j-1]){
                    edits[i][j]=edits[i-1][j-1];
                }else{
                    edits[i][j]=1+min(edits[i-1][j-1],edits[i-1][j],edits[i][j-1]);
                }
            }
        }
        return edits[m][n];
    }

    private static int min(int i , int j, int k){
        int temp= Math.min(i,j);
        return Math.min(temp,k);
    }

    public int dynamicEditDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];

        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }

        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }

        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        printActualEdits(temp, str1, str2);
        return temp[str1.length][str2.length];

    }

    /**
     * Prints the actual edits which needs to be done.
     */
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    public static void main(String args[]){
        String str1 = "";
        String str2 = "abc";
        LevenshteinDistance editDistance = new LevenshteinDistance();
        int result = editDistance.dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
}
