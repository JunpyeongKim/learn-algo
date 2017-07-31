/*
15.4 Join 의 종류를 열거하라.
     각각이 어떻게 다르고, 어떤 상황에는 어떤 JOIN이 어울리는지 설명하라.

(6E)
14.4 Joins: What are the different types of joins? 
            Please explain how they differ and why certain types are better in certain situations.
            Hints:#451
*/

두 테이블을 결함하는데 사용

Join Column 이 필요

어떤 레코드가 결과 테이블에 포함될지에 따라서 여러가지 부류로 나뉜다.

JOIN 방법
1) Inner Join
    - 조건에 부합하는 데이터만 포함

2) Outer Join
    - Inner Join 결과 + 부합하지 않는 데이터 
    A) Left Outer Join (Left Join)
        - 왼쪽 테이블의 모든 레코드가 포함
        - 미일치 데이터는 --> NULL
    B) Right Outer Join (Right Join)
        - 오른쪽 테이블의 모든 레코드가 포함
        - 미일치 데이터는 --> NULL
    ==> A LEFT JOIN B = B RIGHT JOIN A
    C) Full Outer Join
        - Left Join + Right Join