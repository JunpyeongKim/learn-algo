package ch06tree;

import ch06tree.spec.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem-9 Give an algorithm for printing the level order data in reverse order.
 *           For example, the output for the below tree shoud be: 4 5 6 7 2 3 1
 */
public class Tree09 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    void levelOrderTraversalInReverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp;

        if (root == null)
            return;

        // enqueue
        queue.offer(root);

        while(!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            stack.push(temp);

            if (temp.getRight() != null)
                queue.offer(temp.getRight());

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());
        }

        while(!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.getData() + " ");
        }
    }

    public static void main(String[] args) {
        Tree09 tree = new Tree09();
        tree.levelOrderTraversalInReverse(root);
    }
}
