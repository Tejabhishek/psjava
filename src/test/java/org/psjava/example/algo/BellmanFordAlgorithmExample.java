package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.shortestpath.BellmanFord;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

/**
 * @implementation {@link BellmanFord}
 * @see {@link ShortestPathAlgorithmExample}
 * @see {@link DijkstraAlgorithmExample}
 */
public class BellmanFordAlgorithmExample {

	@Test
	public void example() {

		// Let's construct a simple graph which contains negatively weighted edge.

		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.addEdge("A", "C", 10);
		graph.addEdge("A", "B", 15);
		graph.addEdge("B", "C", -10); // negative weight !

		// Then calculate distances from a single source 'A'

		SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result1 = new BellmanFord().calc(graph, "A", IntegerNumberSystem.getInstance());

		boolean reachabilityOfC = result1.isReachable("C"); // must be true
		Assert.assertTrue(reachabilityOfC);
		int distanceAToC = result1.getDistance("C"); // must be 5
		Assert.assertEquals(5, distanceAToC);
	}
}