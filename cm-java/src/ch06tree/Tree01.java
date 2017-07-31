package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-1 Give an algorithm for finding maximum element in binary tree.
 */
public class Tree01 {
    static BinaryTreeNode root;

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int findMax(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE, rootValue, leftMax, rightMax;

        if (root != null) {
            rootValue = root.getData();
            leftMax = findMax(root.getLeft());
            rightMax = findMax(root.getRight());

            if (leftMax > rightMax)
                max = leftMax;
            else
                max = rightMax;

            if (rootValue > max)
                max = rootValue;
        }

        return max;
    }

    public static void main(String[] args) {
        Tree01 tree = new Tree01();
        tree.findMax(root);
    }
}
