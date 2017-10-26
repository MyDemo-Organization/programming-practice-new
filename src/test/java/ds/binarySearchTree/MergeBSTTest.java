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
public class MergeBSTTest {


    @Test
    public void shouldMergeBSTs() {
        BinaryTreeNode bst1 = BinarySearchTree.createSampleBinarySearchTree();
        BinaryTreeNode bst2 = BinarySearchTree.createSampleBinarySearchTree();
        MergeBST.merge(bst1, bst2).printTree();
    }

    @Test
    public void mergeInOrder() {
        BinaryTreeNode bst1 = new BinaryTreeNode(3);
        bst1 = BinarySearchTree.insert(bst1,1);
        bst1 = BinarySearchTree.insert(bst1,5);
        bst1.printTree();

        BinaryTreeNode bst2 = new BinaryTreeNode(4);
        bst2 = BinarySearchTree.insert(bst2,2);
        bst2 = BinarySearchTree.insert(bst2,6);
        bst2.printTree();

        System.out.println("### Merging in-order ##");
        MergeBST.mergeInorder(bst2, bst1).printTree();

        bst1 = new BinaryTreeNode(3);
        bst1 = BinarySearchTree.insert(bst1,1);
        bst1 = BinarySearchTree.insert(bst1,5);
        bst1.printTree();

        bst2 = new BinaryTreeNode(4);
        bst2 = BinarySearchTree.insert(bst2,2);
        bst2 = BinarySearchTree.insert(bst2,6);
        bst2.printTree();
        System.out.println("## Merging level-order ##");
        MergeBST.merge(bst2, bst1).printTree();


    }
}
