package com.greenfox.ds;

import com.greenfox.ds.graph.GraphImpl;

class Main {

  public static void main(String... args) {
    GraphExample example = new GraphExample(new GraphImpl());
    example.buildGraph();
    example.printByDepthFirst();
  }
}
