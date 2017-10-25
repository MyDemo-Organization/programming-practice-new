package ds.binaryTree;

/**
 * Problem Statement: "KDistantNodes"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class KDistantNodes {
    public static void printKDistantNodes(final BinaryTreeNode root, final int level) {
        if (root == null) {
            System.out.println("Sorry, No Nodes at the given level");
            return;
        }

        if (level == 0) {
            System.out.print(root.getData() + " ");
        } else {
            printKDistantNodes(root.getLeft(), level -1);
            printKDistantNodes(root.getRight(), level -1);
        }
    }
}
