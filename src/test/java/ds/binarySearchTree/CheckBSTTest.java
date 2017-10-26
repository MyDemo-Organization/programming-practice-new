package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
@RunWith(MockitoJUnitRunner.class)
public class CheckBSTTest {
    private BinaryTreeNode sampleBST = BinarySearchTree.createSampleBinarySearchTree();

    @Test
    public void shouldCheckBST() {
        System.out.println("### Checking on a valid BST ###");
        System.out.println(CheckBST.isBST(sampleBST));
        sampleBST.setData(10);
        sampleBST.printTree();
        System.out.println("### Checking on an in valid BST ###");
        System.out.println(CheckBST.isBST(sampleBST));
    }
}
