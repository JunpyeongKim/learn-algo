package ch04treegraph;

import lib.TreeNode;

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

/**
 * 방법 2가지
 *     1) 각 트리를 in-order traversal(DLR 처리때문에) 하면서 Stringify 한 후 --> t1.indexOf(t2) >= 0 인지 체크 --> 트리가 너무 크면 overflow 가능성
 *     2) 노드의 값이 같은 노드를 찾은 후 왼쪽, 오른쪽의 서브 트리 노드들도 모두 동일한지 Recursive 를 이용해서 확인한다. --> null 도 subtree 의 멤버이다.
 */
public class TreeGraph08 {
    /*
    이런 문제를 풀때는 우선 자료의 양이 얼마 안된다고 가정하고 풀기 시작하는 것이 좋다.
    --> 작고 단순화된 문제

    1) in-order traversal / pre-order traversal 를 나타내는 문자열
        --> 실제 문제는 더 많은 양의 데이터를 다루므로, 너무 많은 메모리가 소모

    2) 더 큰 트리 T1을 탐색 ==> T2의 루트와 같은 값의 노드가 발견될 때 마다 treeMatch() 호출
        실행 시간 분석
        - n : T1의 노드수
        - m : T2의 노드수
        - k : T2의 루트 노드값이 T1에 등장하는 빈도
        --> Run time : O(n + km)
        --> 이것도 과대 평가이다. T1 과 T2의 차이가 발결되면 treeMatch() 가 종료하므로//
        ==> << O(n + km)

    3) 메모리 필요: O(n + m) vs. O(log n + log m)
    4) 수행 시간: O(n + m) vs. O(nm) <-- worst ???
    5) 좀 더 가까운 시간 상한은 O(n + km) 이다
         O~p 사이의 random number 로 구성된다면 k의 값은 n/p 와 가까울 것이다.
         - p = 1000
         - n = 1000000
         - m = 100
         --> 1000000 + (1000000 / 1000) * 100 = 1100000
    ==> 두 번째 방법이 공간 효율 측면, 시간측면에서 모두 효율적이다.
    */

    // pre-order traversal --> stringify --> indexOf >= 0
    private static void getOrderString(TreeNode t, StringBuilder sb)  {
        if (t == null) {
            sb.append("X");
            return;
        }

        sb.append(t.data);
        getOrderString(t.left, sb);
        getOrderString(t.right, sb);
    }

    public static boolean containsTree01(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return true;
        }

        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        // stringify left
        getOrderString(t1, string1);

        // stringify right
        getOrderString(t2, string2);

        // indexOf >= 0
        return string1.indexOf(string2.toString()) >= 0;
    }


    // traverse all: t1.data == t2.data --> t1.subtree(L/R) == t2.subtree)(L/R)
    private static boolean matchTree(TreeNode t1, TreeNode t2) {
        // any traversal method is OK
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.data != t2.data) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }

    private static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public static boolean containsTree02(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return true;
        }

        return subTree(t1, t2);
    }

    // Main
}
