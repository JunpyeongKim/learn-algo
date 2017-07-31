package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-17 Given two binary trees, return true if they are structurally identical.
 */
public class Tree17 {
    static BinaryTreeNode root1 = null;
    static BinaryTreeNode root2 = null;

    // Time Complexity: O(n)
    // Space Complexity: O(n) for recursive stack
    boolean areStructurallySameTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if ((root1 == null && root2 == null) || (root1 == root2))
            return true;

        if (root1 == null || root2 == null)
            return false;

        boolean result = (root1.getData() == root2.getData()
                && areStructurallySameTrees(root1.getLeft(), root2.getLeft())
                && areStructurallySameTrees(root1.getRight(), root2.getRight()));

        return result;
    }

    public static void main(String[] args) {
        Tree17 tree = new Tree17();
        tree.areStructurallySameTrees(root1, root2);
    }
}
