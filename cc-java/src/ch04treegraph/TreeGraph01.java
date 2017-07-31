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
 *                     Hints #21. Think about the definition of a balanced tree.
 *                                Can you check that condition for a single node?
 *                                Can you check it for every node?
 *                     Hints #33. If you've developed a brute force solution, be careful about its runtime.
 *                                If you are computing the height of the subtrees for each node,
 *                                you could have a pretty inefficient algorithm.
 *                    Hints #49. What if you could modify the binary tree node class
 *                               to allow a node to store the height of its subtree?
 *                    Hints #105. You don't need to modify the binary tree class to store the height of the subtree.
 *                                Can your recursive function compute the height of each subtree
 *                                while also checking if a node is balanced?
 *                    Hints #124. Actually, you can just have a single checkHeight function that does
 *                                both the height computation and the balance check.
 *                                An integer return value can be used to indicate both.
 */

// Summary (6E)
/**
 * the two subtrees differ in height by no more than one.
 *  --> simply recurse through the entire tree.
 *
 * Although this works, it's not very efficient.
 *  --> On each node, getHeight() is called repeatedly on the same nodes. --> O(N log N)
 *
 * This improved algorithm
 *  - if the subtree is balanced, the checkHeight() will return the actual height of the subtree.
 *  - if not balanced, will return an error code
 *  - The height of a null tree is generally defined to be -1.
 *  - an error code --> Integer.MIN_VALUE
 */

//TODO:
/**
 * no two leaf nodes differ in distance from root by more than one == the heights of the two subtrees of any node never differ by more than one.
 *  --> 거리(즉, depth) 와 Height 정의 및 관계 정리 필요
 */
public class TreeGraph01 {
    /*
        a balanced tree
            - no two leaf nodes differ in distance from root by more than one.
            - the height of the two subtrees on any node never differ by more than one.
     */

    //--------------------------------------------------------------------------------
    // Solution #1: Brute Force
    //--------------------------------------------------------------------------------
    // 해답은 구할수 있으나, 비효율적 : 이 알고리즘은 getHeight() 가 각 노드에 대해서 isBalanced() 가 호출될때마다 여러번 호추되므로
    // O(N log N)
    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // getHeight() is called repeatedly.
    public static boolean isBalancedBrueForce(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDiff > 1) {
            return false;
        } else {
            // Recurse
            return isBalancedBrueForce(root.left) && isBalancedBrueForce(root.right);
        }
    }

    //--------------------------------------------------------------------------------
    // Solution #2: Improved
    //--------------------------------------------------------------------------------
    // Balanced 체크는 트리의 모든 노드에 대해서 left/right subtree 의 높이 차이가 1 이하여야 하므로 높이만 체크하면 된다.
    // 이때, 높이는 각 노드별로 한번씩만 체크될수 있도록하여 효율적인 알고리즘을 구현할 수 있다.
    // ==> 결론적으로, 하나의 노드라도 높이 차이가 1이상이면 무조건 에러(Integer.MIN_VALUE) 를 리턴하고 로직을 종료하면 된다.
    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;  // the length of null node
        }

        // left
        int leftHeight = checkHeight(node.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;   // represent Error
        }

        // right
        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;   // represent Error
        }

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return Integer.MIN_VALUE;   // represent Error
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // O(N) time, O(H) space
    public static boolean isBalancedImproved(TreeNode root) {
        return Integer.MIN_VALUE != checkHeight(root);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        //--------------------------------------------------------------------------------
        // Balanced Tree
        //--------------------------------------------------------------------------------
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);

        System.out.println("Is balanced(Brute)? " + isBalancedBrueForce(root));
        System.out.println("Is balanced(Improved)? " + isBalancedImproved(root));

        //--------------------------------------------------------------------------------
        // Unbalanced Tree
        //--------------------------------------------------------------------------------
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);

        System.out.println("Is balanced(Brute)? " + isBalancedBrueForce(unbalanced));
        System.out.println("Is balanced(Improved)? " + isBalancedImproved(unbalanced));
    }
}
