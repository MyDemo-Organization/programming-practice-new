package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class LowestCommonAncestor {
    // LCA has one key greater and one key smaller than its node value
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
}
