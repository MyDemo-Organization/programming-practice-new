package ds.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class CycleDetectionUnDirectedGraph {

    public static boolean isCyclicUnDirected(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        Arrays.fill(isVisited, false);

        for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                // Note: remember to pass default as something which is not presne in the vertex list indices:)
                if (isCyclicUnDirectedUtil(adjList, isVisited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCyclicUnDirectedUtil(final LinkedList<Integer>[] adjList,
                                           final boolean[] isVisited,
                                           final int currentVertex,
                                           final int parent) {

        // mark as visited
        isVisited[currentVertex] = true;

        for (final int nbr : adjList[currentVertex]) {
            if (!isVisited[nbr]) {
                // NOTE that we are returning a value only if it is true and for false we are moving aheda with other options
                // don't return false here itself
                // we have added '== true' just to make code more readable
                if(isCyclicUnDirectedUtil(adjList, isVisited, nbr, currentVertex) == true) {
                    return true;
                }
                // NOTE: if a nbr vertex has already been visited then it has to be the parent of current vertex
            } else if (parent != nbr) {
                return true;
            }
        }

        return false;

    }
}
