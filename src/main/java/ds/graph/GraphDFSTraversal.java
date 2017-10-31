package ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/30/17
 */
public class GraphDFSTraversal {

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static void basicDFS(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        Arrays.fill(isVisited,false);

        System.out.println("### DFS Traversal ###");
        for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                basicDFSUtil(i, isVisited, adjList);
            }
        }
    }

    private static void basicDFSUtil(final int u,
                                     final boolean[] isVisited,
                                     final LinkedList<Integer>[] adjList) {
        isVisited[u] = true;
        final Stack<Integer> stack = new Stack<>();
        stack.push(u);

        while (!stack.isEmpty()) {
            final int currentVertex = stack.pop();
            System.out.printf("%4d", currentVertex);
            for (final int nbr : adjList[currentVertex]) {
                if (!isVisited[nbr]) {
                    isVisited[nbr] = true;
                    stack.push(nbr);
                }
            }
        }
    }

    public static void recursiveDFS(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        Arrays.fill(isVisited, false);

        System.out.println("### BFS TRAVERSAL ###");
        for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                recursiveDFSUtil(i, isVisited, adjList);
            }
        }

    }

    private static void recursiveDFSUtil(final int u,
                                         final boolean[] isVisited,
                                         final LinkedList<Integer>[] adjList) {
        isVisited[u] = true;
        System.out.printf("%4d", u);

        for (final int nbr : adjList[u]) {
            if (!isVisited[nbr]) {
                // recursively visit the nbrs first
                recursiveDFSUtil(nbr, isVisited, adjList);
            }
        }

        // System.out.printf("%4d", u);

    }
}
