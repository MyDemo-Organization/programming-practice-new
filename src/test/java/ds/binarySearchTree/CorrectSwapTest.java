package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/26/17
 */
@RunWith(MockitoJUnitRunner.class)
public class CorrectSwapTest {
    final BinaryTreeNode correctBST = BinarySearchTree.createSampleBinarySearchTree();

    @Test
    public void shouldCorrectSwap() {
        System.out.println("### Correcting already corrected tree. ###");
        CorrectSwap.correctPairSwap(correctBST).printTree();
        System.out.println("###  adjacent swap (4 and 6) ###");
        correctBST.setData(6);
        correctBST.getRight().setData(4);
        correctBST.printTree();
        System.out.println("### Correcting the adjacent swap!! ###");
        CorrectSwap.correctPairSwap(correctBST).printTree();
        System.out.println("### Non-adjacent swap(2 and 6) ###");
        correctBST.getLeft().setData(6);
        correctBST.getRight().setData(2);
        correctBST.printTree();
        System.out.println("### Correcting the non-adjacent swap!! ###");
        CorrectSwap.correctPairSwap(correctBST).printTree();
    }
}
