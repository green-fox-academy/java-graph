package com.greenfox.ds;

import java.util.HashSet;
import com.greenfox.ds.graph.Graph;

public class GraphExample {

  private Graph graph;

  /*
   * I use dependency injection here, so my example class could work with any
   * implementation of the Graph interface.
   * 
   */
  public GraphExample(Graph g) {
    graph = g;
  }

  public void buildGraph() {
    graph.addVertex("Tom");
    graph.addVertex("Judy");
    graph.addVertex("Peter");
    graph.addVertex("Claire");
    graph.addVertex("John");
    graph.addVertex("Linda");
    graph.addEdge("Tom", "Judy");
    graph.addEdge("Tom", "Peter");
    graph.addEdge("Judy", "Claire");
    graph.addEdge("Claire", "Linda");
    graph.addEdge("Peter", "John");
  }

  public void printByDepthFirst() {
    HashSet<String> vertices = graph.getVerticesByDepthFirst("Tom");

    vertices
      .stream()
      .forEach(vertex -> System.out.println(vertex));
  }

}
