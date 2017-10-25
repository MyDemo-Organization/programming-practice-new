package ds.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 10/24/17
 */
public class MaxWidth {

    // Time Complexity : O(N^2)
    public static int getMaxWidthUsingRecursion(final BinaryTreeNode root) {
        int max = 0;
        final int height = BinaryTreeMeasurement.getHeight(root);
        for (int i = 0; i < height; i++) {
            final int currentLevelWidth = getWidthOfGivenLevel(root, i);
            System.out.println("Level : " + i + " => Width : " + currentLevelWidth);
            max = Math.max(max, currentLevelWidth);

        }
        return max;
    }

    // Time Complexity : O(N)
    private static int getWidthOfGivenLevel(final BinaryTreeNode root, final int level){
        // BASE CASE 1
        if (root == null)
            return 0;
        // BASE CASE 2
        if (level == 0)
            return 1;
        return getWidthOfGivenLevel(root.getLeft(), level - 1)  + getWidthOfGivenLevel(root.getRight(), level -1);
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static int getMaxWidthUsingQueue(final BinaryTreeNode root) {
        if (root == null)
            return 0;

        if (root.isLeaf())
            return 1;

        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        int previousWidth = 1;
        int max = previousWidth;

        int level = 1;
        System.out.println("LEVEL : " + level + " => Width : " + previousWidth);
        
        while(!queue.isEmpty()){
            int currentWidth = 0;
            System.out.println("LEVEL : " + level + " => Width : " + currentWidth);
            while (previousWidth > 0) {
                final BinaryTreeNode currentNode = queue.poll();
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                    currentWidth++;
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                    currentWidth++;
                }
                previousWidth--;
            }
            level++;
            max = Math.max(max, currentWidth);
            previousWidth = currentWidth;
        }

        return max;
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public static int getMaxWidthUsingQueueOfficial(final BinaryTreeNode root) {
        if (root == null)
            return 0;

        if (root.isLeaf())
            return 1;

        final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        int max = 1;

        int level = 1;
        System.out.println("LEVEL : " + level + " => Width : " + 1);

        while(!queue.isEmpty()){
            int currentWidth = queue.size();
            System.out.println("LEVEL : " + level + " => Width : " + currentWidth);
            while (currentWidth > 0) {
                final BinaryTreeNode currentNode = queue.poll();
                max = Math.max(max, currentWidth);
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
                currentWidth--;
            }
            level++;
        }

        return max;
    }
}
