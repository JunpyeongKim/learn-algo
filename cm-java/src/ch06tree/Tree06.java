package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-6 Give an algorithm for finding the size of binary tree.
 */
public class Tree06 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int sizeOfBinaryTree(BinaryTreeNode root) {
        int size = 0;

        if (root == null)
            return 0;

        size = sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight());
        return size;
    }

    public static void main(String[] args) {
        Tree06 tree = new Tree06();
        tree.sizeOfBinaryTree(root);
    }
}
