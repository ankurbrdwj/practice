package com.ankur.interview.hackerrank;

import java.util.*;

public class BreadthFirstSearch {

	private int[] distTo;
	private int[] edgeTo;
	private boolean[] marked;
	MYGraph graph;
	public BreadthFirstSearch() {
		// TODO Auto-generated constructor stub
	}

	public BreadthFirstSearch(MYGraph mg, int start) {
		// TODO Auto-generated constructor stub
		this.distTo=new int[mg.vertices];
		this.edgeTo=new int[mg.vertices];
		this.marked=new boolean[mg.vertices];
		bfs(mg,start);
	}

	private void bfs(MYGraph mg, int start) {
		// TODO Auto-generated method stub
		Queue q=new LinkedList<Integer>();
		for(int i=0;i<mg.vertices;i++)
			distTo[i]=0;
		distTo[start]=0;
		marked[start]=true;
		q.add(start);
		while(!q.isEmpty()){
			int v=(Integer) q.remove();
			for(int w:mg.adj.get(v)){
				if(!marked[w]){
				edgeTo[w]=v;
				distTo[w]=distTo[w]+6;
				marked[w]=true;
				q.add(w);
			}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i=0;i<t;i++){
		MYGraph mg=new MYGraph(scan);
		int start =scan.nextInt();
		BreadthFirstSearch BFS=new BreadthFirstSearch(mg,start);
		for(int j=0;j<BFS.distTo.length;j++)
			System.out.print(BFS.distTo[j]+" ");
		}
		System.out.println();
	}

}
class MYGraph{
int vertices;
int edges;
List<ArrayList<Integer>> adj;
	public MYGraph(Scanner scan) {
		// TODO Auto-generated constructor stub
		this(scan.nextInt());
		int edges=scan.nextInt();
		if(edges<0)throw new IllegalArgumentException("edges cannot be negative");
		int w=scan.nextInt();
		int v=scan.nextInt();
		for(int e=0;e<edges;e++)
		addEdge(w-1,v-1);
	}

	private void addEdge(int w, int v) {
		// TODO Auto-generated method stub
		 validateVertex(v);
	        validateVertex(w);
	        edges++;
	        adj.get(w).add(v);
	        adj.get(v).add(w);
		
	}

	private void validateVertex(int v) {
		// TODO Auto-generated method stub
	    if (v < 0 || v > vertices)
	        throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (vertices));

	}

	public MYGraph(int v) {
		// TODO Auto-generated constructor stub
		if(v<0)throw new IllegalArgumentException("vertices cannot be negative");
		this.edges=0;
		this.vertices=v;
		this.adj=new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<=v;i++){
		this.adj.add(new ArrayList<Integer>());
	}
	
}
}