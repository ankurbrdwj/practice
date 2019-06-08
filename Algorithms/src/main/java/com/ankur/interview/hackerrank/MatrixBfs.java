package com.ankur.interview.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MatrixBfs {
	private int[] distTo;
	private int[] edgeTo;
	private boolean[] marked;

	public MatrixBfs(MatrixGraph mg, int start) {
		// TODO Auto-generated constructor stub
		distTo = new int[mg.getVertices() + 1];
		edgeTo = new int[mg.getVertices() + 1];
		marked = new boolean[mg.getVertices() + 1];
		bfs(mg, start);
	}

	private void bfs(MatrixGraph mg, int start) {
		// TODO Auto-generated method stub
		Queue q = new LinkedList<Integer>();
		//int i = 0;
		for (int j = 0; j < mg.getVertices() + 1; j++)
			distTo[j] = 0;
		distTo[start] = 0;
		marked[start] = true;
		q.add(start);
		while (!q.isEmpty()) {
			int v = (Integer) q.poll();
			// for(boolean w:mg.getAdjMatrix()[v]){
			for (int i=0;i<= mg.getVertices();i++)
				if (marked[i]==false && mg.getAdjMatrix()[v][i] == 1) {
					edgeTo[i] = v;
					distTo[i] = distTo[v] + 6;
					marked[i] = true;
					q.add(i);
				}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int v = scan.nextInt();
			int e = scan.nextInt();
			MatrixGraph mg = new MatrixGraph(v, e);
			for (int n = 0; n < e; n++) {
				int to = scan.nextInt();
				int from = scan.nextInt();
				mg.addEdge(to, from);
			}
			int start = scan.nextInt();
			MatrixBfs BFS = new MatrixBfs(mg, start);
			for (int j = 1; j < BFS.distTo.length; j++){
				if(j==start)continue;
				if(BFS.distTo[j]!=0)
				System.out.print(BFS.distTo[j] + " ");
				else
					System.out.print(-1+" ");
			}
			System.out.println();

		}
	}
}
