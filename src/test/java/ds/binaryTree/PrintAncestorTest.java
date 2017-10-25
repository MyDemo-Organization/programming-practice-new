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
public class PrintAncestorTest {
    private BinaryTreeNode binaryTree = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldPrintAncestors() {
        System.out.println("### PRINTING ANCESTORS ###");
        for (int i = 1; i < 8; i++) {
            System.out.println("### Printing ancestor for " + i + " ###");
            PrintAncestor.getAncestors(binaryTree, i);
            System.out.println();
        }
    }
}
