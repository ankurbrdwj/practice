/**
 * 
 */
package com.ankur.interview.multithreading;

import java.math.BigDecimal;

/**
 * @author ankurbrdwj
 *
 */
class Producer extends Thread {
	private BankAccount account;

	public Producer(BankAccount acct) {
		account = acct;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			account.deposit(10);
		}
	}

	@Override
	public String toString() {
		return "Producer [account=" + account + "]";
	}

}
