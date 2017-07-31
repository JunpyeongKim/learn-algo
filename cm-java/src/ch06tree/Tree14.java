package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-14 Give an algorithm for finding the number of leaves in the binary tree without using recursion.
 */
public class Tree14 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int numberofLeavesInBTUsingLevelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;
        int count = 0;

        if (root == null)
            return 0;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            if (temp.getLeft() == null && temp.getRight() == null)
                count++;

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        return count;
    }

    public static void main(String[] args) {
        Tree14 tree = new Tree14();
        tree.numberofLeavesInBTUsingLevelOrder(root);
    }
}
