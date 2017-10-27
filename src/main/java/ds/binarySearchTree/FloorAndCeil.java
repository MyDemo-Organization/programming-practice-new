package ds.binarySearchTree;

import ds.binaryTree.BinaryTreeNode;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/26/17
 */
public class FloorAndCeil {

    public static Integer getFloor(final BinaryTreeNode root, final int number) {
        System.out.println("### Getting floor for " + number);
        return getFloorUtil(root, null, number);
    }

    private static Integer getFloorUtil(final BinaryTreeNode root, Integer currentFloor, final int number) {

        // Base case 1
        if (root == null) {
            return currentFloor;
        }

        // Base case 2
        if (root.getData() == number) {
            return number;

            // Base case 3
        } else if (root.getData() > number) {
            return getFloorUtil(root.getLeft(), currentFloor, number);

            // Base case 4 : root.getData < number
        } else {
            if (currentFloor == null) {
                currentFloor = root.getData();
            } else {
                currentFloor = (currentFloor>=root.getData()?currentFloor:root.getData());
            }
            // any result better than this would be in the right subtree i.e. greater than current value
            return getFloorUtil(root.getRight(), currentFloor, number);
        }
    }
}
