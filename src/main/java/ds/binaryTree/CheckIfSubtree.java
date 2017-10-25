package ds.binaryTree;

/**
 * Problem Statement: "CheckIfSubtree"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class CheckIfSubtree {

    // Time Complexity : O(N^2)
    public static boolean isSubTree(final BinaryTreeNode parent, final BinaryTreeNode child) {
        // Base case 1
        if (child == null)
            return true;

        // Base case 2
        if (parent == null)
            return false;

        if (areIdentical(parent, child))
            return true;

        return isSubTree(parent.getLeft(), child) || isSubTree(parent.getRight(), child);
    }

    // Time Complexity : O(N)
    private static boolean areIdentical(final BinaryTreeNode root1, final BinaryTreeNode root2) {

        // Base case 1
        if (root1 == null && root2 == null)
            return true;

        // Base case 2
        if (root1 == null || root2 == null)
            return false;

        // Base case 3
        if (root1.getData() != root2.getData())
            return false;

        return areIdentical(root1.getLeft(), root2.getLeft()) &&
                areIdentical(root1.getRight(), root2.getRight());
    }
}
