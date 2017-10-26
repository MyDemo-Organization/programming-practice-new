package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class CheckBST {

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


}
