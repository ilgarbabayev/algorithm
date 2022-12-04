package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacentGraph {
  public static void main(String[] args) {
    GraphA graphA = new GraphA();
    graphA.addNode(new NodeA('A'));
    graphA.addNode(new NodeA('B'));
    graphA.addNode(new NodeA('C'));
    graphA.addNode(new NodeA('D'));
    graphA.addNode(new NodeA('E'));

    graphA.addEdge(0, 1);
    graphA.addEdge(1, 2);
    graphA.addEdge(1, 4);
    graphA.addEdge(2, 3);
    graphA.addEdge(2, 4);
    graphA.addEdge(4, 0);
    graphA.addEdge(4, 2);

    graphA.print();

    System.out.println(graphA.checkEdge(3, 2));
  }
}

class GraphA {

  ArrayList<LinkedList<NodeA>> aList;

  public GraphA() {
    aList= new ArrayList<>();
  }

  public void addNode(NodeA nodeA) {
    LinkedList<NodeA> currentList = new LinkedList<>();
    currentList.add(nodeA);
    aList.add(currentList);
  }

  public void addEdge(int src, int dst) {
    LinkedList<NodeA> currentList = aList.get(src);
    NodeA dstNode = aList.get(dst).get(0);
    currentList.add(dstNode);
  }

  public boolean checkEdge(int src, int dst) {
    LinkedList<NodeA> currentList = aList.get(src);
    NodeA dstNode = aList.get(dst).get(0);

    for(NodeA nodeA : currentList) {
      if (nodeA == dstNode) {
        return true;
      }
    }
    return false;
  }

  public void print() {
    for (LinkedList<NodeA> currentList : aList) {
      for (NodeA nodeA : currentList) {
        System.out.print(nodeA.data + " -> ");
      }
      System.out.println();
    }
  }
}

class NodeA {
  char data;

  public NodeA(char data) {
    this.data = data;
  }
}
