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

public class TreeGraph04 {
    //--------------------------------------------------------------------------------
    // Solution #1. Breadth First Search (a.k.a Level-order traversal)
    //--------------------------------------------------------------------------------
    public static ArrayList<LinkedList<TreeNode>> createDepthLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        if (root != null) {
            // Visit a root
            LinkedList<TreeNode> current = new LinkedList<TreeNode>();
            current.add(root);

            // Queue 대신 이미 존재하는 Depth별 LinkedList 를 사용하면 된다.
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


    //--------------------------------------------------------------------------------
    // Solution #2. Depth First Search (a.k.a pre-order traversal; DLR) --> "Recurse"
    //--------------------------------------------------------------------------------
    private static void createDepthLinkedListDFS(TreeNode node,
                                                 int depth,
                                                 ArrayList<LinkedList<TreeNode>> result) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> current;

        if (result.size() == depth) {   // or null == result.get(depth)
            current = new LinkedList<TreeNode>();
            result.add(current);
        } else {
            current = result.get(depth);
        }

        current.add(node);
        createDepthLinkedListDFS(node.left, depth + 1, result);
        createDepthLinkedListDFS(node.right, depth + 1, result);
    }

    public static ArrayList<LinkedList<TreeNode>> createDepthLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        if (root != null) {
            createDepthLinkedListDFS(root, 0, result);
        }

        return result;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;

        for (LinkedList<TreeNode> list : result) {
            System.out.print("Linked list at depth " + depth + ":");

            /* Alternative 01
            Iterator<TreeNode> iterator = list.listIterator();
            while (iterator.hasNext()) {
                System.out.print(" " + iterator.next().data);
            }
            */

            // Alternative 02
            for(TreeNode t : list) {
                System.out.print(" " + t.data);
            }

            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<LinkedList<TreeNode>> list;

        // BFS
        TreeNode node1 = AssortedMethods.createTreeFromArray(nodes_flattened);
        list = createDepthLinkedListBFS(node1);
        printResult(list);

        // DFS
        TreeNode node2 = AssortedMethods.createTreeFromArray(nodes_flattened);
        list = createDepthLinkedListDFS(node2);
        printResult(list);
    }
}
