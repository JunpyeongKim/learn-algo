package ch02linkedlist;

// Done 1
/**
 * 2.1 다음의 비정렬(unsorted) 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 *
 *     연관 문제
 *      임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?
 *
 * (4E)
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 *
 *     FOLLOW UP
 *      How would you solve this problem if a temporary buffer is not allowed?
 *
 * (6E)
 * 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
 *
 *                  FOLLOW UP
 *                      How would you solve this problem if a temporary buffer is not allowed?
 *
 *                  Hints: #9, #40
 */

// Done 3
/**
 * 2.3 단방향 연결 리스트의 중간에 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
 *     삭제할 노드에 대한 접근만 가능하다는 것에 유의하라가
 *
 *     - 예
 *          입력: 연결리스트 a->b->c->d->e 의 노드 c
 *          출력: 아무것도 반환할 필요 없고, 결과로 연결리스트가 a->b->d->e 가 되어 있으면 OK
 *
 * (4E)
 * 2.3 Implement an algorithm to delete a node in the middle of a single linked list,
 *     given only access to that node.
 *
 *     EXAMPLE
 *      Input: the node ‘c’ from the linked list a->b->c->d->e
 *      Result: nothing is returned, but the new linked list looks like a->b->d->e
 *
 * (6E)
 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 *                         not necessarily the exact middle) of a singly linked list, given only access to that node.
 *
 *                         EXAMPLE
 *                          Input: the node c from the linked list a->b->c->d->e->f
 *                          Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 *
 *                         Hints: #72
 */

// Done 4
/**
 * 2.4 x 값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라.
 *     x 보다 작은 값을 갖는 노드가 x와 같거나 더 큰 값을 가는 노드들보다 앞 쪽에 오도록 하면 된다.
 *
 * (6E)
 * 2.4 Partition: Write code to partition a linked list around a value x,
 *                such that all nodes less than x come before all nodes greater than or equal to x.
 *                If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 *                The partition element x can appear anywhere in the "right partition";
 *                it does not need to appear between the left and right partitions.
 *
 *                EXAMPLE
 *                  Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 *                  Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 *                Hints: #3, #24
 */


//--------------------------------------------------------------------------------
// Korean Edition: Unsolved --> 2, 5, 6, 7
//--------------------------------------------------------------------------------

// TBD 2
/**
 * 2.2 단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 *
 * (6E)
 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 *
 *                         Hints: #8, #25, #47, #67, # 726
 */


// TBD 5
/**
 * 2.5 연결 리스트로 표현된 두 개의 수가 있다고 하자.
 *     리스트의 각 노드는 해당 수 의 자릿수를 표현한다.
 *     이때 자릿수들은 역순으로 배열되는데, 1의 자릿수가 리스트의 맨 앞에 오도록 배열된다는 뜻이다.
 *     이 두 수를 더하여 그 합을 연결 리스트로 반환하는 함수를 작성하라.
 *
 *     - 예
 *          입력: (7->1->6) + (5->9->2), 즉 617 + 295
 *          출력: 2->1->9, 즉 912
 *
 *     - 연관 문제
 *          각 자릿수가 정상적으로 배열된다고 가정하고 구현해 보자.
 *       - 예
 *          입력: (6->1->7) + (2->9->5), 즉 617 + 295
 *          출력: 9->1->2, 즉 912
 */

// TBD 6
/**
 * 2.6 순환 연결 리스트(circular linked list)가 주어졌을 때, 순환되는 부분의 첫 노드를 반환하는 알고리즘을 작성하라.
 */

// TBD 7
/**
 * 2.7 주어진 연결 리스트가 회문(palindrome)인지 검사하는 함수를 작성하라.
 */


//--------------------------------------------------------------------------------
// English Edition: Unsolved --> 4E(2, 4, 5), 6E(2, 5, 6, 7, 8)
//--------------------------------------------------------------------------------
public class LinkedList {
}
