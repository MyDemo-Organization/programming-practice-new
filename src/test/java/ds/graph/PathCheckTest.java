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
public class PathCheckTest {

    @Test
    public void shouldCheckPath() {
        final AdjListGraph dag = AdjListGraph.getDirectedGraphWithoutCycle();
        System.out.println("### Checking path between 0 and 4 ###");
        System.out.println(PathCheck.isPathExist(dag.getAdjLists(), 0, 4));
        System.out.println("### Checking path between 1 and 4 ###");
        System.out.println(PathCheck.isPathExist(dag.getAdjLists(), 1, 4));
        System.out.println("### Checking path between 2 and 5 ###");
        System.out.println(PathCheck.isPathExist(dag.getAdjLists(), 2, 5));
    }
}
