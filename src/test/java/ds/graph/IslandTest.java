package ds.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: "No of Islands"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
@RunWith(MockitoJUnitRunner.class)
public class IslandTest {

    @Test
    public void shouldFindNumberOfIslands() {
        int[][] graph = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
            };

        System.out.println("Number of islands is: %d\n" + Island.getNumberOfIslands(graph));
    }
}


