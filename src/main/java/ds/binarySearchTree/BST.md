# Binary Search Tree

## Problems to be solved
1. Basic Operations;
  - Search a key
  - Insert a key
  - Min and max;
    - InOrder Predecessor -> max in the left subtree (Right most node in the left subtree)
    - InOrder Successor -> min in the right subtree (Left most Node in the right subtree)
  - **Delete a key** :small_red_triangle:
2. Check if the given tree is BST
3. Lowest Common Ancestor (LCA)
4. Merge two BST into a new BST
5. Correct BST which has exactly one pair of values swapped :small_red_triangle:
6. Maths;
  - Floor :small_red_triangle:
  - Ceil
7. Conversions;
  -  **Sorted DLL** to **Balanced BST** :small_red_triangle:
  - **Sorted Linked List** to **Balanced BST**
  - **Sorted Array** to **Balanced BST**
8. Merge two **Balanced BST** into a new BST
9. **Binary Tree** to **BST** (same structure)
10. **BST** to **Balanced BST**


## Solutions

### Basic Operations: **BinarySearchTree.java**
#### Insert oe :smile:

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

#### Search (oe) :smile:
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

#### Min and Max (oe) :smile:
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


### LCA Lowest common ancestor (LCA) oe :smile:
- Code: **LowestCommonAncestor.java**

