package ds.binaryTree;

/**
 * Problem Statement: "Print ancestors of a Node"
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/25/17
 */
public class PrintAncestor {
    public static boolean getAncestors(final BinaryTreeNode root, final int data) {
        // BASE-CASE 1
        if (root == null){
            return false;
        }

        // BASE-CASE 2
        if (root.getData() == data){
            System.out.print(root.getData() + " ");
            return true;
        }

        // search in left subtree
        // NOTE: make sure we are printing the root data only :)
        if (getAncestors(root.getLeft(), data)) {
            System.out.print(root.getData() + " ");
            return true;

            // search in the right sub-tree
        } else if (getAncestors(root.getRight(), data)){
            System.out.print(root.getData() + " ");
            return true;
        }

        return false;

    }
}
