package com.ankur.interview.multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeLock {

	public SafeLock() {
		// TODO Auto-generated constructor stub

	}

	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			this.name = name;
		}

		public boolean impendingBow(Friend bower) {
			Boolean myLock = false;
			Boolean yourLock = false;
			try {
				myLock = lock.tryLock();
				yourLock = bower.lock.tryLock();

			} finally {
				if (!(myLock && yourLock)) {
					if (myLock)
						lock.unlock();
					if (yourLock)
						bower.lock.unlock();
				}

			}
			return myLock && yourLock;
		}

		public void bow(Friend bower) {
			if (impendingBow(bower)) {
				try {
					System.out.format("%s: %s has" + " bowed to me!%n", this.name, bower.getName());
					bower.bowBack(this);
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				System.out.format("%s: %s has started to bow but he saw i already bowing to him %n ", this.name,
						bower.getName());
			}
		}

		private void bowBack(Friend bower) {
			// TODO Auto-generated method stub
			System.out.format("%s: %s has" + " bowed to me!%n", this.name, bower.getName());

		}

		private String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			final Friend alphonse =
		            new Friend("Alphonse");
		        final Friend gaston =
		            new Friend("Gaston");
		        new Thread(new BowLoop(alphonse, gaston)).start();
		        new Thread(new BowLoop(gaston, alphonse)).start();

		}
		static class BowLoop implements Runnable {
	        private Friend bower;
	        private Friend bowee;

	        public BowLoop(Friend bower, Friend bowee) {
	            this.bower = bower;
	            this.bowee = bowee;
	        }

	        public void run() {
	            Random random = new Random();
	            for (;;) {
	                try {
	                    Thread.sleep(random.nextInt(10000));
	                } catch (InterruptedException e) {}
	                bowee.bow(bower);
	            }
	        }
	    }
	}
}
