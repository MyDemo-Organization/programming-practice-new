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
public class KDistantNodesTest {
    private BinaryTreeNode binaryTree = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldGetKDistantNodes() {
        for (int i = 0; i < 5; i++) {
            System.out.println("### Printing for level " + i + " ###");
            KDistantNodes.printKDistantNodes(binaryTree, i);
            System.out.println();
        }
    }
}
