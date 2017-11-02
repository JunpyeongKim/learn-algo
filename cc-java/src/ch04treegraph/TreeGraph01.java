package ch04treegraph;

import lib.AssortedMethods;
import lib.TreeNode;

/**
 * 4.1 주어진 이진 트리가 균형 이진 트리인지 판별하는 함수를 구현하라.
 *     이 문제에서 이진 트리는 어떤 노드의 두 자식 트리의 깊이가 하나 이상 차이나지 않는 트리다.
 *
 * (4E)
 * 4.1 Implement a function to check if a tree is balanced.
 *     For the purposes of this question, a balanced tree is defined to be a tree such that
 *     no two leaf nodes differ in distance from the root by more than one.
 *
 * (6E)
 * 4.4 Check Balanced: Implement a function to check if a binary tree is balanced.
 *                     For the purposes of this question, a balanced tree is defined to be a tree such that
 *                     the heights of the two subtrees of any node never differ by more than one.
 *
 *                     Hints
 *                     #21. Think about the definition of a balanced tree.
 *                          Can you check that condition for a single node?
 *                          Can you check it for every node?
 *                     #33. If you've developed a brute force solution, be careful about its runtime.
 *                          If you are computing the height of the subtrees for each node,
 *                          you could have a pretty inefficient algorithm.
 *                     #49. What if you could modify the binary tree node class
 *                          to allow a node to store the height of its subtree?
 *                     #105. You don't need to modify the binary tree class to store the height of the subtree.
 *                           Can your recursive function compute the height of each subtree
 *                           while also checking if a node is balanced?
 *                     #124. Actually, you can just have a single checkHeight function that does
 *                           both the height computation and the balance check.
 *                           An integer return value can be used to indicate both.
 */
public class TreeGraph01 {
    /**
     * a balanced tree
     * --> no two leaf nodes differ in distance from root by more than one
     * --> the heights of the two subtrees of any node never differ by more than one.
     */


    //--------------------------------------------------------------------------------
    // Solution #1: Brute Force
    //--------------------------------------------------------------------------------
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // simply recurse through the entire tree.
    // Although this works, it's not very efficient.
    // On each node, getHeight() is called repeatedly on the same nodes.
    // O(N log N)
    public static boolean isBalanced01(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDiff > 1) {
            return false;
        } else {
            // Recurse
            return isBalanced01(root.left) && isBalanced01(root.right);
        }
    }

    //--------------------------------------------------------------------------------
    // Solution #2: Improved
    //              --> the tree height >= -1
    //--------------------------------------------------------------------------------
    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;  // the height of a null tree is generally defined to be -1.
        }

        // Left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;   // an error code
        }

        // Right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;   // an error code
        }

        // Difference 
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return Integer.MIN_VALUE;   // an error code
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // if the subtree is balanced, the checkHeight() will return the actual height of the subtree.
    // if not balanced, will return an error code.
    // O(N) time, O(H) space
    public static boolean isBalanced02(TreeNode root) {
        return Integer.MIN_VALUE != checkHeight(root);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // Balanced Tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);

        System.out.println("Root(" + root.data + ") is balanced?");
        System.out.println("\tBruteForce(" + isBalanced01(root) + "), Improved(" + isBalanced02(root) + ")");

        // Unbalanced Tree
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }

        System.out.println("Root(" + unbalanced.data + ") is balanced?");
        System.out.println("\tBruteForce(" + isBalanced01(unbalanced) + "), Improved(" + isBalanced02(unbalanced) + ")");
    }
}
