package ds.graph;

import org.apache.commons.lang3.ArrayUtils;
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
public class RatInAMazeTest {

    @Test
    public void shouldFindPathForRat() {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };


        System.out.println("### Given Maze ###");
        for (int i = 0; i < maze.length; i++) {
            System.out.println(ArrayUtils.toString(maze[i]));

        }

        System.out.println("### Path Solution ###");
        boolean[][] path = RatInAMaze.getRatPathFromSourceToDestination(maze);
        for (int i = 0; i < path.length; i++) {
            System.out.println(ArrayUtils.toString(path[i]));

        }

    }
}
