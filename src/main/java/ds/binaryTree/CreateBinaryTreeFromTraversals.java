package ds.binaryTree;

/**
 * Problem Statement: "Create Tree From Traversals"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/24/17
 */
public class CreateBinaryTreeFromTraversals {
    private static int preIndex = 0;
    private static int postIndex = 0;

    // Time Complexity : O(N)
    public static BinaryTreeNode getBinaryTreeFromInorderAndPreOrder(final int[] inOrder,
                                                                     final int[] preOrder) {
        preIndex = 0;
        System.out.println("### Creating tree from preOrder and inOrder Traversal ###");
        return getBinaryTreeFromInorderAndPreOrderUtil(inOrder, preOrder, 0, inOrder.length - 1);
    }

    // Time Complexity : O(N)
    private static BinaryTreeNode getBinaryTreeFromInorderAndPreOrderUtil(final int[] inOrder,
                                                                         final int[] preOrder,
                                                                         int start,
                                                                         int end) {
        // Base case 1:
        if (start > end) {
            return null;
        }

        final BinaryTreeNode root = new BinaryTreeNode(preOrder[preIndex++]);

        // Base Case 2:
        if (start == end){
            return root;
        }
        // get root index in the inOrder traversal
        final int sliceIndex = getRootIndex(inOrder, start, end, root.getData());
        root.setLeft(getBinaryTreeFromInorderAndPreOrderUtil(inOrder, preOrder, start, sliceIndex - 1));
        root.setRight(getBinaryTreeFromInorderAndPreOrderUtil(inOrder, preOrder, sliceIndex + 1, end));
        return  root;
    }

    // Time Complexity : O(N)
    public static BinaryTreeNode getBinaryTreeFromInorderAndPostOrder(final int[] inOrder,
                                                                      final int[] postOrder) {
        postIndex = postOrder.length - 1;
        System.out.println("### Creating tree from inOrder and postOrder Traversal ###");
        return getBinaryTreeFromInorderAndPostOrderUtil(inOrder, postOrder, 0, inOrder.length - 1);
    }

    // Time Complexity : O(N)
    private static BinaryTreeNode getBinaryTreeFromInorderAndPostOrderUtil(final int[] inOrder,
                                                                          final int[] postOrder,
                                                                          int start,
                                                                          int end) {
        // Base case:
        if (start > end) {
            return null;
        }

        final BinaryTreeNode root = new BinaryTreeNode(postOrder[postIndex--]);

        // Base case 2:
        if (start == end){
            return root;
        }

        // get root index in the inOrder traversal
        final int sliceIndex = getRootIndex(inOrder, start, end, root.getData());

        // NOTE: we are making the right sub tree first here in PostOrder + inOrder One :)
        root.setRight(getBinaryTreeFromInorderAndPostOrderUtil(inOrder, postOrder, sliceIndex + 1, end));
        root.setLeft(getBinaryTreeFromInorderAndPostOrderUtil(inOrder, postOrder, start, sliceIndex - 1));
        return  root;
    }

    // assumes that we have the target inside the inOrderTraversal
    // Time Complexity : O(N)
    private static int getRootIndex(final int[] inOrder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == target) return i;
        }
        throw  new IllegalArgumentException("Unable to find the " + target + " inside the given inOrder");
    }
}
