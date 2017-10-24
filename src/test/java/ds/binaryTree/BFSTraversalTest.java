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
public class BFSTraversalTest {
    private final BinaryTreeNode binaryTree = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldTraverseLevelOrder() {
        BFSTraversal.levelOrderTraversal(binaryTree);
    }

}
