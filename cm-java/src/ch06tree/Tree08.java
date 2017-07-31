package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-8 Give an algorithm for deleting the tree.
 */
public class Tree08 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    void deleteBinaryTree(BinaryTreeNode root) {
        if (root == null)
            return;

        // Before deleting the parent node, we should delete its children nodes first.
        // use postorder traversal.
        deleteBinaryTree(root.getLeft());
        deleteBinaryTree(root.getRight());

        // process current node
        root = null;    //TODO:
    }

    public static void main(String[] args) {
        Tree08 tree = new Tree08();
        tree.deleteBinaryTree(root);
    }
}
