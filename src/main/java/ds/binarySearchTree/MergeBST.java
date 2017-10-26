package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/26/17
 */
public class MergeBST {
    // Time Complexity : O(N * log (M + N)) (level Order)
    public static BinaryTreeNode merge(BinaryTreeNode parentRoot, final BinaryTreeNode childTree ) {
        // Base case 1: parent is null
        if (parentRoot == null)
            return childTree;

        // Nase case 2: child is null
        if (childTree == null)
            return parentRoot;

        // lets do a level order traversal of the child tree
        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(childTree);
        BinaryTreeNode currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            // insert it into the other node
            parentRoot = BinarySearchTree.insert(parentRoot, currentNode.getData());

            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        return parentRoot;
    }

    public static BinaryTreeNode mergeInorder(BinaryTreeNode parentRoot, final BinaryTreeNode childTree) {
        // Base case 1: parent is null
        if (parentRoot == null)
            return childTree;

        // Base case 2: child is null
        if (childTree == null);

        // lets do inorder Traversal of the child Tree using the Stack
        final Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        BinaryTreeNode cn = childTree;

        // STEP 1: Go to the first elemt of in order traversal i.e. Left most Node
        while (cn != null) {
            stack.push(cn);
            cn = cn.getLeft();
        }

        while (!stack.isEmpty()) {
            cn = stack.pop();

            // insert this into the parent tree
            parentRoot = BinarySearchTree.insert(parentRoot, cn.getData());

            // go the in-order successor i.e left most Node in the right sub-tree
            cn = cn.getRight();

            while (cn != null) {
                stack.push(cn);
                cn = cn.getLeft();
            }
        }
        return parentRoot;
    }
}
