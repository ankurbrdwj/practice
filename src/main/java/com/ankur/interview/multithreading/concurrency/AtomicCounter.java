package com.ankur.interview.multithreading.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private AtomicInteger count = new AtomicInteger();

	public void increment() {
		count.getAndIncrement(); // atomic operation
	}

	public int getValue() {
		return count.intValue();
	}
}
