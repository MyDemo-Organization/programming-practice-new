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
