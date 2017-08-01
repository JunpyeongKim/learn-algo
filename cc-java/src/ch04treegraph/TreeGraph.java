package ch04treegraph;

// DONE 1
/**
 * 4.1 주어진 이진 트리가 균형 이진 트리인지 판별하는 함수를 구현하라.
 *     이 문제에서 이진 트리는 어떤 노드의 두 자식 트리의 깊이가 하나 이상 차이나지 않는 트리다.
 *
 * (4E)
 * 4.1 Implement a function to check if a tree is balanced.
 *     For the purposes of this question, a balanced tree is defined to be a tree
 *     such that no two leaf nodes differ in distance from the root by more than one.
 *
 * (6E)
 * 4.4 Check Balanced: Implement a function to check if a binary tree is balanced.
 *                     For the purposes of this question, a balanced tree is defined to be a tree
 *                     such that the heights of the two subtrees of any node never differ by more than one.
 *
 *                     Hints: #21, #33, #49, #105, #124
 */

// DONE 2 (2017.07.31)
/**
 * 4.2 주어진 유향 그래프(directed graph)에서 특정한 두 노드 간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라.
 *
 * (4E)
 * 4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 * (6E)
 * 4.1 Route Between Nodes: Given a directed graph,
 *                          design an algorithm to find out whether there is a route between two nodes.
 *
 *                          Hints #127. Two well-known algorithms can do this. What are the tradeoffs between them?
 */

// Done 3
/**
 * 4.3 오름차순으로 정렬된 배열로부터 그 높이가 가장 낮은 이진 탐색 트리를 생성하는 알고리즘을 작성하라.
 *     배열 내 모든 원소는 배열 내에서 유일한 값을 갖는다.
 *
 * (5E)
 * 4.3 Given a sorted(increasing order) array, write an algorithm to create a binary tree with minimal height.
 *
 * (6E)
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
 *                   write an algorithm to create a binary search tree with minimal height.
 *
 *     Hints #19. A minimal binary tree has about the same number of nodes on the left of each nodes as on the right.
 *                let's forcus on just the root for now.
 *                How would you ensure that about the same number of nodes are on the left of the root as on the right?
 *     Hints #73. You could implement this by finding the "ideal" next element to add and repeatedly calling insertValue.
 *                This will be a bit inefficient, as you would have to repeatedly traverse the tree.
 *                Can you divide this problem into subproblem?
 *     Hints #116. Imagine we had a createMinimalTree method that returns a minimal tree for a given array
 *                 (but for some strange reason doesn't operate on the root of the tree).
 *                 Could you use this to operate on the root of the tree?
 *                 Could you write the base case for the function? Great! Then that's basically the entire function.
 */

// Done 4
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
 *                     Hints: #107, #123, #135
 */

// WIP 7
/**
 * 4.7 이진 트리 내의 두 노드의 공통 선조(ancestor) 노드를 찾는 알고리즘을 설계하고 구현하라.
 *     자료구조 내에 부가적인 노드를 저장해 두는 일은 금한다.
 *
 *     주의: 이진 탐색 트리가 아닐 수도 있다.
 *
 * (4E)
 * 4.6 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 *     Avoid storing additional nodes in a data structure.
 *
 *     NOTE: This is not necessarily a binary search tree.
 *
 * (6E)
 * 4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 *                            Avoid storing additional nodes in a data structure.
 *
 *                            NOTE: This is not necessarily a binary search tree.
 *
 *                            Hints: # 10, #16, #28, #36, #46, #70, #80, #96
 */

// Done 8
/**
 * 4.8 두 개의 큰 이진 트리 T1, T2가 있다고 하자.
 *     T1에는 수백만 개의 노드가 있고, T2에는 수백 개 정도의 노드가 있다.
 *     T2가 T1의 하위 트리인지 판별하는 알고리즘을 만들라.
 *
 *     T1 안에 노드 n이 있어 그 노드의 하위 트리가 T2와 동일하면, T2는 T1의 하위 트리다.
 *     다시 말해, T1에서 n부터 시작하여 그 아래쪽을 끊어내면, 그 결과가 T2와 동일해야 한다.
 *
 * (4E)
 * 4.7 You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 *     Create an algorithm to decide if T2 is a subtree of T1.
 *
 * (6E)
 * 4.10 Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2.
 *                     Create an algorithm to determine if T2 is a subtree of T1.
 *
 *                     A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2 .
 *                     That is, if you cut off the tree at node n, the two trees would be identical.
 *
 *                     Hints: #4, #11, #18, #31, #37
 */


//--------------------------------------------------------------------------------
// Korean Edition: Unsolved --> 5, 6, 9
//--------------------------------------------------------------------------------
// TBD 5
/**
 * 4.5 어떤 이진 트리가 이진 탐색 트리인지 판별하는 함수를 구현하라.
 */

// TBD 6
/**
 * 4.6 정순회 기준으로, 이진 탐색 트리 내의 한 노드가 주어지면 그 노드의 '다음' 노드를 찾아내는 알고리즘을 작성하라.
 *     각 노드에는 부모 노드를 가리키는 링크가 존재한다고 가정한다.
 */

// TDB 9
/**
 * 4.9 각 노드에 어떤 값이 저장되어 있는 이진 트리 하나와 값 n이 주어졌을 때, n과 같은 값을 갖는 모든 경로를 찾아라.
 *     어떤 경로의 값은 그 경로에 포함된 모든 노드의 값의 합이며, 경로는 트리 내의 아무 위치에서나 시작하고 끝날수 있다.
 */


//--------------------------------------------------------------------------------
// English Edition: Unsolved --> 4E(3,4,5, 6,7, 8), 6E(2,3,5, 6, 7, 8, 9, 11, 12)
//--------------------------------------------------------------------------------
public class TreeGraph {
}
