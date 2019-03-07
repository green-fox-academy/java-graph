package com.greenfox.ds.graph;

import java.util.List;
import java.util.HashSet;

public interface Graph {
  void addVertex(String vertexLabel);
  void removeVertex(String vertexLabel);
  List<String> getNeighbours(String vertexLabel);
  void addEdge(String vertexLabel1, String vertexLabel2);
  void removeEdge(String vertexLabel1, String vertexLabel2);

  HashSet<String> getVerticesByDepthFirst(String root);
}
