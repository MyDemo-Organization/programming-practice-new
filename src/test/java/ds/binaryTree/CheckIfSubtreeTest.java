package ds.binaryTree;

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
public class CheckIfSubtreeTest {
    private BinaryTreeNode binaryTree1 = BinaryTreeNode.createSampleTree();
    private BinaryTreeNode binaryTree2 = BinaryTreeNode.createSampleTree();
    private BinaryTreeNode binaryTree3 = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldCheckIfSubTree() {
        System.out.println(CheckIfSubtree.isSubTree(binaryTree1, binaryTree2));
        binaryTree3.setData(10);
        System.out.println(CheckIfSubtree.isSubTree(binaryTree1, binaryTree3));
    }
}
