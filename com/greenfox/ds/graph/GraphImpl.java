package com.greenfox.ds.graph;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;

public class GraphImpl implements Graph {

  private HashMap<String, List<String>> vertices;

  public GraphImpl() {
    this.vertices = new HashMap<String, List<String>>();
  }

  public void addVertex(String vertexLabel) {
    this.vertices.putIfAbsent(vertexLabel, new ArrayList<String>());
  }

  public void removeVertex(String vertexLabel) {
    this.vertices.remove(vertexLabel);
    this.vertices
      .values()
      .forEach(neighbours -> neighbours.remove(vertexLabel));
  }

  public List<String> getNeighbours(String vertexLabel) {
    return this.vertices.get(vertexLabel);
  }

  public void addEdge(String vertexLabel1, String vertexLabel2) {
    this.vertices.get(vertexLabel1).add(vertexLabel2);
    this.vertices.get(vertexLabel2).add(vertexLabel1);
  }

  public void removeEdge(String vertexLabel1, String vertexLabel2) {
    this.vertices.get(vertexLabel1).remove(vertexLabel2);
    this.vertices.get(vertexLabel2).remove(vertexLabel1);
  }

  public HashSet<String> getVerticesByDepthFirst(String root) {
    HashSet<String> visited = new HashSet<String>();
    Stack<String> stack = new Stack<String>();

    stack.push(root);
    while (!stack.isEmpty()) {
      String vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        for(String neighbour : this.getNeighbours(vertex)) {
          stack.push(neighbour);
        }
      }
    }

    return visited;
  }
}
