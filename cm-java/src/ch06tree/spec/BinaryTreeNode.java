package ch06tree.spec;

/*
 Binary Trees

    Types
    - Strict binary tree: 2 children or not
    - Full binary tree: 2 children and all leaves in the same level
    - Complete binary tree: all leaves in height h or h-1
 */

/**
 * Binary Trees
 *  Types
 *      1) Strict binary tree: 2 children or not
 *      2) Full binary tree: 2 children and all leaves in the same level
 *      3) Complete binary tree: all leaves in height h or h-1
 */
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


    //--------------------------------------------------------------------------------
    // Helper
    //--------------------------------------------------------------------------------
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            return Integer.toString(data);
        } else {
            String root, left = "null", right = "null";

            root = this.toString();
            if (getLeft() != null)
                left = getLeft().toString();

            if (getRight() != null)
                right = getRight().toString();

            return root + " (" + left + ", "  + right + ")";
        }
    }

    //TODO:
    public int hashCode() {
        return Integer.MIN_VALUE;
    }

    //TODO:
    public static boolean findInBT(BinaryTreeNode root, int data) {
        return false;
    }

    // include the root in the count
    public int numberOfNodes() {
        int leftCount = left == null ? 0 : left.numberOfNodes();
        int rightCount = right == null ? 0 : right.numberOfNodes();

        return 1 + leftCount + rightCount;
    }
}
