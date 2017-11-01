package ds.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
@RunWith(MockitoJUnitRunner.class)
public class CycleDetectionUnDirectedGraphTest {

    @Test
    public void shouldDetectCycleInUndirectedGraphUsingDSF() {
        final AdjListGraph nonCycle = AdjListGraph.getUndirectedGraphWithoutCycle();
        System.out.println("isCyclic() : " + CycleDetectionUnDirectedGraph.isCyclicUnDirected(nonCycle.getAdjLists()));
        final AdjListGraph withCycle = AdjListGraph.getUndirectedGraphWithCycle();
        System.out.println("isCyclic() : " + CycleDetectionUnDirectedGraph.isCyclicUnDirected(withCycle.getAdjLists()));
    }
}
