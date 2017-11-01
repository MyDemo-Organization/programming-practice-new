package ds.graph;

import java.util.Arrays;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class Island {

    // graph is in the form of Adjacency matrix
    public static int getNumberOfIslands(final int[][] graph) {
        // initialize
        final boolean[][] isVisited = new boolean[graph.length][graph[0].length];
        for (int i = 0; i < isVisited.length; i++) {
            Arrays.fill(isVisited[i],false);
        }

        int noOfislands = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (!isVisited[i][j] && graph[i][j] == 1) {
                    bfsVisit(i, j, graph, isVisited);
                    noOfislands++;
                }
            }
        }

        return noOfislands;

    }

    // Time Complexity : O(N^2) in this case N is the total number of vertices
    private static void bfsVisit(final int xCor,
                                 final int yCor,
                                 final int[][] graph,
                                 final boolean[][] isVisited) {

        isVisited[xCor][yCor] = true;

        // visit all the neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isValidCell(xCor + i, yCor + j,
                        graph.length, graph[0].length,
                        isVisited, graph)) {
                    bfsVisit(xCor + i, yCor + j, graph, isVisited);
                }
            }
        }

    }


    // Time Complexity : O(1)
    private static boolean isValidCell(final int xCor,
                                       final int yCor,
                                       final int noOfRows,
                                       final int noOfCols,
                                       final boolean[][] isVisited,
                                       final int[][] graph) {

        return (xCor >= 0 && xCor < noOfRows) &&
                (yCor >= 0 && yCor < noOfCols) &&
                isVisited[xCor][yCor] == false &&
                graph[xCor][yCor] == 1;
    }
}
