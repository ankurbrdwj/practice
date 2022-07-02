package com.ankur.interview.practice.strings;

public class PermuteString {
    static void permute(String input)
    {
        int n = input.length();

        // Number of permutations is 2^n
        int max = 1 << n;

        // Converting string to lower case
        input = input.toLowerCase();

        // Using all subsequences and permuting them
        for(int i = 0;i < max; i++)
        {
            char combination[] = input.toCharArray();

            // If j-th bit is set, we convert it to upper case
            for(int j = 0; j < n; j++)
            {
                if(((i >> j) &  1) == 1)
                    combination[j] = (char) (combination[j]-32);
            }

            // Printing current combination
            System.out.print(combination);
            System.out.print("   ");
        }
    }

    public static void main(String[] args)
    {
        permute("ABC");
    }
}
