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
public class CycleDetectionDirectedGraphTest {

    @Test
    public void shouldDetectCycleInDirectedGraphUsingRecursion() {
        final AdjListGraph nonCycleGraph = AdjListGraph.getSampleGraph();
        System.out.println("Is Cyclic : " + CycleDetectionDirectedGraph.isCyclicDirected(nonCycleGraph.getAdjLists()));

        final AdjListGraph cyclicGraph = AdjListGraph.getLoopGraph();
        System.out.println("Is Cyclic : " + CycleDetectionDirectedGraph.isCyclicDirected(cyclicGraph.getAdjLists()));

    }
}
