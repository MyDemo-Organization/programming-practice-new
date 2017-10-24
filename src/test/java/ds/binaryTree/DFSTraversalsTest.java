package ds.binaryTree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
@RunWith(MockitoJUnitRunner.class)
public class TraversalsTest {

    @Test
    public void shouldDoInorderTraversal() {
        final BinaryTreeNode root =BinaryTreeNode.createSampleTree();
        System.out.println("PRE-ORDER TRAVERSAL: ");
        Traversals.preOrderTraversal(root);
        System.out.println("\nIN-ORDER TRAVERSAL: ");
        Traversals.inOrderTraversal(root);
        System.out.println("\nPOST-ORDER TRAVERSAL: ");
        Traversals.postOrderTraversal(root);
    }
}
