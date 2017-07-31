package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-3 Give an algorithm for searching an element in binary tree.
 */
public class Tree03 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n) because of call stack
    public boolean findInBinaryTreeUsingRecursion(BinaryTreeNode root, int data) {
        if (root == null)
            return false;

        if (root.getData() == data)
            return true;

        //TODO:
        return findInBinaryTreeUsingRecursion(root.getLeft(), data) || findInBinaryTreeUsingRecursion(root.getRight(), data);
    }

    public static void main(String[] args) {
        Tree03 tree = new Tree03();
        int data = 5;   //TODO:
        tree.findInBinaryTreeUsingRecursion(root, data);
    }
}
