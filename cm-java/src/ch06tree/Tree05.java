package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem-5 Give an algorithm for inserting an element into binary tree.
 */
public class Tree05 {
    static BinaryTreeNode root; //TODO:

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    void insertInBinaryTree(BinaryTreeNode root, int data) {
        BinaryTreeNode node = new BinaryTreeNode(data); //TODo: memory error

        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            } else {
                temp.setLeft(node);
                queue.clear();
                return;
            }

            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            } else {
                temp.setRight(node);
                queue.clear();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Tree05 tree = new Tree05();
        int data = 5;   //TODO:
        tree.insertInBinaryTree(root, data);
    }
}
