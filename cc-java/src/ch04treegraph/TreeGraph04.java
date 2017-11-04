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
 * 4.4 Given a binary search tree, 
 *     design an algorithm which creates a linked list of all the nodes at each depth
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
    /**
     * at first glance, requires a level-by-level traversal. --> actually not necessary.
     * ==> We can traverse the graph any way that we'd like.
     *
     * O(N) space: both solutions require returning O(N) data.
     */


    //--------------------------------------------------------------------------------
    // Solution #1. Breadth First Search (a.k.a Level-order traversal)
    //              - O(N) time
    //              - O(N) space
    //--------------------------------------------------------------------------------
    public static ArrayList<LinkedList<TreeNode>> createLinkedListAtDepthByBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        // We want to iterate through the root first, then level 2, then level3, and so on.
        // - With each level i, we will have already fully visited all nodes on level i - 1.
        // - to get which nodes are on level i, we can simply look at all children of the nodes of level i - 1.
        if (root != null) {
            // Visit the root
            LinkedList<TreeNode> current = new LinkedList<TreeNode>();
            current.add(root);

            // Queue 대신 이미 존재하는 Depth별 LinkedList 를 사용하면 된다.
            while (current.size() > 0) {
                result.add(current);    // Add previous depth

                LinkedList<TreeNode> parents = current; // Go to next depth
                current = new LinkedList<TreeNode>();

                // Visit the children: left to right
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
    //              - O(N) time
    //              - O(N) space: recursive calls (in a balanced tree) --> O(logN)
    //                            ==>> dwarfed by the O(N) data that must be returned.
    //--------------------------------------------------------------------------------
    private static void createLinkedListAtDepthByDFS(TreeNode node,
                                                 int level,
                                                 ArrayList<LinkedList<TreeNode>> result) {
        if (node == null) {
            return;
        }

        // Get or create the current linked list
        LinkedList<TreeNode> current;

        //TODO: root --> depth 0 ? level 0 ? height 0?
        if (result.size() == level) {   // or null == result.get(level)
            current = new LinkedList<TreeNode>();
            result.add(current);
        } else {
            current = result.get(level);
        }

        // Pre-order traversal
        current.add(node);
        createLinkedListAtDepthByDFS(node.left, level + 1, result);
        createLinkedListAtDepthByDFS(node.right, level + 1, result);
    }

    public static ArrayList<LinkedList<TreeNode>> createLinkedListAtDepthByDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        if (root != null) {
            createLinkedListAtDepthByDFS(root, 0, result);
        }

        return result;
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static void printResult(ArrayList<LinkedList<TreeNode>> result, String search) {
        int level = 0;

        System.out.println(search + " Approach:");
        for (LinkedList<TreeNode> list : result) {
            System.out.print("---> Linked list at depth " + (level + 1) + ":");

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
            level++;
        }
    }

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<LinkedList<TreeNode>> list;
        TreeNode root;

        // BFS
        root = AssortedMethods.createTreeFromArray(nodes_flattened);
        list = createLinkedListAtDepthByBFS(root);
        printResult(list, "BFS");

        // DFS
        root = AssortedMethods.createTreeFromArray(nodes_flattened);
        list = createLinkedListAtDepthByDFS(root);
        printResult(list, "DFS");
    }
}