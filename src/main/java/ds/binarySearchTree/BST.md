# Binary Search Tree

## Problems to be solved
1. Basic Operations;
  - Search a key
  - Insert a key
  - Min and max;
    - InOrder Predecessor -> min
    - InOrder Successor -> max
  - **Delete a key** :small_red_triangle:
3. Check if the given tree is BST
4. Lowest Common Ancestor (LCA)
5. K*th* Smallest element
6. Merge two BST into a new BST
7. Correct BST which has exactly one pair of values swapped
8. Maths;
  - Floor
  - Ceil
9. Conversions;
  - **BST** to sorted **DLL**
  - **Sorted DLL** to **Balanced BST**
  - Merge two **Balanced BST** into a new BST
  - **Sorted Linked List** to **Balanced BST**
  - **Sorted Array** to **Balanced BST**
10. Binary tree <=> BST
  - **Binary Tree** to **BST**
  - **BST** to **Balanced BST**


## Solutions

### Basic Operations: **BinarySearchTree.java**
#### Insert

- Code: **BinarySearchTree.java**
```JAVA
    // Time Complexity : O(log N)
    public static BinaryTreeNode insert(final BinaryTreeNode root, final int newData) {
        // BASE Case 1
        if (root == null) {
            return new BinaryTreeNode(newData);
        }

        // Make sure the condition is correct
        if (newData <= root.getData()) {
            root.setLeft(insert(root.getLeft(), newData));
        } else {
            root.setRight(insert(root.getRight(), newData));
        }
        return root;
    }
```

### Search (oe)
- Code: **BinarySearchTree.java**
```java
    // Time Complexity : O(log N)
    public static BinaryTreeNode search(final BinaryTreeNode root, int searchData) {
        // Base Case 1:
        if (root == null){
            return null;
        }

        // Base Case 2:
        if (searchData == root.getData()) {
            return root;
        }

        // Search in left subtree
        if (searchData < root.getData()) {
            return search(root.getLeft(), searchData);

            // Search in right subtree
        } else {
            return search(root.getRight(), searchData);
        }
    }
```

### Min and Max (oe)
- Code: **BinarySearchTree.java**
```java
    // Time Complexity : O(log N)
    // left most Node
    public static BinaryTreeNode getMin(final BinaryTreeNode root) {
        if (root == null || root.isLeaf())
            return root;
        return getMin(root.getLeft());
    }

    // Time Complexity : O(log N)
    // right most node
    public static BinaryTreeNode getMax(final BinaryTreeNode root) {
        if (root == null || root.isLeaf())
            return root;
        return getMax(root.getRight());
    }
```

### Delete a Node in a BST (:small_red_triangle:)
