/*
Level Order Traversal is defined as follows,
    1. Visit the root.
    2. While traversing level 'l', keep all the elements at level 'l+1' in queue.
    3. Go to the next level and visit all the nodes at that level.
    4. Repeat this until all levels are completed.

Time Complexity: O(n)
Space Complexity: O(n)
                - Since, in the worst case,
                  all the nodes on the entire last level could be in the queue simultaneously.
*/

public class LevelOrderTraversal {
    void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();

        if (root == null)
            return;

        Q.enqueue(root);
        while(!Q.isEmpty()) {
            temp = Q.dequeue();
            // Process current node
            System.out.println(temp.getData());

            if (null != temp.getLeft())
                Q.enqueue(temp.getLeft());

            if (null != temp.getRight())
                Q.enqueue(temp.getRight());
        }

        Q.deleteQueue();
    }
}
