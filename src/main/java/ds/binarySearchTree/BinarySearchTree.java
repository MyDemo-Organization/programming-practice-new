package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class BinarySearchTree {

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


    // Time Complexity : O(log N)
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
            // here deleteData == root.getData() i.e. we are at the Node which we have to delete
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

    // Time Complexity : O(log N)
    public static BinaryTreeNode createSampleBinarySearchTree() {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root = insert(root, 2);
        root = insert(root, 6);
        root = insert(root, 1);
        root = insert(root, 3);
        root = insert(root, 5);
        root = insert(root, 7);
        root.printTree();
        return root;
    }
}
