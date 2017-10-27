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
    private static int sortedArrayIndex;

    public static BinaryTreeNode convertSortedDLLToBalancedBST(DLLNode head) {
        sortedDLLHead = head;
        final int length = DLLNode.getLength(sortedDLLHead);
        return convertSortedDLLToBalancedBSTUtil(0, length - 1);
    }

    // Bottom Up approach
    private static BinaryTreeNode convertSortedDLLToBalancedBSTUtil(final int start, final int end) {

        // Base case :)
        if (start > end) {
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


    public static BinaryTreeNode convertSortedLLToBalanceBST(LLNode head) {
        sortedLinkedListHead = head;
        final int length = LLNode.getLength(head);
        return convertSortedLLToBalanceBSTUtil(0, length - 1);
    }

    private static BinaryTreeNode convertSortedLLToBalanceBSTUtil(final int start, final int end) {
        if (start > end) {
            return null;
        }

        final int m = (start + end) / 2;

        final BinaryTreeNode leftSubtree = convertSortedLLToBalanceBSTUtil(start, m -1);
        final BinaryTreeNode root = new BinaryTreeNode(sortedLinkedListHead.getData());
        sortedLinkedListHead = sortedLinkedListHead.getNext();
        final BinaryTreeNode rightSubtree = convertSortedLLToBalanceBSTUtil(m + 1, end);
        root.setLeft(leftSubtree);
        root.setRight(rightSubtree);
        return root;
    }

    public static BinaryTreeNode convertSortedArrayToBalancedBST(int[] sortedArray) {
        sortedArrayIndex = 0;
        final int length = sortedArray.length;
        return null;
    }

    public static BinaryTreeNode convertSortedArrayToBalancedBSTUtil(int[] sortedArray, final int start, final int end) {
        // Base Case
        if (start > end) {
            return null;
        }

        final int m = (start + end) / 2;
        final BinaryTreeNode leftSubTree = convertSortedArrayToBalancedBSTUtil(sortedArray, start, m -1);
        final BinaryTreeNode root = new BinaryTreeNode(sortedArray[sortedArrayIndex]);
        sortedArrayIndex++;
        final BinaryTreeNode rightSubtree = convertSortedArrayToBalancedBSTUtil(sortedArray, m + 1, end);
        root.setLeft(leftSubTree);
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
