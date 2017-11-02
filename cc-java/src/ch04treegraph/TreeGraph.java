package ch04treegraph;

// DONE 1
/**
 * 4.1 주어진 이진 트리가 균형 이진 트리인지 판별하는 함수를 구현하라.
 *     이 문제에서 이진 트리는 어떤 노드의 두 자식 트리의 깊이가 하나 이상 차이나지 않는 트리다.
 *
 * (4E)
 * 4.1 Implement a function to check if a tree is balanced.
 *     For the purposes of this question, a balanced tree is defined to be a tree such that
 *     no two leaf nodes differ in distance from the root by more than one.
 *
 * (6E)
 * 4.4 Check Balanced: Implement a function to check if a binary tree is balanced.
 *                     For the purposes of this question, a balanced tree is defined to be a tree such that
 *                     the heights of the two subtrees of any node never differ by more than one.
 *
 *                     Hints
 *                     #21. Think about the definition of a balanced tree.
 *                          Can you check that condition for a single node?
 *                          Can you check it for every node?
 *                     #33. If you've developed a brute force solution, be careful about its runtime.
 *                          If you are computing the height of the subtrees for each node,
 *                          you could have a pretty inefficient algorithm.
 *                     #49. What if you could modify the binary tree node class
 *                          to allow a node to store the height of its subtree?
 *                     #105. You don't need to modify the binary tree class to store the height of the subtree.
 *                           Can your recursive function compute the height of each subtree
 *                           while also checking if a node is balanced?
 *                     #124. Actually, you can just have a single checkHeight function that does
 *                           both the height computation and the balance check.
 *                           An integer return value can be used to indicate both.
 */

// DONE 2 (2017.07.31)
/**
 * 4.2 주어진 유향 그래프(directed graph)에서 특정한 두 노드 간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라.
 *
 * (4E)
 * 4.2 Given a directed graph,
 *     design an algorithm to find out whether there is a route between two nodes.
 *
 * (6E)
 * 4.1 Route Between Nodes: Given a directed graph,
 *                          design an algorithm to find out whether there is a route between two nodes.
 *
 *                          Hints
 *                          #127. Two well-known algorithms can do this. What are the tradeoffs between them?
 */

// DONE 3 (2017.08.02)
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

// DONE 4 (2017.08.02)
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

// WIP 5
/**
 * 4.5 어떤 이진 트리가 이진 탐색 트리인지 판별하는 함수를 구현하라.
 *
 * (6E)
 * 4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
 *
 *                   Hints:
 *                   #35. If you traversed the tree using an in-order traversal and the elements were truly in the right order,
 *                        does this indicate that the tree is actually in order?
 *                        What happens for duplicate elements?
 *                        If duplicate elements are allowed, they must be on a specific side (usually the left).
 *                   #57. To be a binary search tree, it's not sufficient that the left.value <= current.value < right.value for each node.
 *                        Every node on the left must be less than the current node, which must be less than all the nodes on the right.
 *                   #86. If every node on the left must be less than or equal to the current node,
 *                        then this is really the same thing as saying that the biggest node on the left must be less than or equal to the current node.
 *                   #113. Rather than validating the current node's value against leftTree.max and rightTree.min, can we flip around the logic?
 *                         Validate the left tree's nodes to ensure that they are smaller than current.value.
 *                   #128. Think about the checkBST function as a recursive function that ensures each node is within an allowable (min, max) range.
 *                         At first, this range is infinite.
 *                         When we traverse to the left, the min is negative infinity and the max is root.value.
 *                         Can you implement this recursive function and properly adjust these ranges as you traverse the tree?
 */

// TBD 6
/**
 * 4.6 정순회 기준으로, 이진 탐색 트리 내의 한 노드가 주어지면 그 노드의 '다음' 노드를 찾아내는 알고리즘을 작성하라.
 *     각 노드에는 부모 노드를 가리키는 링크가 존재한다고 가정한다.
 */

// TBD 7
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

// WIP 8
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
 *                     Hints:
 *                     #4. If T2 is a subtree of T1, how will its in-order traversal compare to T1's?
 *                         What about its pre-order and post-order traversal?
 *                     #11. The in-order traversals won't tell us much.
 *                          After all, every binary search tree with the same values (regardless of structure) will have the same in-order traversal.
 *                          This is what in-order traversal means: contents are in-order.
 *                          (And if it won't work in the specific case of a binary search tree, then it certainly won't work for a general binary tree.)
 *                          The preorder traversal, however, is much more indicative.
 *                     #18. You may have concluded that if T2.preorderTraversal() is a substring of T1.preorderTraversal (), then T2 is a subtree of T1.
 *                          This is almost true, except that the trees could have duplicate values.
 *                          Suppose T1 and T2 have all duplicate values but different structures. The pre-order traversals will look the same
 *                          even though T2 is not a subtree of T1.
 *                          How can you handle situations like this?
 *                     #31. Although the problem seems like it stems from duplicate values, it's really deeper than that.
 *                          The issue is that the pre-order traversal is the same only because there are null nodes that we skipped over (because they're null ).
 *                          Consider inserting a placeholder value into the pre-order traversal string whenever you reach a null node.
 *                          Register the null node as a "real " node so that you can distinguish between the different structures.
 *                     #37. Alternatively, we can handle this problem recursively.
 *                          Given a specific node within T1, can we check to see if its subtree matches T2?
 */





// TDB 9
/**
 * 4.9 각 노드에 어떤 값이 저장되어 있는 이진 트리 하나와 값 n이 주어졌을 때, n과 같은 값을 갖는 모든 경로를 찾아라.
 *     어떤 경로의 값은 그 경로에 포함된 모든 노드의 값의 합이며, 경로는 트리 내의 아무 위치에서나 시작하고 끝날수 있다.
 */

//--------------------------------------------------------------------------------
// Completed 
// --> KE(9개: 1, - 2, 3, 4, 5, 6, 7, 8, 9)
// --> 4E(8개: 1, - 2, 3, 4, 5, 6, 7, 8)
// --> 6E(12개: 4, - 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12)
//--------------------------------------------------------------------------------
public class TreeGraph {}