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
public class BinarySearchTreeTest {
    private BinaryTreeNode sampleBST = BinarySearchTree.createSampleBinarySearchTree();

    @Test
    public void shouldInsertNodes() {
        BinaryTreeNode testTree = null;
        for (int i = 1; i <=7; i++) {
            System.out.println("### Inserting " + i + " ###");
            testTree = BinarySearchTree.insert(testTree, i);
            testTree.printTree();
        }
        testTree = BinarySearchTree.insert(testTree, -7);
        testTree.printTree();
        testTree = BinarySearchTree.insert(testTree, 0);
        testTree.printTree();
        testTree = BinarySearchTree.insert(testTree, -3);
        testTree.printTree();
        System.out.println();
    }

    @Test
    public void shouldSearchData() {
        System.out.println("### Searching 1 ###");
        System.out.println(BinarySearchTree.search(sampleBST, 1) != null);
        System.out.println("### Searching 0 ###");
        System.out.println(BinarySearchTree.search(sampleBST, 0) != null);
        System.out.println("### Searching 8 ###");
        System.out.println(BinarySearchTree.search(sampleBST, 7) != null);
    }

}
