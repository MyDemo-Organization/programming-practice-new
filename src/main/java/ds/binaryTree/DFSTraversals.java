package ds.binaryTree;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
public class DFSTraversals {

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static void preOrderTraversal(final BinaryTreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static void inOrderTraversal(final BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRight());
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static void postOrderTraversal(final BinaryTreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getData() + " ");
    }
}
