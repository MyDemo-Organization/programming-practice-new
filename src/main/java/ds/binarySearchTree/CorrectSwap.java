package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

/**
 * Problem Statement: "Correct the binary tree with exact a pair swaps"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/26/17
 */
public class CorrectSwap {

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

    static class CorrectSwapP1 {
        private static BinaryTreeNode previous, first, middle, second;

        public static BinaryTreeNode correctPairSwap(final BinaryTreeNode root) {
            previous = first = second = middle = null;

            // find the swapped location
            findSwappedLocation(root);

            if (first != null && second != null) {
                swapNodes(first, second);
            } else if (first != null && middle != null) {
                swapNodes(first, middle);
            }
            return root;
        }

        private static void findSwappedLocation(final BinaryTreeNode currentNode) {

            if (currentNode == null)
                return;

            findSwappedLocation(currentNode.getLeft());

            if (previous != null && currentNode.getData() < previous.getData()) {

                if (first == null) {
                    first = previous;
                    middle = currentNode;

                } else {
                    second = currentNode;
                }
            }
            previous = currentNode;
            findSwappedLocation(currentNode.getRight());
        }

        private static void swapNodes(final BinaryTreeNode nodeOne, final BinaryTreeNode nodeTwo) {
            final int temp = nodeOne.getData();
            nodeOne.setData(nodeTwo.getData());
            nodeTwo.setData(temp);
        }
    }
}


