package ch06tree.spec;

import java.util.*;

public class BinaryTreeTraversal {
    //--------------------------------------------------------------------------------
    // Preorder(DLR) Traversal
    //--------------------------------------------------------------------------------

    // Recursive
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/PreOrderRecursive.java
    // Time Complexity: O(n)
    // Space Complexity: O(n) because of call stack
    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    // Iterative 01; Non-Recursive
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void preOrderNonRecursive(BinaryTreeNode root) {
        if (root == null)
            return;

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        while (true) {
            while (current != null) {
                System.out.println(current.getData());
                stack.push(current);
                current = current.getLeft();
            }

            if (stack.isEmpty()) {
                break;
            }

            current = stack.pop();
            current = current.getRight();
        }
    }

    // Iterative 02
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/PreOrderIterative.java
    public List<Integer> preOrderIterative(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.pop();
            result.add(current.getData());

            if (current.getRight() != null)
                stack.push(current.getRight());

            if (current.getLeft() != null)
                stack.push(current.getLeft());
        }

        return result;
    }


    //--------------------------------------------------------------------------------
    // Inorder(LDR) Traversal
    //  InOrderIterative.java
    //  InOrderRecursive.java
    //--------------------------------------------------------------------------------

    // Recursive
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/InOrderRecursive.java
    // Time Complexity: O(n)
    // Space Complexity: O(n) because of call stack
    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    // Iterative 01; Non-Recursive
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void inOrderNonRecursive(BinaryTreeNode root) {
        if (root == null)
            return;

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            if (stack.isEmpty())
                break;

            current = stack.pop();
            System.out.println(current.getData());

            current = current.getRight();
        }
    }

    // Iterative 02
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/InOrderIterative.java
    public List<Integer> inOrderIterative(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        boolean done = false;

        while(!done) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if (stack.isEmpty()) {
                    done =  true;
                } else {
                    current = stack.pop();
                    result.add(current.getData());
                    current = current.getRight();
                }
            }
        }

        return result;
    }


    //--------------------------------------------------------------------------------
    // Postorder(LRD) Traversal
    //--------------------------------------------------------------------------------

    // Recursive
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/PostOrderRecursive.java
    // Time Complexity: O(n)
    // Space Complexity: O(n) because of call stack
    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    //TODO:
    // Iterative 01; Non-Recursive
    public void postOrderNonRecursive(BinaryTreeNode root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current = root;

        while (true) {
            if (current != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Stack is Empty");
                    break;
                } else if (stack.peek().getRight() == null) {
                    root = stack.pop();
                    System.out.println(root.getData());

                    if (root == stack.peek().getRight()) {
                        System.out.println(stack.peek().getData());
                        stack.pop();
                    }
                }

                if (!stack.isEmpty()) {
                    root = stack.peek().getRight();
                } else {
                    root = null;
                }
            }
        }
    }

    //TODO:
    // Iterative 02
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/PostOrderIterative.java
    public List<Integer> postOrderIterative(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode prev = null;

        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.peek();

            if (prev == null || prev.getLeft() == current || prev.getRight() == current) {
                if (current.getLeft() != null)
                    stack.push(current.getLeft());
                else if (current.getRight() != null)
                    stack.push(current.getRight());
            } else if (current.getLeft() == prev) {

            } else {
                result.add(current.getData());
                stack.pop();
            }

            prev = current;
        }

        return result;
    }


    //--------------------------------------------------------------------------------
    // Level Order Traversal
    //  LevelOrder.java
    //  LevelOrderTraversalInReverse.java
    //--------------------------------------------------------------------------------

    // Forward 01
    //  - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/LevelOrder.java
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void levelOrder(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            System.out.println(temp.getData());

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }
    }

    // Forward 02
    // Time Complexity: O(n)
    // Space Complexity: O(n)   //TODO:
    public List<ArrayList<Integer>> levelOrder02(BinaryTreeNode root) {
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode temp;

        // enqueue
        queue.offer(root);
        queue.offer(null);

        List<Integer> currentLevel = new ArrayList<Integer>();

        while (!queue.isEmpty()) {  // not queue.peek() != null
            // dequeue
            temp = queue.poll();

            if (temp != null) {
                // process current node
                currentLevel.add(temp.getData());

                if (temp.getLeft() != null)
                    queue.offer(temp.getLeft());

                if (temp.getRight() != null)
                    queue.offer(temp.getRight());
            } else {
                ArrayList<Integer> level = new ArrayList<Integer>(currentLevel);
                result.add(level);

                currentLevel.clear();

                // in case that current level is finished
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }

        return result;
    }

    // Reverse
    // - https://github.com/careermonk/DataStructureAndAlgorithmsMadeEasyInJava/blob/master/src/chapter06trees/LevelOrderTraversalInReverse.java
    public void levelOrderInReverse(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp;

        // enqueue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // dequeue
            temp = queue.poll();

            // process current node
            stack.push(temp);

            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());

            if (temp.getRight() != null)
                queue.offer(temp.getRight());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData() + " ");
        }
    }
}
