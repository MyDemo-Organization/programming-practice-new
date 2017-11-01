package ds.graph;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/31/17
 */
public class LongestPathDAG {

    // we are using BFS and assuming
    // and assuming that weight on each edge is one
    public static void bfsModified(final LinkedList<Integer>[] adjList) {
        final boolean[] isVisited = new boolean[adjList.length];
        final int[] parent = new int[adjList.length];
        final int[] distance = new int[adjList.length];

        Arrays.fill(isVisited, false);
        Arrays.fill(parent, -1);
        Arrays.fill(distance, 0);

        bfsUtilModified(adjList, isVisited, parent, distance, 0);

        // we have to bfs only with the given source :)
        // this is the only difference between standard BFS and this
        /*for (int i = 0; i < adjList.length; i++) {
            if (!isVisited[i]) {
                bfsUtilModified(adjList, isVisited, parent, distance, i);
            }
        }*/

        System.out.println("### Distance Array ###");
        System.out.println(ArrayUtils.toString(distance));


        System.out.println("### Parent Array ###");
        System.out.println(ArrayUtils.toString(parent));

        System.out.println("### Distance Array ###");
        System.out.println(ArrayUtils.toString(distance));

        final int farthestVertex = getMaxIndex(distance);
        System.out.println("### Farthest Vertex is : " + farthestVertex + " ###");

        System.out.println("### Path to farthest vertex is : ###");
        printPath(parent, farthestVertex);

    }

    // Time Complexity : O(N)
    private static int getMaxIndex(final int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // pre 0 <= source < destination <= array.length - 1
    private static void printPath(final int[] pathArray, final int destination) {
        int currentIndex = destination;
        System.out.println("PATH to " + destination + " from source is as follows;");
        String pathString = "";
        while (pathArray[currentIndex] != -1) {
            pathString =  " -> " + currentIndex +  pathString;
            currentIndex = pathArray[currentIndex];
        }
        pathString = currentIndex + pathString;
        System.out.println(pathString);
        System.out.println();
    }

    // Time Complexity : O(N)
    private static void bfsUtilModified(final LinkedList<Integer>[] adjList,
                                 final boolean[] isVisited,
                                 final int[] parent,
                                 final int[] distance,
                                 final int sourceVertex) {

        final Queue<Integer> queue = new LinkedList<>();
        // Mark everything as visited before adding into the queue
        isVisited[sourceVertex] = true;
        queue.add(sourceVertex);


        while (!queue.isEmpty()) {
            final int currentVertex = queue.poll();
            System.out.printf("%4d", currentVertex);
            for (final int nbr : adjList[currentVertex]) {
                if (!isVisited[nbr]) {
                    isVisited[nbr] = true;
                    distance[nbr] = distance[currentVertex] + 1;
                    parent[nbr] = currentVertex;
                    queue.add(nbr);
                }
            }
        }
    }

}
