package com.ankur.java8.data;

import java.util.Random;

/**
 * 
 */

/**
 * @author ankurbrdwj
 *
 */
public class MoodTestData {
private final String[] POSSIBLE_MOODS={"Happy","Sad","Happy,Sad"};
	/**
	 * 
	 */
	public MoodTestData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Random random=new Random();
new StubService("/moods/",8082,()->POSSIBLE_MOODS[random.nextInt(3)]).run();
	}

}
