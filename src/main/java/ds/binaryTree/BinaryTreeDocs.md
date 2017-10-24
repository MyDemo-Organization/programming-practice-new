# Binary Tree
## NOTE
- To enable Lombok annotated method to be resolvable by the IntelliJ, you also need
lombok plugin to be installed into your IDES
- Git link is totally broken. I will solve it later

## Problems

1. Depth First Traversals(DFS):
  - PreOrder
    - Usage : To get prefix expression; to create a copy of a tree
  - InOrder
    - Usage: In case of BST In order gives the values in *increasing order*. To get in decreasing order use **RRoL**
  - PostOrder
    - Usage: to delete the tree; to get postfix expression of an Expression tree.
2. Level Order Traversal (BFS)
  - Using the Recursion
  - Using the Queue
3. Tree Measurement
  - Height  : length of the longest path between the root and the leaf
  - Diameter : Length of the longest path between any two leaves. It could be maximum of the following;
    - diameter of the left sub tree
    - diameter of the right sub tree
    - longest path between the leaves that goes through the given root Node which would be;
      - height of the left subtree + height of right subtree + 1
