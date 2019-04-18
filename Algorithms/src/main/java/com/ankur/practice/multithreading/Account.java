/**
 * 
 */
package com.ankur.interview.multithreading;

import java.math.BigDecimal;

/**
 * @author ankurbrdwj
 *
 */
public class Account {
	private int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