```java
// Time Complexity : O(log N)
public static BinaryTreeNode getLowestCommonAncestor(final BinaryTreeNode root,
                      final int key1,
                      final int key2) {
    if (key1 < root.getData() && key2 < root.getData()) {
        // search in left sub tree
        return getLowestCommonAncestor(root.getLeft(), key1, key2);
    }

    if (key1 > root.getData() && key2 > root.getData()) {
        // search in the right subtree
        return getLowestCommonAncestor(root.getRight(), key1, key2);
    }

    // means we are at LCA
    return root;
}
```
###  Merge two BST into a new BST (oe) :smile:
- It looks we will keep traversing the one BST nodes and inserting it into the other BST
- Looks O(N*log (M+N) Solution.
- We have solved following two forms;
  - Adding level-order traversal of the child BST into the parent BST;
  ```JAVA
    // Time Complexity : O(N * log (M + N)) (level Order)
    public static BinaryTreeNode merge(BinaryTreeNode parentRoot, final BinaryTreeNode childTree ) {
        // Base case 1: parent is null
        if (parentRoot == null)
            return childTree;

        // Nase case 2: child is null
        if (childTree == null)
            return parentRoot;

        // lets do a level order traversal of the child tree
        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(childTree);
        BinaryTreeNode currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            // insert it into the other node
            parentRoot = BinarySearchTree.insert(parentRoot, currentNode.getData());

            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        return parentRoot;
    }
  ```
  - Adding the in-order traversal into the parent BST.
  ```java
  public static BinaryTreeNode mergeInorder(BinaryTreeNode parentRoot, final BinaryTreeNode childTree) {
        // Base case 1: parent is null
        if (parentRoot == null)
            return childTree;

        // Base case 2: child is null
        if (childTree == null);

        // lets do inorder Traversal of the child Tree using the Stack
        final Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        BinaryTreeNode cn = childTree;

        // STEP 1: Go to the first elemt of in order traversal i.e. Left most Node
        while (cn != null) {
            stack.push(cn);
            cn = cn.getLeft();
        }

        while (!stack.isEmpty()) {
            cn = stack.pop();

            // insert this into the parent tree
            parentRoot = BinarySearchTree.insert(parentRoot, cn.getData());

            // go the in-order successor i.e left most Node in the right sub-tree
            cn = cn.getRight();

            while (cn != null) {
                stack.push(cn);
                cn = cn.getLeft();
            }
        }
        return parentRoot;
    }
  ```


## Two nodes of a BST are swapped, correct the BST
1. The swapped nodes are not adjacent in the inorder traversal of the BST.
```shell
For example, Nodes 5 and 25 are swapped in {3 5 7 8 10 15 20 25}.
The inorder traversal of the given tree is 3 25 7 8 10 15 20 5
```
2. The swapped nodes are adjacent in the inorder traversal of BST.
```shell
For example, Nodes 7 and 8 are swapped in {3 5 7 8 10 15 20 25}.
The inorder traversal of the given tree is 3 5 8 7 10 15 20 25
```

- So the idea is *in-order traversal* of a BST is in ascending order
- The point of swap would be the point where the next value is smaller than the previous value.
- In the case of adjacent we will have only one place where this happens and in case of
non-adjacent there would be two places where this happens.
- We would be playing with these pointers;
  - prev -> points to the previous node
  - first -> points to the first swapped node (it would be the previous node and not current node which we are on!)
  - middle -> points to the **first.next** node
      - It would become the second swapped node in case of adjacent swap nodes
  - last -> it is the second node which is being swapped.
    - It would be the current node.



```JAVA

    // pointers to find the swapped location
    private static BinaryTreeNode previous, first, middle, second;

    // corrects the swapped Tree if any :)
    public static BinaryTreeNode correctPairSwap(final BinaryTreeNode root) {
        previous = first = middle = second = null;

        // get the swapped location of the swapped nodes
        findSwappedLocation(root);

        // non-adjacent swap
        if (first != null && second != null) {
            swapNodes(first, second);
        } else if (first != null && middle != null) {
            swapNodes(first, second);
        }

        return root;

    }

    // assumption : There is exactly at most one pair swapped!!
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    private static void findSwappedLocation(final BinaryTreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        // in-order traversal of the left sub-tree
        findSwappedLocation(currentNode.getLeft());

        // check for the swapped location
        if (previous != null &&
                currentNode.getData() < previous.getData()) {

            // check if this is the first occurrence
            if (first == null) {
                first = previous;
                middle = currentNode;
            } else {
                // this is the second appearcne
                second = currentNode;
            }
        }

        // update the previous Node
        previous = currentNode;

        // in-order traversal of the right sub-tree
        findSwappedLocation(currentNode.getRight());
    }

    // Time Complexity : O(1)
    // swaps the contents of two nodes
    private static void swapNodes(final BinaryTreeNode nodeOne, final BinaryTreeNode nodeTwo) {
        final int temp = nodeOne.getData();
        nodeOne.setData(nodeTwo.getData());
        nodeTwo.setData(temp);
    }

    ```

## Mathemetical (oe) :smile: (pure solution by me)
- **Floor** : Node with smallest data larger than or equal to key value
  - This is my customized solution. I strongly recommend this.
  ```JAVA
  // Time Complexity : O(log N) of O(log h)
    // Space Complexity : O(N)
    public static Integer getFloor(final BinaryTreeNode root, final int number) {
        System.out.println("### Getting floor for " + number);
        return getFloorUtil(root, null, number);
    }

    // Time Complexity : O(log N) of O(log h)
    // Space Complexity : O(N)
    private static Integer getFloorUtil(final BinaryTreeNode root, Integer currentFloor, final int number) {

        // Base case 1
        if (root == null) {
            return currentFloor;
        }

        // Base case 2
        if (root.getData() == number) {
            return number;

            // Base case 3
        } else if (root.getData() > number) {
            return getFloorUtil(root.getLeft(), currentFloor, number);

            // Base case 4 : root.getData < number
        } else {
            if (currentFloor == null) {
                currentFloor = root.getData();
            } else {
                currentFloor = (currentFloor>=root.getData()?currentFloor:root.getData());
            }
            // any result better than this would be in the right subtree i.e. greater than current value
            return getFloorUtil(root.getRight(), currentFloor, number);
        }
    }
  ```
- **Ceil** : Node with largest data smaller or equal to key value.
  - Inspired by abpve solution;

  ```JAVA
  public static Integer getCeil(final BinaryTreeNode root, final int number) {
        System.out.println("### Getting Ceil for " + number);
        return getCeilUtil(root, null, number);
    }

    private static Integer getCeilUtil(final BinaryTreeNode root, Integer currentCeil, final int number) {
        if (root == null) {
            return currentCeil;
        }

        if (root.getData() == number) {
            return number;
        } else if (root.getData() < number) {
            return getCeilUtil(root.getRight(), currentCeil, number);
        } else {
            if (currentCeil == null) {
                currentCeil = root.getData();
            } else {
                currentCeil = (currentCeil <= root.getData()?currentCeil:root.getData());
            }

            return getCeilUtil(root.getLeft(), currentCeil, number);
        }
    }
  ```


## Conversions

### Sorted LL to Balance BST:
- Looks pretty easy; **BSTAndDLLConversion.java**

```java
private static LLNode sortedLinkedListHead;

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static BinaryTreeNode convertSortedLLToBalanceBST(LLNode head) {
        sortedLinkedListHead = head;
        // O(N)
        final int length = LLNode.getLength(head);
        // O(N)
        return convertSortedLLToBalanceBSTUtil(0, length - 1);
    }

    private static BinaryTreeNode convertSortedLLToBalanceBSTUtil(final int start, final int end) {
        if (start > end) {
            return null;
        }

        final int m = (start + end) / 2;

        final BinaryTreeNode leftSubtree = convertSortedLLToBalanceBSTUtil(start, m -1);
        final BinaryTreeNode root = new BinaryTreeNode(sortedLinkedListHead.getData());
        sortedLinkedListHead = sortedLinkedListHead.getNext();
        final BinaryTreeNode rightSubtree = convertSortedLLToBalanceBSTUtil(m + 1, end);
        root.setLeft(leftSubtree);
        root.setRight(rightSubtree);
        return root;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class LLNode {
        @NonNull
        private int data;
        private LLNode next;

        public static int getLength(final LLNode root) {
            if (root == null) return 0;
            else return 1 + getLength(root.next);
        }
    }

```

### Sorted DLL to Balanced BST (oe) :smile:
- same as above

### Sorted Array to Balance BST (oe) :smile:
- same as above


## Merge two Balanced BSTs into the larger Balanced BSTs (oe) :smile:
- Algorithm:
```python
// Time Complexity O(M+N)
def mergeBalancedBSTs(bb1, bb2):
  int[] a <- inOrder(bb1) // O(M) and would be Sorted
  int[] b <- inOrder(bb2) // O(N) and would be Sorted
  int[] c <- sortedMerge(a, b) // O(M+N) and would be Sorted
  return convert c (i.e. sortede Array) to Balanaced BST // O(M+N)
```

## BST to Balance BST (oe) :smile:
- Algorithm
// Time Complexity O(N)
// Space Complexity O(N)
```python
def convertBST2BalancedBST(bst):
  int[] a <- inOrder(bst) // O(N) would be sorted array
  return convert a (i.e. sortede Array) to Balanaced BST // O(N)
```

## Binary Tree to BST (Keeping the shape) (oe) :smile:
- Algorithm:

```python
def binaryTree2BST(bt):
  int[] a <- anyTraversal(bt) // O(N) unsorted
  sort(a) <- O(n log n)

  // make sure we have to keep the shape same
  start the inOrderTraversal of the bt and start index = 0
  keep updating the data of each node with a[index]
  index++
```

## The End
