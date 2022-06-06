package com.ankur.interview.hackerrank;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
public class FutureTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter directory (e.g. /usr/local/jdk7.0/src): ");
		String dir = input.nextLine();
		System.out.print("Please enter keyword (e.g. myFile): ");
		String keyword = input.nextLine();
		MatchCounter countFiles = new MatchCounter(new File(dir), keyword);
		FutureTask<Integer> tsk = new FutureTask<Integer>(countFiles);
		Thread thread = new Thread(tsk);
		thread.start();
		try {
			System.out.println(tsk.get() + " matching files.");
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
	}
}
/**
 * This task counts the files in a directory and its subdirectories that contain
 * a given keyword.
 */
class MatchCounter implements Callable<Integer> {
	/**
	 * dir the directory in which to start the searc
	 * keyword the keyword to look for* 
	 */
	private File dir;
	private String keyword;
	private int counter;
	public MatchCounter(File directory, String keyword) {
		this.dir = directory;
		this.keyword = keyword;
	}

	public Integer call() {
		counter = 0;
		try {
			File[] files = dir.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
			for (File file : files) {
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				} else {
					if (search(file)) {
						counter++;
					}
				}
			}
			for (Future<Integer> result : results) {
				try {
					counter += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
		}
		return counter;
	}
	/** 
	 * Searches a file for a given keyword.
	 * file the file to search
	 * returns true if the keyword is contained in the file
	 */
	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			String line="";
			while (!found && in.hasNextLine()) {
				line = in.nextLine();
				if (line.contains(keyword)) {
					found = true;
				}
			}
			in.close();
			return found;
		} catch (IOException e) {
			return false;
		}
	}
}