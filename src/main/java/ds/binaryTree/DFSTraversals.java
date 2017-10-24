package ds.binaryTree;

import java.util.Stack;

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

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static void preOrderUsingStack(final BinaryTreeNode root){
        System.out.println("### Pre-Order using Stack###");
        if (root == null)
            return;

        final Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);

        BinaryTreeNode currentNode;

        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode.getData() + " ");

            // NOTE: right one is pushed before the right one so that left one is popped before the right one
            if (currentNode.getRight() != null) stack.push(currentNode.getRight());
            if (currentNode.getLeft() != null) stack.push(currentNode.getLeft());

        }

        System.out.println();

    }


    public static void inOrderUsingStack(final BinaryTreeNode root) {
        System.out.println("### In-order DFS traversal using Stack###");
        if (root == null)
            return;

        final Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode cn = root;

        // STEP1 : Go to the left most node
        while (cn != null) {
            stack.push(cn);
            cn = cn.getLeft();
        }

        // STEP2: Keep printing the node and go to its IN-ORDER-SUCCESSOR
        // i.e. the left most node in the right sub-tree

        while (!stack.isEmpty()) {
            cn = stack.pop();
            System.out.print(cn.getData() + " ");

            cn = cn.getRight();

            while (cn != null) {
                stack.push(cn);
                cn = cn.getLeft();
            }
        }

        System.out.println();

    }

}
