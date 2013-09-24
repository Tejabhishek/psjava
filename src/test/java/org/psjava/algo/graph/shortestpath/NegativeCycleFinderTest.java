package org.psjava.algo.graph.shortestpath;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.algo.graph.shortestpath.NegativeCycleFinder;
import org.psjava.ds.graph.TestGraphFactory;
import org.psjava.javautil.IterableToString;
import org.psjava.math.ns.IntegerNumberSystem;

public class NegativeCycleFinderTest {

	@Test
	public void testNegativeCycle() {
		int[][] data = { { 1, 2, 1 }, { 2, 3, -4 }, { 3, 4, 1 }, { 4, 2, 1 } };
		NegativeCycleFinderResult<Integer, Integer> r = NegativeCycleFinder.find(TestGraphFactory.create(data), IntegerNumberSystem.getInstance());
		assertTrue(r.hasCycle());
		assertEquals("(3->4(1),4->2(1),2->3(-4))", IterableToString.toString(r.getPath()));
	}

	@Test
	public void testSizeOne() {
		int[][] data = { { 1, 1, -1 } };
		NegativeCycleFinderResult<Integer, Integer> r = NegativeCycleFinder.find(TestGraphFactory.create(data), IntegerNumberSystem.getInstance());
		assertTrue(r.hasCycle());
		assertEquals("(1->1(-1))", IterableToString.toString(r.getPath()));
	}

}
