package ds.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class PathCheck {

    public static boolean isPathExist(final LinkedList<Integer>[] adjList,
                                      final int sourceVertex,
                                      final int destinationVertex) {
        final boolean[] isVisited = new boolean[adjList.length];
        Arrays.fill(isVisited, false);
        return isPathExistUtil(adjList, isVisited, sourceVertex, destinationVertex);
    }

    private static boolean isPathExistUtil(final LinkedList<Integer>[] AdjList,
                                          final boolean[] isVisited,
                                          final int sourceVertex,
                                          final int destinationVertex) {
        isVisited[sourceVertex] = true;

        if (sourceVertex == destinationVertex) {
            return true;
        }

        for (final int nbr :  AdjList[sourceVertex]) {
            if (!isVisited[nbr]) {
                // this if condition is very important
                if (isPathExistUtil(AdjList, isVisited, nbr, destinationVertex)) {
                    return true;
                }
            }
        }

        return false;

    }
}
