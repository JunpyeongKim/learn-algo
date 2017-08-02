package ch04treegraph;

import lib.AssortedMethods;
import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 4.4 주어진 이진 트리에서 깊이별로 연결 리스트를 만들어 내는 알고리즘을 작성하라.
 *     (트리의 깊이가 D라면, 알고리즘 수행 결과로 D개의 연결 리스트가 만들어져야 한다.)
 *
 * (4E)
 * 4.4 Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 *     (i.e., if you have a tree with depth D, you’ll have D linked lists).
 *
 * (6E)
 * 4.3 List of Depths: Given a binary tree,
 *                     design an algorithm which creates a linked list of all the nodes at each depth
 *                     (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 *                     Hints:
 *                     #107. Try modifying a graph search algorithm to track the depth from the root.
 *                     #123. A hash table or array that maps from level number to nodes at that level might also be useful.
 *                     #135. You should be able to come up with an algorithm involving both depth-first search and breadth-first search.
 */

/**
 * BFS, DFS 2가지 방법으로 풀 수 있다.
 * DFS 방법으로는 BFS 의 Traversal 방법과 비슷한 pre-order Traversal 로 풀어본다. --> 단, 반복되는 패턴을 함수로 만든 recursion 에서는 각 노드가 어느 레벨인지 표시 필요
 *  --> TreeNode 레퍼런스가 변하는 변수이면 null 체크는 반드시 필요하다. --> 가장 간단한 노드 3개의 트리 고려후 --> leaf node 처리 순서로 고민하면 된다.
 */
public class TreeGraph04 {
    /*
    // BSF
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (current != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);

            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.getLeft() != null)
                    current.add(parent.getLeft());

                if (parent.getRight() != null)
                    current.add(parent.getRight());
            }
        }

        return result;
    }

    // DFS


    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {

    }

    public static void main(Strins[] args) {
        int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);

        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }
    */

    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> list : result) {
            System.out.print("Linked list at depth " + depth + ":");

            // Iterator<TreeNode> iterator = list.listIterator();
            // iterator.hasNext() --> (TreeNode)iterator.next()
            for(TreeNode t : list) {
                System.out.println(" " + t.data);
            }
            System.out.println();

            depth++;
        }
    }

    // BFS: Level-order traversal
    // LinkedList가 레벨별로 존재하므로, 즉 부모 버퍼가 존재하므로 Queue 를 사용할 필요가 없다.
    // 즉, 부모 버퍼로서 Queue 대신 이미 존재하는 레벨별 LinkdedList 를 사용하면 된다
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList01(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        if (root != null) {
            // visit
            LinkedList<TreeNode> current = new LinkedList<TreeNode>();
            current.add(root);

            while (current.size() > 0) {
                result.add(current);

                LinkedList<TreeNode> parents = current;
                current = new LinkedList<TreeNode>();

                for (TreeNode parent : parents) {
                    if (parent.left != null) {
                        current.add(parent.left);
                    }

                    if (parent.right != null) {
                        current.add(parent.right);
                    }
                }
            }
        }

        return result;
    }

    // DFS: pre-order traversal --> DLR
    private static void createLevelLinkedList02(TreeNode node, int level, ArrayList<LinkedList<TreeNode>> result) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> current;

        if (result.size() == level) {   // or null == result.get(level)
            current = new LinkedList<TreeNode>();
            result.add(current);
        } else {
            current = result.get(level);
        }

        current.add(node);
        createLevelLinkedList02(node.left, level + 1, result);
        createLevelLinkedList02(node.right, level + 1, result);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList02(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        if (root != null) {
            createLevelLinkedList02(root, 0, result);
        }

        return result;
    }


    // Main
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);

        // BFS
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList01(root);

        // DFS
        // ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList02(root);

        printResult(list);
    }
}
