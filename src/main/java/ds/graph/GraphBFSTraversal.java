package ds.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/30/17
 */
public class GraphBFSTraversal {

    // Time Complexity : O(N)
    // Space Complexity : O(N) to store in the queue
    public static void basicBFS(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        Arrays.fill(isVisited, false);

        System.out.println("### BFS TRAVERSAL ###");
        for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                basicBFSUtil(i, isVisited, adjList);
            }
        }
    }

    /**
     *
     * @param u         node to be visited
     * @param isVisited boolean showing if the vertex has been visited already or not
     * @param adjList
     */
    public static void basicBFSUtil(final int u,
                                    final boolean[] isVisited,
                                    final LinkedList<Integer>[] adjList) {

        final Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        isVisited[u] = true;

        while (!queue.isEmpty()) {
            final Integer currentVertex = queue.poll();
            System.out.printf("%4d", currentVertex);
            for (final int nbr : adjList[currentVertex]) {
                if (!isVisited[nbr]) {
                    isVisited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
    }
}
