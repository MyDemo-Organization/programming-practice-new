package ds.binaryTree;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
public class BinaryTreeMeasurement {
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static int getHeight(final BinaryTreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    // Time Complexity : O(N^2)
    public static int getDiameter(final BinaryTreeNode node) {
        if (node == null)
            return 0;
        return Math.max(1 + getHeight(node.getLeft()) + getHeight(node.getLeft()),
                Math.max(getDiameter(node.getLeft()),
                        getDiameter(node.getRight())));
    }
}
