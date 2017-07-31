package ch06tree;

import ch06tree.spec.BinaryTreeNode;

/**
 * Problem-20 Given a binary tree, print out all its root-to-leaf paths
 */
public class Tree20 {
    BinaryTreeNode node;    //TODO:

    public void printPaths() {
        int[] path = new int[256];
        printPaths(node, path, 0);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private void printPaths(BinaryTreeNode node, int[] path, int pathLen) {
        if (node == null)
            return;

        path[pathLen] = node.getData();
        pathLen++;

        if (node.getLeft() == null && node.getRight() == null) {
            printArray(path, pathLen);
        } else {
            printPaths(node.getLeft(), path, pathLen);
            printPaths(node.getRight(), path, pathLen);
        }
    }

    private void printArray(int[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Tree20 tree = new Tree20();
        tree.printPaths();
    }
}
