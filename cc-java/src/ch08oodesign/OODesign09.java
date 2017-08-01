package ch08oodesign;

/**
 * 8.9 메모리 상주형 파일 시스템을 구현하기 위한 자료구와 알고리즘에 대해 설명해 보라.
 *    가능하다면 코드 예제를 들어 설명하도록 하라.
 * --> Entry, File, Directory 관계를 생각하면 in-memory fs 쉽게 생성 가능
 * --> 디렉토리의 파일 갯수에 디렉토리 포함여부는 변경 가능
 * --> 디렉토리에서 하위 디렉토리와 파일 관리를 분리해서 하면 파일 갯수 계산이 편리해지고 instanceof 미사용해도 된다.
 *     그러나, 날짜나 이름순 정렬할 때 번거로운 로직이 생긴다.
 * 
 * (4E)
 * 7.9 Explain the data structures and algorithms that you would use to design an in-memory file system. 
 *     Illustrate with an example in code where possible.
 * 
 * (6E)
 * 7.11 File System: Explain the data structures and algorithms that you would use to design an in-memory file system. 
 *                   Illustrate with an example in code where possible.
 *                   Hints: #141, #276
 */

/**
 * FS 컴포넌트로는 File, Directory 필요 --> 두 가지의 공통 콤포넌트로 Entry 정의 --> 상속 개념 알면 쉬움
 * 파일 삭제시 parent 없으면 삭제 불가는 네고 필요
 * 파일 갯수에 디렉토리 갯수 포함도 네고 필요
 * 
 * 디렉토리가 파일과 디렉토리를 하나의 리스트로 관리 또는 분리 관리 여부는 여러가지 장단점으로 선택 가능.
 */


public class OODesign09 {}

