package ds.binaryTree;

/**
 * Problem Statement: "BFS"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
public class BFSTraversal {
    public static void levelOrderTraversal(final BinaryTreeNode root) {
        final int height = BinaryTreeMeasurement.getHeight(root);
        for (int i = 0; i < height; i++) {
            printSpecificLevel(root, i);
        }
    }

    public static void printSpecificLevel(final BinaryTreeNode node, final int level) {
        if (node == null)
            return;
        if (level == 0){
            System.out.print(node.getData() + " ");
            return;
        }
        printSpecificLevel(node.getLeft(), level - 1);
        printSpecificLevel(node.getRight(), level - 1);
    }

}
