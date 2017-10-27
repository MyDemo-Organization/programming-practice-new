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
public class FloorAndCeilTest {

    private final BinaryTreeNode bst = BinarySearchTree.createSampleBinarySearchTree();

    @Test
    public void shouldGetFloor() {
        for (int i = 0; i < 10; i++) {
            System.out.println(FloorAndCeil.getFloor(bst, i));
        }

    }

}
