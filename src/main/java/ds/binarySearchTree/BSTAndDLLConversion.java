package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/26/17
 */
public class BSTAndDLLConversion {

    private static BinaryTreeNode bstRoot;
    private static DLLNode sortedDLLHead;
    private static LLNode sortedLinkedListHead;
    private static int[] sortedArray;

    public static BinaryTreeNode convertSortedDLLToBalancedBST(DLLNode sortedDLLHead) {
        sortedDLLHead = sortedDLLHead;
        final int length = DLLNode.getLength(sortedDLLHead);
        return convertSortedDLLToBalancedBSTUtil(0, length - 1);
    }

    // Bottom Up approach
    public static BinaryTreeNode convertSortedDLLToBalancedBSTUtil(final int start, final int end) {

        // Base case :)
        if (start < end) {
            return null;
        }

        final int m = (start + end) / 2;
        // create left subtree
        final BinaryTreeNode leftSubtree = convertSortedDLLToBalancedBSTUtil(start, m -1);
        final BinaryTreeNode root = new BinaryTreeNode(sortedDLLHead.getData());
        sortedDLLHead = sortedDLLHead.getFront();
        final BinaryTreeNode rightSubtree = convertSortedDLLToBalancedBSTUtil(m + 1, end);
        root.setLeft(leftSubtree);
        root.setRight(rightSubtree);
        return root;
    }


    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class DLLNode {
        @NonNull
        private int data;
        private DLLNode front;
        private DLLNode back;

        public static int getLength(final DLLNode root) {
            if (root == null) return 0;
            else return 1 + getLength(root.front);
        }
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class LLNode {
        @NonNull
        private int data;
        private LLNode next;

        public static int getLength(final LLNode root) {
            if (root == null) return 0;
            else return 1 + getLength(root.next);
        }
    }
}
