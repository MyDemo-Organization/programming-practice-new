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
public class BinaryTreeMeasurementTest {
    private final BinaryTreeNode binaryTreeNode = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldGetTheHeight() {
        System.out.println(BinaryTreeMeasurement.getHeight(binaryTreeNode));
    }

    @Test
    public void shouldGetDiameter() {
        System.out.println(BinaryTreeMeasurement.getDiameter(binaryTreeNode));
    }
}
