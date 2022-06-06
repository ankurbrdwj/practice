package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class Conditions {

	public Conditions() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String... args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		String ans = "";

		// if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
		if (n % 2 == 1) {
			ans = "Weird";
		} else {
			// Complete the code
			if (n % 2 == 0) {
				if (2 <= n && n <= 5)
					ans = "Not Weird";
				if (6 < n && n <= 20)
					ans = "Weird";
				if (n > 20)
					ans = "Not Weird";
			}
		}
		System.out.println(ans);
	}

}
