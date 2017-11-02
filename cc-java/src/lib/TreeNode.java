package lib;


public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int size;

    public TreeNode(int data) {
        this.data = data;
    }

    public void setLeftNode(TreeNode left) {
        this.left = left;

        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightNode(TreeNode right) {
        this.right = right;

        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left != null) {
                left.insertInOrder(d);
            } else {
                setLeftNode(new TreeNode(d));
            }
        } else {
            if (right != null) {
                right.insertInOrder(d);
            } else {
                setRightNode(new TreeNode(d));
            }
        }

        size++;
    }

    public int size() {
        return size;
    }

    public boolean isBST() {
        if (left != null) {
            if (left.data > data || !left.isBST())
                return false;
        }

        if (right != null) {
            if (right.data < data || !right.isBST())
                return false;
        }

        return true;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    
    //--------------------------------------------------------------------------------
    // Utility
    //--------------------------------------------------------------------------------
    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start)
            return null;

        int mid = (start + end) / 2;

        TreeNode n = new TreeNode(array[mid]);
        n.setLeftNode(createMinimalBST(array, start, mid - 1));
        n.setRightNode(createMinimalBST(array, mid + 1, end));

        return n;
    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }
}
