package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-4 Give an algorithm for finding an element in binary tree without recursion.
 */
public class Tree04 {
    static BinaryTreeNode root; //TODO;
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean searchUsingLevelOrder(BinaryTreeNode root, int data) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;

        if (root == null)
            return false;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            if (temp.getData() == data) {
                queue.clear();
                return true;
            }

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        queue.clear();  //TODO:
        return false;
    }
}
