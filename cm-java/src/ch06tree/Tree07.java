package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-7 Can we solve Problem-6 without recursion?
 */
public class Tree07 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int sizeOfBTUsingLevelOrder(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;
        int size = 0;

        if (root == null)
            return 0;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            size++;

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        return size;
    }

    public static void main(String[] args) {
        Tree07 tree = new Tree07();
        tree.sizeOfBTUsingLevelOrder(root);
    }
}
