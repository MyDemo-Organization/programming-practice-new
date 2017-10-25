# Binary Tree
## NOTE
- To enable Lombok annotated method to be resolvable by the IntelliJ, you also need
lombok plugin to be installed into your IDES
- Git link is totally broken. I will solve it later

## Problems

1. Depth First Traversals(DFS):
  - Recursive :
    - PreOrder
      - Usage : To get prefix expression; to create a copy of a tree
    - InOrder
      - Usage: In case of BST In order gives the values in *increasing order*. To get in decreasing order use **RRoL**
    - PostOrder
      - Usage: to delete the tree; to get postfix expression of an Expression tree.

  - Iterative (Stack):
     - Preorder -> standard solution is Pre order
     - InOrder ->
      - Here are the steps;
        1. Go to the left most leaf Node
          - Initialize current node to root.
          - keep on assigning `cn = cn.left` until we get `cn.left == null`. At this point cn is nothing but the left most node.
        2. Keep printing the `inOrderSuccessor` for all the nodes.
          - **in order successor**: It is the left most node in the right subtree.
          -

          ```JAVA
          // going to the in-order successor i.e. the left most node in the right subtree
          cn = cn.right;

          if (cn != null) {
            stack.push(cn);
            cn = cn.left;
          }
          ```
          - Keep doing this while `cn == null && stack.isEmpty()`
  - Iterative(without stack (Morris Traversal/Threaded binary tree))
    - It is all about finding the in-order predecessor of the current Node and creating a thread between the current and that inorder predecessor by doing;
    `pre.right = current`
    - Algorithm:(NOTE: print happens only on the cn)
      - **STEP1:** Start with `cn = root`and keep doing the STEP 2 until `cn != null`
    - **STEP2:**
      a) **Printing Step**
      `cn.left == null`
        -  We are at the left most node and just print it and go to its inOrderSuccessor;
        ```JAVA
        soout -> cn.data
        cn = cn.right //in order successor created using the threaded right node
        ```

      b) **Thread creation and removal(+printing) step**
      - Go to the in order predecessor of the cn (i.e. right most node in the left subtree)
      - Find pre Algorithm:
        - ```JAVA
        pre = cn.left
        while(pre.right != null && pre.right != cn)
          pre = pre.right
        ```
      - Once you break the above while loop, there are two possibilities;

        (i) `pre.right == null` (Thread creation Step)
         - This means there is no thread present and you have to create the thread and go down below;
         ```JAVA
         pre.right = cn
         cn = cn.left
         ```

       (ii)  `pre.right == cn` (Thread Removal Step)
       - means there was actually the thread
       - means pre is the left most node now
       - print the cn and remove the thread.
       ```JAVA
       sout -> cn.data
       pre.right = null // thread removal
       ```

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

4. Tree construction from Traversal:
  - we can build the tree from Traversal provided one of the Traversals is **in-order**
  - Build the tree using the inorder + Preorder Traversal
5. Max-width of a binary tree (could be added in the Tree Measurement)
6. Print nodes at the k-distance from the root. (Looks like a sub-problem of the level order traversal.)
7. Print Ancestor of Node in a given Tree
8. Checkout if one tree is the Subtree of the other tree.
9. Connect nodes at the same level (Bull shit!)


## Solutions:

### Tree construction from the Traversal:
- **Class**
```JAVA
CreateBinaryTreeFromTraversals.java
```

- we can build the tree from Traversal provided one of the Traversals is **in-order**
- Build the tree using the inorder + Preorder Traversal.
- Important facts:
  - InorderTraversal:
    - Root is at the center
    - Left sub-array represents the left Subtree.
    - Right sub-array represents the right subtree.
  - PreOrderTraversal:
    - Root is at the beginning:
  - Algorithms:
    - start the preIndex to 0
    - add the root as pre[preIndex]
    - find k => position of root in the InorderTraversal
    - create the left sub tree with indice i,k-1
    - create the right subtree with k+1,i


### Max-width of a binary tree
```JAVA
MaxWidth.java
```
- By using modification of Level Order Traversal Using recursion:
  - One would be to go for the level order traversal and for each print out and for a given order record the number of
  prints which would present the number of elements present in that order.
  - Keep doing this for each order until you get the max of all
- By using Queue
  - Queue size in each iteration represent the number of Nodes present in the previous level

###  Print nodes at the k-distance from the root
```JAVA
KDistantNodes.java
```

#### Print Ancestor of Node in a given Tree
- Basically we are given a Root node and data value for which we would like to print the Ancestors.

```JAVA
PrintAncestor.java
```

### Checkout if one tree is the Subtree of the other tree
- I think it could be a Generla version of finding if two tree is identical.
```JAVA
CheckIfSubtree.java
```

### Connect at same level
- Its is based on two simple logics;
```java
node.left.nextRight = node.right;
node.right.nextRight = node.nextRight.left;
```
- File name is;
```JAVA
ConnectNodesAtSameLevel.java
```
