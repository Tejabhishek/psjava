package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.graph.dfs.AllSourceDFS;
import org.psjava.algo.graph.dfs.DFSCore;
import org.psjava.algo.graph.dfs.DFSVisitor;
import org.psjava.algo.graph.dfs.DFSVisitorBase;
import org.psjava.algo.graph.dfs.MultiSourceDFS;
import org.psjava.algo.graph.dfs.SingleSourceDFS;
import org.psjava.ds.graph.AdjacencyList;
import org.psjava.ds.graph.AdjacencyListFromGraph;
import org.psjava.ds.graph.DirectedEdge;
import org.psjava.ds.graph.MutableDirectedGraph;
import org.psjava.util.VarargsIterable;
import org.psjava.util.VisitorStopper;

/**
 * @implementation {@link DFSCore}
 * @see {@link BreadthFirstSearchExample}
 */
public class DepthFirstSearchExample {

	@Test
	public void example() {

		// Let's prepare a simple graph.

		MutableDirectedGraph<String> graph = MutableDirectedGraph.create();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");

		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("C", "A");

		// Use 'Visitor' for handling searching events.
		// Here, we will find the back-edge in the graph.

		AdjacencyList<String, DirectedEdge<String>> adj = AdjacencyListFromGraph.create(graph);

		SingleSourceDFS.traverse(adj, "A", new DFSVisitor<String, DirectedEdge<String>>() {
			@Override
			public void onDiscovered(String vertex, int depth, VisitorStopper stopper) {
			}

			@Override
			public void onWalkDown(DirectedEdge<String> edge) {
			}

			@Override
			public void onBackEdgeFound(DirectedEdge<String> edge) {
				// Found! the edge:C->A is a back-edge.
				edge.from(); // must be "C"
				edge.to(); // must be "A";
				Assert.assertEquals("C", edge.from());
				Assert.assertEquals("A", edge.to());
			}

			@Override
			public void onFinish(String vertex, int depth) {
			}

			@Override
			public void onWalkUp(DirectedEdge<String> downedEdge) {
			}
		});

		// You can do DFS from multiple sources.

		MultiSourceDFS.traverse(adj, VarargsIterable.create("A", "B"), new DFSVisitorBase<String, DirectedEdge<String>>());

		// If you don't mind visiting order but want to visit all, do this.

		AllSourceDFS.traverse(graph, new DFSVisitorBase<String, DirectedEdge<String>>());
	}
}
