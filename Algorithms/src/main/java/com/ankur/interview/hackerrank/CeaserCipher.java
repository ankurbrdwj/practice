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
        String encrypted = encryptCeaserCipher(s, k);
        System.out.println(encrypted);
        String decrypted = decryptCeaserCipher(encrypted, k);
        System.out.println(decrypted);

    }

    private static String decryptCeaserCipher(String input, int k) {
        char[] ch2 = input.toCharArray();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(ch2[i])) {
                char ch4;
                if (((int) ch2[i] - k) < 97) {
                    ch4 = (char) (((int) ch2[i] - k - 97 + 26) % 26 + 97);
                } else {
                    ch4 = (char) (((int) ch2[i] - k - 97) % 26 + 97);
                }
                str2.append(ch4);
            } else if (ch2[i] == ' ') {
                str2.append(ch2[i]);
            }
        }
        return str2.toString();
    }

    private static String encryptCeaserCipher(String input, int k) {
        char[] ch1 = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : ch1) {
            if (Character.isLetter(c)) {
                char ch3 = (char) (((int) c + k - 97) % 26 + 97);
                result.append(ch3);
            } else if (c == ' ') {
                result.append(c);
            }
        }
        return result.toString();
    }
}
