package ch16threadlock; /**
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

// 메서드에 synchronized: 두 쓰레드가 동일한 '객체/인스턴스'의 메서드를 동시에 실행 불가

// 두 쓰레드가 synchronized 를 동시에 호출 가능한가? --> 상황에 따라 다르다.
//  - 1) 동일한 객체를 가지고 작업을 하는 경우 --> NO
//  - 2) 다른 객체라면 --> YES
// 즉, 개념적으로 보면 Lock 문제와 동일

// synchronized method 를 호출하면, 동일한 객체의 모든 synchronized methods 에 Lock 이 걸린다. --> 다른 synchronized method 를 실행하려는 쓰레드는 block 된다.

// 1번 쓰레드는 synchronized method 호출 && 2번 쓰레드는 non-synchronized method 호출 --> 가능 --> 객체가 다르다면 더더욱 가능

// ==> 즉, 결론은 객체별로 실행 가능한 synchronized method 는 '하나' 
