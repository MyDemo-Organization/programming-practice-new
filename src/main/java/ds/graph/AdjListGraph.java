package ds.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/30/17
 */
@Getter
public class AdjListGraph {
    // number of vertices in the graph
    private int V;

    // Arrays of adjLists
    private LinkedList<Integer>[] adjLists;

    public static AdjListGraph getSampleGraph() {
        // lets create the Graph
        AdjListGraph basicGraph = new AdjListGraph(5);

        // add al the edges
        basicGraph.addEdge(0,1);
        basicGraph.addEdge(0,4);
        basicGraph.addEdge(1,2);
        basicGraph.addEdge(1,3);
        basicGraph.addEdge(1,4);
        basicGraph.addEdge(2,3);
        basicGraph.addEdge(3,4);

        System.out.println(basicGraph);
        return basicGraph;
    }

    public static AdjListGraph getLoopGraph() {
        // lets create the Graph
        AdjListGraph g = new AdjListGraph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g);
        return g;
    }

    public AdjListGraph(int v) {
        V = v;

        // initialize the Linked List array
        adjLists = new LinkedList[v];

        // initialize all the Linked Lists
        for (int i = 0; i < V; i++){
            adjLists[i] = new LinkedList<>();
        }
    }


    /**
     * This method adds and edge between two vertices
     * of an "undirected graph"
     *
     *
     * @param src
     * @param dst
     */
    public void addEdge(final int src, final int dst){
        if (src < 0 || src > this.V - 1 || dst < 0 || dst > this.V - 1){
            System.out.println("ERROR: Invalid edge");
            return;
        }

        // add src->dst
        adjLists[src].add(dst);


        //  For un-directed graphs uncomment the following line
        // adjLists[dst].add(src);
    }

    @Override
    public String toString() {
        String graph = "AdjGraph\n";
        graph += String.format("%4s : %s", "V", "Adjacency List\n");
        for (int i = 0; i < V; i++){
            graph += String.format("%4d : ", i);
            for (Integer nbr: adjLists[i]){
                graph += String.format("%4d ", nbr);
            }
            graph += "\n";
        }

        return graph;
    }

}

