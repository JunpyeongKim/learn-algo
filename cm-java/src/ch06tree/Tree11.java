package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-11 Can we solve Problem-10 without recursion?
 */
public class Tree11 {
    static BinaryTreeNode root;

    int findHeightOfBinaryTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;
        int level = 0;

        if (root == null)
            return 0;

        // enqueue
        queue.offer(root);
        queue.offer(null);  // end of first level

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            if (temp == null) {
                level++;

                if (!queue.isEmpty())
                    queue.offer(null);  // put another marker for next level
            } else {
                if (temp.getLeft() != null)
                    queue.offer(temp.getLeft());

                if (temp.getRight() != null)
                    queue.offer(temp.getRight());
            }
        }

        return level - 1;
    }

    public static void main(String[] args) {
        Tree11 tree = new Tree11();
        tree.findHeightOfBinaryTree(root);
    }
}
