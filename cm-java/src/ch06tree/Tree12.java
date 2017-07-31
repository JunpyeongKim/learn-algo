package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-12 Give an algorithm for finding the deepest node of the binary tree.
 */
public class Tree12 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp = null;

        if (root == null)
            return null;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        return temp;
    }

    public static void main(String[] args) {
        Tree12 tree = new Tree12();
        tree.deepestNodeInBinaryTree(root);
    }
}
