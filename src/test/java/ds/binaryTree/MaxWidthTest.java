package ds.binaryTree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Problem Statement: "Max width test!!"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/24/17
 */
@RunWith(MockitoJUnitRunner.class)
public class MaxWidthTest {
    private final BinaryTreeNode binaryTree = BinaryTreeNode.createSampleTree();

    @Test
    public void shouldGetTheWidth() {
        System.out.println("Max Width" + MaxWidth.getMaxWidthUsingRecursion(binaryTree));
        System.out.println("Max Width" + MaxWidth.getMaxWidthUsingQueue(binaryTree));
        System.out.println("Max Width" + MaxWidth.getMaxWidthUsingQueueOfficial(binaryTree));
    }

}
