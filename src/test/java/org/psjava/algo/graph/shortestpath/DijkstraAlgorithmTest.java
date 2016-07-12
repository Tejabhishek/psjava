package org.psjava.algo.graph.shortestpath;

import org.junit.Test;
import org.psjava.algo.DijkstraAlgorithmV2;
import org.psjava.algo.SingleSourceShortestPathAlgorithmV2;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.goods.GoodMutableMapFactory;

public class DijkstraAlgorithmTest {

    private static final SingleSourceShortestPathAlgorithmV2 INSTANCE = DijkstraAlgorithmV2.getInstance(BinaryHeapFactory.getInstance(), GoodMutableMapFactory.getInstance());

    @Test
    public void testSizeOneGraph() {
        SingleSourceShortestPathTestCommon.testSizeOneGraph(INSTANCE);
    }

    @Test
    public void testNotReachableVertex() {
        SingleSourceShortestPathTestCommon.testNotReachableVertex(INSTANCE);
    }

    @Test
    public void testCLRSExample() {
        SingleSourceShortestPathTestCommon.testCLRSExample(INSTANCE);
    }

}
