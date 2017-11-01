# Graph

## Problems

1. BFS :white_check_mark:
  - Using Queue (Basic BFS traversal)
  - Application
2. DFS :white_check_mark:
  - Using Stack (Basic DFS traversal)
  - Using Recursion (outputs may vary of both of the traversal)
  - Application
3. Detect Cycle in a Directed Graph :white_check_mark:
4. Detect cycle in an undirected graph
  - Normal :white_check_mark:
  - Using Disjoint set (union & find) :x:
    - may not be doing
5. Longest Path in a Directed Acyclic Graph DA :white_check_mark:
6. Snake and Ladder Problem
7. Boggle (Find all possible words in a board of characters)
8. Assign directions to edges so that the directed graph remains acyclic :x:
9. Kruskal's Minimum Spanning Tree (Greedy)

## Shortest Paths
- Dijkstra’s shortest path algorithm
- Printing paths in Dijsktra’s Algorithm

## Connectivity
- Find if there is a path between two vertices in a directed graph

## Backtracking
- Rat in a Maze
- Find if there is a path of more than k length from a source



## 1. BFS

### Application of BFS
- Shortest Path and Minimum Spanning Tree for unweighted graph
- Peer to Peer Networks
- Crawlers in Search Engines
- Social Networking Websites
- In Garbage Collection
- Cycle detection in undirected graph
- Check whether a given graph is Bipartite or not (DFS also)
  - A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of same set.
  ![Bipartite](bip.png)

## 2. DFS

### Application of DFS
- Detecting a cycle in the Graph
- Finding a path between two vertices :)
- For an **unweighted graph**, DFS traversal of the graph produces;
  - the minimum spanning tree and
  - all pair shortest path tree


## 3. Cycles
### 3. (a) Detecting cycle in a directed graph
- This is simple. We just have to store the **recursive stack** for the vertices which haven't been yet visited completely.
- Add them into the stack at the beginning of the visit and remove them at the end of the visit.


### 3. (a)  Detecting cycle in a Undirected graph
- This is quiet tricky because you can not say that a Vertex in the stack is visited again would make a cycle, bacause there is a **back_edge** for each edge.
- The idea here is;
  - *For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex, we say that there is no cycle.*
- Here in the util method we would be passing the parameter called as
    ```java
    int parent
    ```
- This would be the parent of the given node to be visited (default value would be -1 for starting and unconnected nodes).

## 4. Path Measurements

### 4. (a) Find Longest Path in a Directed Acyclic Graph (DAG)
- **Problem Statement** : Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it, find the longest distances from s to all other vertices in the given graph.
- **My Approach** :
  - It looks we could run the BFS and keep a record of all the distances of all the vertices using a **distance array**.
    - This would be an integer array where value of each index will show its distance from the start index.
  - May be we can also use the **parentArray** to store the parent of all the vertices visited.
    - For printing the path we could start from the destination and keep moving up till we reach the null parent for the source.
- **Solution** :smile: oe
  - FileName : **LongestPathDAG.java**
  - assumed the weight to be unity for each edge
  - to solve with the original weight we have to change the entire structure of the Graph that we have right now
