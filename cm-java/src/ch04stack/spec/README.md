Stack
데이터를 저장하기 위한 간단한 데이터 구조
데이터가 도착하는 순서가 중요하다

쌍여있는 접시들이 좋은 예이다

정의: 삽입과 삭제가 한쪽 끝에서 이루어지는, 순서가 매겨진 리스트이다.
top
Last In First Out, First In Last Out

push --> Overflow
pop --> Underflow


---

Stack ADT
다음의 연산들이 스택을 ADT가 되도록 한다.

주요 연산
- push(int data)
- int pop()

보조 연산
- int top()
- int size()
- int isEmptyStack()
- int isFullStack()


---
Exception

빈 스택에 pop(), top()
가득 찬 스택에 push()

---
스택의 구현
제일 많이 사용되는 방법들
1. 간단한 배열에 기반한 구현
2. 동적 배열에 기반한 구현
3. 연결 리스트에 기반한 구현


---
각 구현 방법의 비교


---
TODO

각 구현의 Unit Test