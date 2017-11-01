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
public class LongestPathDAGTest {

    @Test
    public void shouldFindLongestPath() {
        final AdjListGraph dag = AdjListGraph.getDirectedGraphWithoutCycle();
        LongestPathDAG.bfsModified(dag.getAdjLists());
    }
}
