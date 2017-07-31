package ch16threadlock; /**
 * 16.1 쓰레드와 프로세스의 차이는?
 * 
 * (4E)
 * 18.1 What’s the difference between a thread and a process?
 * 
 * (6E)
 * 15.1 Thread vs. Process: What's the difference between a thread and a process?
 */

// 서로 관계는 있으나 기본적으로 다르다.

// 프로세스:
//  - 실행되고 있는 프로그램 개체로써 --> System Resource(CPU time, memory, etc)를 할당 받는 독립적인 개체
//  - 다른 프로세스의 변수나 자료구조에 접근 불가 --> IPC(pipe, file, socket, etc) 을 이용해야 한다.

// 쓰레드:
//  - 프로세스 내부에 존재하면서 --> 프로세스 자원(힙, ..)을 공유 --> 예를 들어, 힙을 다른 쓰레드와 공유 --> 프로세스 자원을 변경하면 다른 이웃 쓰레드(sibling threads) 도 그 변경 결과를 즉시 확인 가능하다.
//  - 각각 별도의 레지스터와 스택을 가진다.
//  - 어떤 면에 보면, 프로세스의 특정한 수행 경로이다.