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
public class AdjGraphTest {
    private final AdjListGraph graph = AdjListGraph.getDirectedGraphWithoutCycle();

    @Test
    public void shouldCreateSampleGraph() {
        System.out.println("### Created Graph ###");
        System.out.println(graph);
    }
}
