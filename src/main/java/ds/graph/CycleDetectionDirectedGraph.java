package ds.graph;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class CycleDetectionDirectedGraph {

    // this will detect the loop even in the disconnected graph
    public static boolean isCyclicDirected(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        final boolean[] recursiveStack = new boolean[adjList.length];
        Arrays.fill(isVisited, false);
        Arrays.fill(recursiveStack, false);

        boolean isCyclic = false;
        for (int i = 0; i < adjList.length && !isCyclic; i++) {
            if (!isVisited[i]) {
                isCyclic =  isCyclicDirectedUtil(adjList, isVisited, recursiveStack, i);
            }
        }

        return isCyclic;
    }

    // we are using standard DFS and hence it has Time Complexity : O(N) and
    // Space Complexity : O(N)
    private static boolean isCyclicDirectedUtil(final LinkedList<Integer>[] adjList,
                                       final boolean[] isVisited,
                                       final boolean[] recursiveStack,
                                       final int currentVertex) {
        isVisited[currentVertex] = true;
        recursiveStack[currentVertex] = true;

        for (final int nbr :  adjList[currentVertex]) {
            if (!isVisited[nbr]) {
                return isCyclicDirectedUtil(adjList, isVisited, recursiveStack, nbr);
            }
            // that means the vertex was visited and is still in the recursive stack
            // Make sure that this condition is checked after the above condition :)
            else if (recursiveStack[nbr] == true) {
                return true;
            }
        }

        recursiveStack[currentVertex] = false;
        return false;
    }
}
