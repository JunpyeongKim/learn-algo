package ch04treegraph;

import lib.TreeNode;

/**
 * 4.3 오름차순으로 정렬된 배열로부터 그 높이가 가장 낮은 이진 탐색 트리를 생성하는 알고리즘을 작성하라.
 *     배열 내 모든 원소는 배열 내에서 유일한 값을 갖는다.
 *
 * (4E)
 * 4.3 Given a sorted(increasing order) array,
 *     write an algorithm to create a binary tree with minimal height.
 *
 * (6E)
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
 *                   write an algorithm to create a binary search tree with minimal height.
 *
 *                   Hints:
 *                   #19. A minimal binary tree has about the same number of nodes on the left of each nodes as on the right.
 *                        let's focus on just the root for now.
 *                        How would you ensure that about the same number of nodes are on the left of the root as on the right?
 *                   #73. You could implement this by finding the "ideal" next element to add and repeatedly calling insertValue.
 *                        This will be a bit inefficient, as you would have to repeatedly traverse the tree.
 *                        Can you divide this problem into subproblems?
 *                   #116. Imagine we had a createMinimalTree method that returns a minimal tree for a given array
 *                         (but for some strange reason doesn't operate on the root of the tree).
 *                         Could you use this to operate on the root of the tree?
 *                         Could you write the base case for the function? Great! Then that's basically the entire function.
 */

public class TreeGraph03 {
    /**
     * we need to match the number of nodes in the left subtree to the number of nodes in the right subtree as much as possible.
     *  - we want the root to be the middle of the array.
     *  - half the elements would be less than the root and half would be greater than it.
     *
     * The middle of each subsection of the array becomes the root of the node.
     *  - The left half of the array will become our left subtree,
     *  - and the right half of the array will become our right subtree.
     *
     * One way to implement this: root.insertNode(int v)
     *  - inserts the value through a recursive process --> not so very efficiently.
     *  - O(N logN) time
     *
     * Alternatively, createMinimalBST()
     *  - a subsection of the array is passed.
     *  - returns the root of a minimal tree for that array
     */

    //--------------------------------------------------------------------------------
    // Solution
    //--------------------------------------------------------------------------------
    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;    // median
        TreeNode node = new TreeNode(array[mid]);

        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);

        return node;
    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = createMinimalBST(array);

        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }
}
