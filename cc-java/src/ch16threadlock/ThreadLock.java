package ch16threadlock;

// Done 1
/**
 * 16.1 쓰레드와 프로세스의 차이는?
 *
 * (4E)
 * 18.1 What’s the difference between a thread and a process?
 *
 * (6E)
 * 15.1 Thread vs. Process: What's the difference between a thread and a process?
 */

// Done 6
/**
 * 16.6 동기화된 메서드 A와 일반 메서드 B를 제공하는 클래스가 있다.
 *      같은 프로그램 안에서 실행되는 두 개 쓰레드가 A를 동시에 실행할 수 있는가?
 *      A와 B는 동시에 실행할 수 있는가?
 *
 * (4E)
 * 18.6 You are given a class with synchronized method A, and a normal method C.
 *      If you have two threads in one instance of a program, can they call A at the same time?
 *      Can they call A and C at the same time?
 *
 * (6E)
 * 15.6 Synchronized Methods: You are given a class with synchronized method A and a normal method B.
 *                            If you have two threads in one instance of a program, can they both execute A at the same time?
 *                            Can they execute A and B at the same time?
 */

// WIP 5
/**
 * 16.5 다음과 같은 코드가 있다고 하자.
 *      public class Foo {
 *          public Foo() { ... }
 *          public void first() { ... }
 *          public void second() { ... }
 *          public void third() { ... }
 *      }
 *
 *      이 클래스로 만든 객체 하나를 서로 다른 세 쓰레드에 전달한다.
 *      ThreadA는 first를 호출할 것이고, threadB는 second를 호출할 것이며, threadC는 third를 호출할 것이다.
 *      first가 second보다 먼저 호출되고, second가 third보다 먼저 호출되도록 보장하는 메커니즘을 설계하라.
 *
 * (4E)
 * 18.5 Suppose we have the following code:
 *      class Foo {
 *          public:
 *              A(.....); // If A is called, a new thread will be created and the corresponding function will be executed.
 *              B(.....); // same as above
 *              C(.....); // same as above
 *      }
 *
 *      Foo f;
 *      f.A(.....);
 *      f.B(.....);
 *      f.C(.....);
 *
 *      i) Can you design a mechanism to make sure that B is executed after A, and C is executed after B?
 *      iii) Suppose we have the following code to use class Foo. We do not know how the threads will be scheduled in the OS.
 *              Foo f;
 *              f.A(.....); f.B(.....); f.C(.....);
 *              f.A(.....); f.B(.....); f.C(.....);
 *
 *           Can you design a mechanism to make sure that all the methods will be executed in sequence?
 *
 * (6E)
 * 15.5 Call in Order: Suppose we have the followi ng code:
 *                     public class Foo {
 *                          public Foo() { ... }
 *                          public void first() { ... }
 *                          public void second() { ... }
 *                          public void third() { ... }
 *                     }
 *
 *                     The same instance of Foo will be passed to three different threads.
 *                     ThreadA will call first, threadB will call second, and threadC will call third.
 *                     Design a mechanism to ensure that first is called before second and second is called before third.
 */


//--------------------------------------------------------------------------------
// Korean Edition: Unsolved --> 2, 3, 4, 5
//--------------------------------------------------------------------------------
/**
 * 16.2 문맥 전환(context switching)에 소요되는 시간을 측정하면?
 *
 * 16.3
 *
 * 16.4 교착상태에 빠지지 않는 경우에만 락을 주는 클래스를 설계해 보라.
 */

//--------------------------------------------------------------------------------
// English Edition: Unsolved --> 4E(), 6E()
//--------------------------------------------------------------------------------
public class ThreadLock {
}
