package com.ankur.interview.threads.concurrency;
public class IncrementThread extends Thread {
	private AtomicCounter counter;

	// all instances are passed the same counter
	public IncrementThread(AtomicCounter counter) {
		this.counter = counter;
	}

	public void run() {
		// "i" is local and thread-safe
		for (int i = 0; i < 10000; i++) {
			counter.increment();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			AtomicCounter counter = new AtomicCounter(); // the shared object
			IncrementThread it1 = new IncrementThread(counter);
			IncrementThread it2 = new IncrementThread(counter);
			it1.start(); // thread 1 increments the count by 10000
			it2.start(); // thread 2 increments the count by 10000
			it1.join();
			it2.join(); // wait for thread 2 to finish
			System.out.println(counter.getValue()); // rarely 20000
			// lowest 11972
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for thread 1 to finish
		
	}
}