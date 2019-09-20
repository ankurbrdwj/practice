/**
 *
 */
package com.ankur.interview.hackerrank;

import java.util.Scanner;

/**
 * @author ankurbrdwj
 *
 */
public class CeaserCipher {

    /**
     *
     */
    public CeaserCipher() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        System.out.println(getCeaserCipher(s, k));

    }

    private static String getCeaserCipher(String input, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
                int ascii = input.charAt(i);
                if (ascii > 64 && ascii < 91) {
					char ch = (char) ((ascii + k - 65) % 26 + 65);
					builder.append(ch);
				} else if (ascii > 96 && ascii < 123) {
					char ch = (char)((ascii + k - 97) % 26 + 97);
					builder.append(ch);
				}else{
					builder.append(input.charAt(i));
				}
            }
        return builder.toString();
    }
}
