package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-10 Give an algorithm for finding the height (or depth) of the binary tree.
 */
public class Tree10 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int heightOfBinaryTree(BinaryTreeNode root) {
        int height = 0;
        int leftHeight, rightHeight, maxHeight = Integer.MIN_VALUE;

        if (root == null)
            return 0;

        leftHeight = heightOfBinaryTree(root.getLeft());
        rightHeight = heightOfBinaryTree(root.getRight());

        if (leftHeight > rightHeight)
            maxHeight = leftHeight;
        else
            maxHeight = rightHeight;

        height = 1 + maxHeight;

        return height;
    }

    public static void main(String[] args) {
        Tree10 tree = new Tree10();
        tree.heightOfBinaryTree(root);
    }
}
