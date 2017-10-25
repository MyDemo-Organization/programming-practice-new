package ds.binaryTree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/24/17
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateBinaryTreeFromTraversalsTest {
    private final BinaryTreeNode binaryTree = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldCreateBinaryTreeFromTraversals() {
        DFSTraversals.preOrderUsingStack(binaryTree);
        DFSTraversals.inOrderUsingStack(binaryTree);
        System.out.println("### POST Order Traversal ###");
        DFSTraversals.postOrderTraversal(binaryTree);
        System.out.println();
        final int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        final int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        final int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        final BinaryTreeNode createdBinaryTree1 = CreateBinaryTreeFromTraversals.getBinaryTreeFromInorderAndPreOrder(inOrder, preOrder);
        createdBinaryTree1.printTree();
        final BinaryTreeNode createdBinaryTree2 = CreateBinaryTreeFromTraversals.getBinaryTreeFromInorderAndPostOrder(inOrder, postOrder);
        createdBinaryTree2.printTree();
    }
}
