package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-19 Give an algorithm for finding the level that has the maximum sum in the binary tree.
 */
public class Tree19 {
    static BinaryTreeNode root = null; //TODO:

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int findLevelWithMaxSum(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;
        int maxLevel= 0, maxSum = Integer.MIN_VALUE;
        int currentLevel = 0, currentSum = 0;

        if (root == null)
            return 0;

        // enqueue
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            if (temp == null) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxLevel = currentLevel;
                }

                currentSum = 0;
                currentLevel++;

                if (!queue.isEmpty())
                    queue.offer(null);
            } else {
                // process current node
                currentSum += temp.getData();

                if (temp.getLeft() != null)
                    queue.offer(temp.getLeft());

                if (temp.getRight() != null)
                    queue.offer(temp.getRight());
            }
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        Tree19 tree = new Tree19();
        tree.findLevelWithMaxSum(root);
    }
}
