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
public class LowestCommonAncestorTest {
    private final BinaryTreeNode bst = BinarySearchTree.createSampleBinarySearchTree();

    @Test
    public void shouldGetLCA() {
        System.out.println("Getting LCA of 7 and 6");
        System.out.println(LowestCommonAncestor.getLowestCommonAncestor(bst, 6, 7).getData());
        System.out.println("Getting LCA of 2 and 5");
        System.out.println(LowestCommonAncestor.getLowestCommonAncestor(bst, 2, 5).getData());
    }

}
