package ch03stackqueue;

// WIP 1 ---> //TODO:DynamicMultiStack
/**
 * 3.1 하나의 배열을 사용하여 세 개의 스택을 구현하는 방법을 설명하라.
 *
 * (4E)
 * 3.1 Describe how you could use a single array to implement three stacks.
 * 
 * (6E)
 * 3.1 Three in One: Describe how you could use a single array to implement three stacks.
 *
 *                  Hint #2.
 *                  Hint #12.
 *                  Hint #38.
 *                  Hint #58.
 */

// Done 2
/**
 * 3.2 push와 pop의 두 가지 연산뿐 아니라, 최소값을 갖는 원소를 반환하는 min 연산을 갖춘 스택은 어떻게 구현할 수 있겠는가?
 *     Push, pop 그리고 min 은 공히 O(1) 시간에 처리되어야 한다.
 *
 * (4E)
 * 3.2 How would you design a stack which, in addition to push and pop, also has a function min which
 *     returns the minimum element?
 *     Push, pop and min should all operate in O(1) time.
 *
 * (6E)
 * 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min which
 *                returns the minimum element?
 *                Push, pop and min should all operate in O(1) time.
 *
 *                Hints: #27, #59, #78
 */

// Done 3
/**
 * 3.3 접시 무더기를 떠올려 보자. 접시를 너무 높이 쌓으면, 넘어질 것이다. 
 *     그러므로 현실에서는 무더기 높이가 특정한 수준 이상으로 높아지면 새로운 무더기를 만든다.
 *     이것을 흉내내는 자료구조 SetOfStacks 를 구현해 보라.
 * 
 *     SetOfStacks 는 여러 스택으로 구성되어야 하며, 이전 스택이 지정된 용량을 초과하는 경우 새로운 스택을 생성해야 한다.
 *     SetOfStacks.push() 와 SetOfStacks.pop() 은 스택이 하나인 경우와 동일하게 동작해야 한다.
 *     (다시 말해, pop() 은 정확히 하나의 스택이 있을 때와 동일한 값을 반환해야 한다).
 *
 *     연관 문제
 *      특정한 하위 스택에 대해서 pop 을 수행하는 popAt(int index) 함수를 구현하라.
 *
 * (4E)
 * 3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *     Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 *     Implement a data structure SetOfStacks that mimics this.
 *     SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 *     SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 *     (that is, pop() should return the same values as it would if there were just a single stack).
 *
 *     FOLLOW UP
 *      Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *
 * (6E)
 * 3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *                      Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 *                      Implement a data structure SetOfStacks that mimics this.
 *                      SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 *                      SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 *                      (that is, pop() should return the same values as it would if there were just a single stack).
 *
 *                      FOLLOW UP
 *                          Implement a function popAt(int index) which performs a pop operation on a specific substack.
 *
 *                      Hints: #64, #81
 */

// TBD 4
/**
 * 3.4 유명한 하노이 탑
 */

// Done 5
/**
 * 3.5 두 개의 스택을 사용하여 큐를 구현하는 MyQueue 클래스를 작성하라.
 *
 * (4E)
 * 3.5 Implement a MyQueue class which implements a queue using two stacks
 *
 * (6E)
 * 3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 *
 *                       Hints: #98, #114
 */

// Done 6   ---> //TODO: mergesort --> not reverse ???
/**
 * 3.6 큰 값이 위에 오도록 스택을 오름차순 정렬하는 프로그램을 작성하라.
 *     여벌 스택은 하나까지만 사용할 수 있고, 스택에 보관된 요소를 배열 등의 다른 자료구조로는 복사할 수 없다.
 *     스택은 push, pop, peek, isEmpty 의 네 가지 연산을 제공한다.
 *
 * (4E)
 * 3.6 Write a program to sort a stack in ascending order.
 *     You should not make any assumptions about how the stack is implemented.
 *     The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 *
 * (6E)
 * 3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top.
 *                 You can use an additional temporary stack,
 *                 but you may not copy the elements into any other data structure (such as an array).
 *                 The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 *                 Hints: #15, #32, #43
 */

// Done 7
/**
 * 3.7 먼저 들어온 동물이 먼저 나가는 동물 쉽터(Animal Shelter)가 있다고 하자.
 *     이 쉽터는 개와 고양이만 수용할 수 있다.
 *     사람들은 쉽터의 동물들 가운데 들어온 지 가장 오래된 동물부터 입양할 수 있는데, 개와 고양이 중 어떤 동물을 데려갈지 선택할 수도 있다.
 *     특정한 동물을지정해 데려가는 것은 금지되어 있다.
 *     이 시스템을 자료구조로 구현하라.
 *     해당 자료구조는 enqueue, dequeueAny, dequeueDog, dequeueCat 의 연산들을 제공해야 한다.
 *     언어에 기본 탑재되어 있는 LinkedList(Java) 자료구조를 이용해도 된다.
 *
 * (6E)
 * 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 *                     People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 *                     or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 *                     They cannot select which specific animal they would like.
 *                     Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
 *                     You may use the built-in LinkedList data structure.
 *
 *                     Hints: #22, #56, #63
 */


//--------------------------------------------------------------------------------
// Completed --> KE(7개: 1, 2, 3, 5, 6, - 4, 7), 4E(6개: 1, 2, 3, 5, 6, - 4), 6E(6개: 1, 2, 3, 4, 5 - 6)
//--------------------------------------------------------------------------------

//--------------------------------------------------------------------------------
// 연결리스트(2.7), 수학과 확률(7.7)  
//
// (6E)
// Additional Questions: Linked Lists (#2.6), Moderate Problems (#16.26), Hard Problems (#17.9).
//--------------------------------------------------------------------------------
public class StackQueue {
}
