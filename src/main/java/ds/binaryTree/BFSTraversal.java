package ds.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: "BFS"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
public class BFSTraversal {
    // Time Complexity : O(N^2)
    public static void levelOrderTraversal(final BinaryTreeNode root) {
        final int height = BinaryTreeMeasurement.getHeight(root);
        for (int i = 0; i < height; i++) {
            printSpecificLevel(root, i);
        }
    }

    // Time Complexity : O(N)
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

    // Time Complexity : O(N)
    // Space Complexity : O(N) -> when all the nodes are on the same level
    public static void bfsTraversalUsingQueue(final BinaryTreeNode root) {
        System.out.println("### BFS USING QUEUE ###");
        if (root == null)
            return;
        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);

        BinaryTreeNode currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode.getData() + " ");
            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        System.out.println();
    }

}
