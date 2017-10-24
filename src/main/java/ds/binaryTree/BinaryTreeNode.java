package ds.binaryTree;

import lombok.*;

/**
 * Problem Statement: "Binary Tree Node"
 *
 * This clas represent a Binary Tree node and it also has the
 * utility method to print the node in the proper tree format;
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/23/17
 */
@Getter
@Setter
@RequiredArgsConstructor
public class BinaryTreeNode {
    @NonNull
    private Integer data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" + left +  ", " + data + ", " + right
                + "}" ;
    }

    public void printTree() {
        if (right != null) {
            right.printTree(true, "");
        }
        printNodeValue();
        if (left != null) {
            left.printTree(false, "");
        }
    }

    private void printNodeValue()  {
        if (data == null) {
            System.out.print("<null>");
        } else {
            System.out.print(data.toString());
        }
        System.out.print('\n');
    }

    private void printTree( boolean isRight, String indent)  {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue();
        if (left != null) {
            left.printTree( false, indent + (isRight ? " |      " : "        "));
        }
    }


    public static BinaryTreeNode createSampleTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        BinaryTreeNode right = new BinaryTreeNode(3);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode five = new BinaryTreeNode(5);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode seven = new BinaryTreeNode(7);
        left.setLeft(four);
        left.setRight(five);
        right.setLeft(six);
        right.setRight(seven);
        root.setLeft(left);
        root.setRight(right);
        root.printTree();
        return root;
    }

}
