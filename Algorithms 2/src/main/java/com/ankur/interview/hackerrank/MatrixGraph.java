package com.ankur.interview.hackerrank;

public class MatrixGraph {

	private int vertices;
	private int edges;
	private int[][] adjMatrix;
	
	public MatrixGraph(int v,int e) {
		// TODO Auto-generated constructor stub
		this.vertices=v;
		this.edges=e;
		this.adjMatrix=new int[v+1][v+1];
	}
	public void addEdge(int w,int v){
	valildateVertex(w);
	valildateVertex(v);
	adjMatrix[w][v]=1;
	adjMatrix[v][w]=1;
}
	private void valildateVertex(int v) {
	// TODO Auto-generated method stub
		  if (v < 0 || v > vertices)
		        throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (vertices));

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * @return the vertices
	 */
	public int getVertices() {
		return vertices;
	}
	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}
	/**
	 * @return the edges
	 */
	public int getEdges() {
		return edges;
	}
	/**
	 * @param edges the edges to set
	 */
	public void setEdges(int edges) {
		this.edges = edges;
	}
	/**
	 * @return the adjMatrix
	 */
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	/**
	 * @param adjMatrix the adjMatrix to set
	 */
	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

}
