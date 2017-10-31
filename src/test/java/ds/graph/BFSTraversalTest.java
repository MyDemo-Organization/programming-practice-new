package ds.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/30/17
 */
@RunWith(MockitoJUnitRunner.class)
public class BFSTraversalTest {

    private static AdjListGraph graph = AdjListGraph.getSampleGraph();

    @Test
    public void shouldPerformGraphDFS() {
        BFSTraversal.bfs(graph.getAdjLists());
    }

}
