/*
15.5 비정규화란 무엇인가? 그 장단점을 설명하라.
14.5 Denormalization: What is denormalization? Explain the pros and cons.
Hints: #444, #455
*/

하나 이상의 테이블에 데이터를 중복해 배치하는 최적화 기법

RDB에서 비정규화를 통해 조인 연산 비용 감소 가능

<--> 정규화는 데이터 중복을 최소화하는것이 목적

즉, 어느 정도의 데이터 중복이나 그로 인해 발생하는 데이터 갱신 비용은 눈감아주고, 대신 조인 횟수를 줄여 한층 효율적인 질의 가능

==> 규모 확장성을 요구하는 시스템의 경우 2가지를 섞어 사용