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
5. Related to path measurements;
  - Longest Path in a Directed Acyclic Graph DA :white_check_mark:
  - Find if there is a path between two vertices in a directed graph :white_check_mark:
6. Snake and Ladder Problem :white_check_mark: oe
7. Number of islands :white_check_mark: oe http://www.geeksforgeeks.org/find-number-of-islands/
7. Boggle (Find all possible words in a board of characters)
8. Assign directions to edges so that the directed graph remains acyclic :x:
9.  No of triangles:
  - Number of triangles in an undirected Graph
  - Number of triangles in directed and undirected Graph
10. Mother of all vertices

## Shortest Paths (READ ONLY)
- Dijkstra’s shortest path algorithm
- Printing paths in Dijsktra’s Algorithm
- Kruskal's Minimum Spanning Tree (Greedy) (READ ONLY)

## Connectivity
- Find if there is a path between two vertices in a directed graph (Added to the Question 5)

## Backtracking
- Rat in a Maze :smile: :white_check_mark: oe
- Find if there is a path of more than k length from a source
  - **NOTE**: If we ignore the weight then we can solve it using the BFS or DFS and using the distance array. :)



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

### 4 (b) Find if there is a path between two vertices in a directed graph :smile: oe
- [g4g Link](http://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/)
- MyApproach:
  - Simply look for the DFS or BFS and if the destination is reached return true else false;
  - I would go for DFS


## 5. Misc:

### 5. (a) Snake and Ladder
**Problem Statement** : Given a snake and ladder board, find the **minimum number of dice throws** required to reach the destination or last cell from source or 1st cell. Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.
- [g4g link](http://www.geeksforgeeks.org/snake-ladder-problem-2/)

**Aproach**
- The idea is to consider the given snake and ladder board as a *directed graph* with
  - **number of vertices** equal to the number of cells in the board.
  - The problem reduces to finding the shortest path in a graph.
  - Edges :
    - Every vertex of the graph has an edge to next six vertices if next 6 vertices do not have a snake or ladder.
    - If any of the next six vertices has a snake or ladder, then the edge from current vertex goes to the **top of the ladder or tail of the snake**.
  - Could be easily solved using the **Standard BFS**.

### 5(b) Number of islands:
- **Problem Statement**: Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
```shell
Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}
Output : 5
```
- **My Aproach**
  - Keep track of the isVisited 2D array and do a bfs visit.
  - each time you return increase the number of islands.
  - :smile: oe

### 5(c) Rat in a Maze :smile: oe
- **Program File** : RatInAMaze.java
- A Maze is given as N*N binary matrix of blocks where;
  - source block is the upper left most block i.e., maze[0][0] and
  - destination block is lower rightmost block i.e., maze[N-1][N-1].
  - A rat starts from source and has to reach destination.
  - The rat can move only in two directions: forward and down.
- We have to print the entire path which would also be a 2D matrix
- My plan is to use the isVisited 2D matrix as well :)
