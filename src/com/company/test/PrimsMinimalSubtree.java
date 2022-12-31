package com.company.test;

/*
Given a graph which consists of several edges connecting its nodes, find a subgraph of the given graph with the following properties:

The subgraph contains all the nodes present in the original graph.
The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
It is also required that there is exactly one, exclusive path between any two nodes of the subgraph.
One specific node  is fixed as the starting point of finding the subgraph using Prim's Algorithm.
Find the total weight or the sum of all edges in the subgraph.
 */
public class PrimsMinimalSubtree {

  private static final int V = 5;

  int minKey(int key[], boolean mstSet[]) {
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < V; v++) {
      if (mstSet[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }
    }

    return min_index;
  }

  void printMST(int parent[], int graph[][]) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < V; i++) {
      System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
  }

  void primMST(int graph[][]) {

    int parent[] = new int[V];

    int key[] = new int[V];

    boolean mstSet[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
    }

    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < V - 1; count++) {

      int u = minKey(key, mstSet);

      mstSet[u] = true;

      for (int v = 0; v < V; v++) {
        if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
      }
    }

    printMST(parent, graph);
  }

  public static void main(String[] args) {
		/* Let us create the following graph
		    2    3
		(0)--(1)--(2)
		|    / \   |
	 6|  8/   \5 |7
		|  /	   \ |
		(3)-------(4)
			    9
    */
    PrimsMinimalSubtree t = new PrimsMinimalSubtree();
    int graph[][] = new int[][] {
        {0, 2, 0, 6, 0},
        {2, 0, 3, 8, 5},
        {0, 3, 0, 0, 7},
        {6, 8, 0, 0, 9},
        {0, 5, 7, 9, 0}};

    t.primMST(graph);
  }
}

