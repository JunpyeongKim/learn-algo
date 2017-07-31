package ch16threadlock; /**
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