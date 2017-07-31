package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-2 Give an algorithm for finding maximum element in binary tree without recursion.
 */
public class Tree02 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int findMaxUsingLevelOrder(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;

        if (root == null)
            return max;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            if (temp.getData() > max)
                max = temp.getData();

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        queue.clear();  //TODO:
        return max;
    }

    public static void main(String[] args) {
        Tree02 tree = new Tree02();
        tree.findMaxUsingLevelOrder(root);
    }
}
