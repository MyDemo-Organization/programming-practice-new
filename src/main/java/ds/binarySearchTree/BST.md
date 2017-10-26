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

#### Search (oe)
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

#### Min and Max (oe)
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

#### Delete a Node in a BST (:small_red_triangle:)
- Bu just reading the following cases, I did it on my own.
- There are following three cases to be considered;
1) Node to be deleted is leaf: Simply remove from the tree.

              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70
         /  \    /  \                     \    /  \
       20   40  60   80                   40  60   80
2) Node to be deleted has only one child: Copy the child to the node and delete the child

              50                            50
           /     \         delete(30)      /   \
          30      70       --------->    40     70
            \    /  \                          /  \
            40  60   80                       60   80
3) Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Note that inorder predecessor can also be used.

              50                            60
           /     \         delete(50)      /   \
          40      70       --------->    40    70
                 /  \                            \
                60   80                           80

- Code:
```java
public static BinaryTreeNode delete(final BinaryTreeNode root, int deleteData) {
        if (root == null) {
            System.out.println("No data found in the Tree");
            return root;
        }

        if (deleteData < root.getData()) {
            root.setLeft(delete(root.getLeft(), deleteData));
        } else if (deleteData > root.getData()) {
            root.setRight(delete(root.getRight(), deleteData));
        } else {
            // here deleteData == root.getData()
            // CASE 1
            if (root.isLeaf()) {
                return null;
            } else

            // CASE 2 only left or right child present
            if (root.getLeft() == null) {
                return root.getRight();
            }

            if (root.getRight() == null) {
                return root.getLeft();
            }

            // CASE 3: Both the children present
            // getInorder predecessor : i.e right most in left subtree
            // or maximum in left subtree
            final int inOrderPredecessor = getMax(root.getLeft()).getData();
            root.setData(inOrderPredecessor);
            root.setLeft(delete(root.getLeft(), inOrderPredecessor));

        }
        return root;
    }
```

### Check if BST! oe :smile:
- By just making sure that my current Node value is in the required range I can make sure that given Binary tree is a BST
- Code: **CheckBST.java**
```java
    // assumes no duplicate data is present
    // O(N)
    public static boolean isBST(final BinaryTreeNode root) {
        // Base Case
        if (root == null) {
            return true;
        }
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // means between and including [minRange....MaxRange]
    // O(N)
    private static boolean isBSTUtil(final BinaryTreeNode node, int minRange, int maxRange) {
        // Base Case 1
        if (node == null) {
            return true;
        }

        // Base case 2
        if (node.getData() < minRange || node.getData() > maxRange) {
            return false;
        }

        return isBSTUtil(node.getLeft(), minRange, node.getData() - 1) &&
                isBSTUtil(node.getRight(), node.getData() + 1, maxRange);
    }
```
