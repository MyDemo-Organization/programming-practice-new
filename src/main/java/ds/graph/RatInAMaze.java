package ds.graph;

import java.util.Arrays;

/**
 * Problem Statement: "Rat in Maze"

 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 *
 */

public class RatInAMaze {

    public static boolean[][] getRatPathFromSourceToDestination(final int[][] graph) {
        final boolean[][] isVisited = new boolean[graph.length][graph[0].length];
        final boolean[][] path = new boolean[graph.length][graph[0].length];

        for (int i = 0; i < isVisited.length; i++) {
            Arrays.fill(isVisited[i], false);
            Arrays.fill(path[i], false);

        }


        traceRatPathBFSVisit(graph, path, isVisited, 0, 0);
        return path;
    }

    private static boolean traceRatPathBFSVisit(final int[][] graph,
                                         final boolean[][] path,
                                         final boolean[][] isVisited,
                                         final int xCor, final int yCor) {
        isVisited[xCor][yCor] = true;

        if (xCor == graph.length - 1 && yCor == graph[0].length - 1) {
            path[xCor][yCor] = true;
            return true;
        }

        // check if there is valid path in the downward direction and reachable to the destination
        if (isValidCell(graph, isVisited, xCor + 1, yCor)
                && traceRatPathBFSVisit(graph, path, isVisited, xCor + 1, yCor)) {
            path[xCor][yCor] = true;
            return true;
        }

        // check if there is valis path in the forward direction
        if (isValidCell(graph, isVisited, xCor, yCor + 1)
                && traceRatPathBFSVisit(graph, path, isVisited, xCor, yCor + 1)) {
            path[xCor][yCor] = true;
            return true;
        }

        return false;
    }


    private static boolean isValidCell(final int[][] graph,
                                       final boolean[][] isVisited,
                                       final int xCor, final int yCor) {
        return (xCor >= 0 && xCor < graph.length) &&
                (yCor >= 0 && yCor < graph[0].length) &&
                isVisited[xCor][yCor] == false &&
                graph[xCor][yCor] == 1;
    }
}
