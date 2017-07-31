package ch08oodesign; /**
 * 1. 카드 게임에 쓰이는 카드 한 벌을 표현하기 위한 자료구조를 설계하자.
 *    Blackjack 게임을 구현하려면 이 자료구조의 하위 클래스르 어떻게 만들어야 하는지 설명하라.
 */


//--------------------------------------------------------------------------------


/**
 * 2. 고객 응대 담당자, 관리자, 그리고 감독관이라는 세 부류 직원들로 구성된 Call Center가 있다고 하자.
 *    콜 센터로 오는 전화는 처음에는 무조건 상담 가능 고객 응대 담당자로 연결된다.
 *    고객 응대 담당자가 처리할 수 없는 전화는 관리자로 연결된다.
 *    관리자가 처리할 수 없는 전화는 다시 감독관에게 연결된다.
 *    이 문제를 풀기 위한 자료구조를 설계하라.
 *    응대 가능한 첫 번째 직원에게 전화를 연결시키는 dispatchCall 메서드를 구현하라.
 */


//--------------------------------------------------------------------------------


//--------------------------------------------------------------------------------
/**
 * 8.3 객체 지향 원칙에 따라 JukeBox를 설계하라.
 * 
 * (4E)
 * 7.3 Design a musical jukebox using object-oriented principles.
 * 
 * (6E)
 * 7.3 Jukebox: Design a musical jukebox using object-oriented principles.
 */


//--------------------------------------------------------------------------------

/**
 * 8.4 객체 지향 원칙에 따라 Parking lot을 설계하라.
 * --> 제공 기능: 사용자 가입/확장, 서적 검색, 읽기, 한명만/한권만 활성만
 * 
 * (6E)
 * 7.4 Parking Lot: Design a parking lot using object-oriented principles.
 */


//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------

//--------------------------------------------------------------------------------

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


//--------------------------------------------------------------------------------

/**
 * 8.10 Chain(즉, 연결 리스트)을 사용해 충돌을 해결하는 해시 테이블 설계하고 구현하라.
 * --> (코드리뷰: 완료 / 한글 설명 리뷰: TBD / 영문 설명 리뷰: TBD)
 * --> 요약: jim & bob 이 동일한 hashing value 를 가질 경우 Key가 없으면 찾기 어려우므로, Cell<K, V> 타입의 연결리스트 사용 
 *          가장 널리 사용된느 방법은 Binary Search Tree를 사용하여 검색시간 O(1)을 이용하는 것이다.
 * --> 체크: BST 검색 시간 O(1) ? 
 * 
 * (6E)
 * 7.12 Hash Table: Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 *                  Hints: #287, #307
 */


/**
 * 2. 고객 응대 담당자, 관리자, 그리고 감독관이라는 세 부류 직원들로 구성된 Call Center가 있다고 하자.
 *    콜 센터로 오는 전화는 처음에는 무조건 상담 가능 고객 응대 담당자로 연결된다.
 *    고객 응대 담당자가 처리할 수 없는 전화는 관리자로 연결된다.
 *    관리자가 처리할 수 없는 전화는 다시 감독관에게 연결된다.
 *    이 문제를 풀기 위한 자료구조를 설계하라.
 *    응대 가능한 첫 번째 직원에게 전화를 연결시키는 dispatchCall 메서드를 구현하라.
 * 
 * 5. Online Book Reader 에 대한 자료구조를 설계하라.
 * 
 * 6. Jigsaw 퍼즐을 구현하라.
 *    자료구조를 설계하고, 퍼즐을 푸는 알고리즘을 설명하라.
 *    주어진 두 개의 조각이 들어맞는지를 판별하는 fitsWith 메서드가 주어진다고 가정하도록 하라.
 * 
 * 7. 채팅 서버를 어떻게 구현할 것인지 설명하라.
 *    서버를 뒷받침할 다양한 컴포넌트, 클래스, 메서드에 대해 설명하도록 하라.
 *    어떤 문제가 가장 풀기 어려울 것으로 에상되는가?
 * --> 여기서는 1) 사용자 관리와 2) 사용자간 대화에 관련된 기능에 초점
 * --> 친구 관계는 양방향, 그룹/일대일 채팅 지원 (음성/화상 채팅, 파일 전송 미지원원
 * --> 지원 기능: 온/오프라인 알림, 친구 추가 요청, 상태메시지 갱신, 일대일/그룹 세션 생성 등
 * --> 시스템 핵심 컴포넌트: 데이터베이스, 사용자듩, 서버들 --> 그러나 OOD 에는 미포함, 즉 시스템의 전반적인 형태이긴 하다
 * --> DB : SQL --> BigTable
 * --> 서버-클라이언트 통신 : XML --> JSON ??
 * --> 여러대의 서버: 데이터는 분할되어 저장 --> 탐색 오버헤드를 최소화하기 위해, 제약조건으로 SPOF(Single Point Of Failure) 제거 필요
 * --> 핵심 객체와 메서드: 사용자, 대화, 상태 정보 --> UserManagement
 * --> 채팅 서버의 다양한 가능성을 그림으로 그려보자.
 * 
 * 8. 오셀로 게임 규칙은 이러하다.
 *    각 오셀로 말은 한쪽 면은 흰색으로, 다른쪽 면은 검정색으로 칠해져 있다.
 *    상대편 말에 왼쪽과 오른쪽, 또는 위 아래가 포위된 말은 색상을 뒤집어 상대편 말이 된 것으로 표시된다.
 *    여러분 차례가 오면 여러분은 적어도 하나의 상대편 말을 획득해야 한다. 
 *    더 이상 가능한 수가 없는 상태에서 도닥하면 게임은 종료된다.
 *    승자는 가장 많은 말을 획득한 사람이다. 
 *    이 게임을 객체 지향적으로 설계해 보라.
 */

/**
 * 4E
 * 
 * 7.1 Design the data structures for a generic deck of cards. Explain how you would subclass it to implement particular card games.

7.2 Imagine you have a call center with three levels of employees: fresher, technical lead
(TL), product manager (PM). There can be multiple employees, but only one TL or PM.
An incoming telephone call must be allocated to a fresher who is free. If a fresher
can’t handle the call, he or she must escalate the call to technical lead. If the TL is
not free or not able to handle it, then the call should be escalated to PM. Design the
classes and data structures for this problem. Implement a method getCallHandler().

7.3 Design a musical juke box using object oriented principles.

7.4 Design a chess game using object oriented principles.

7.5 Design the data structures for an online book reader system.

7.6 Implement a jigsaw puzzle. Design the data structures and explain an algorithm to
solve the puzzle.

7.7 Explain how you would design a chat server. In particular, provide details about the
various backend components, classes, and methods. What would be the hardest
problems to solve?

7.8 Othello is played as follows: Each Othello piece is white on one side and black on the
other. When a piece is surrounded by its opponents on both the left and right sides,
or both the top and bottom, it is said to be captured and its color is flipped. On your
turn, you must capture at least one of your opponent’s pieces. The game ends when
either user has no more valid moves, and the win is assigned to the person with the
most pieces. Implement the object oriented design for Othello.



7/10 Describe the data structures and algorithms that you would use to implement a garbage
collector in C++.
 */

/**
 * 6E
 * 
 * 7.1 Deck of Cards: Design the data structures for a generic deck of cards. 
 *                    Explain how you would subclass the data structures to implement blackjack.
 *                    Hints: #153, #275
 * 
 * 7.2 Call Center: Imagine you have a call center with three levels of employees: respondent, manager, and director. 
 *                  An incoming telephone call must be first allocated to a respondent who is free. 
 *                  If the respondent can't handle the call, he or she must escalate the call to a manager. 
 *                  If the manager is not free or not able to handle it, then the call should be escalated to a director. 
 *                  Design the classes and data structures for this problem. 
 *                  Implement a method dispatchCall() which assigns a call to the first available employee.
 *                  Hints: #363
 * 
 * 7.3 Jukebox: Design a musical jukebox using object-oriented principles.
 *              Hints: # 198
 * 
 * 7.4 Parking Lot: Design a parking lot using object-oriented principles.
 *                  Hints: #258
 * 
 * 7.5 Online Book Reader: Design the data structures for an online book reader system.
 *                         Hints: #344
 * 
 * 7.6 Jigsaw: Implement an NxN jigsaw puzzle. 
 *             Design the data structures and explain an algorithm to solve the puzzle. 
 *             You can assume that you have a fitsWith method which, when passed two puzzle edges, 
 *             returns true if the two edges belong together.
 *             Hints: # 192, #238, #283
 * 
 * 7.7 Chat Server: Explain how you would design a chat server. 
 *                  In particular, provide details about the various backend components, classes, and methods. 
 *                  What would be the hardest problems to solve?
 *                  Hints: #213, #245, #271
 * 
 * 7.8 Othello: Othello is played as follows: 
 *              Each Othello piece is white on one side and black on the other.
 *              When a piece is surrounded by its opponents on both the left and right sides, or both the top and bottom, 
 *              it is said to be captured and its color is flipped. 
 *              On your turn, you must capture at least one of your opponent's pieces. 
 *              The game ends when either user has no more valid moves. 
 *              The win is assigned to the person with the most pieces. 
 *              Implement the object-oriented design for Othello.
 *              Hints: # 179, #228
 * 
 * 7.9 Circular Array: Implement a CircularArray class that supports an array-like data structure which can be efficiently rotated. 
 *                     If possible, the class should use a generic type (also called a template), 
 *                     and should support iteration via the standard for (Obj o : circularArray) notation.
 *                     Hints: #389
 * 
 * 7.10 Minesweeper: Design and implement a text-based Minesweeper game. 
 *                   Minesweeper is the classic single-player computer game where an NxN grid has B mines (or bombs) hidden across the grid. 
 *                   The remaining cells are either blank or have a number behind them. 
 *                   The numbers reflect the number of bombs in the surrounding eight cells. 
 *                   The user then uncovers a cell. 
 *                   If it is a bomb, the player loses.
 *                   If it is a number, the number is exposed. 
 *                   If it is a blank cell, this cell and all adjacent blank cells (up to and including the surrounding numeric cells) are exposed. 
 *                   The player wins when all non-bomb cells are exposed. 
 *                   The player can also flag certain places as potential bombs. 
 *                   This doesn't affect game play, other than to block the user from accidentally clicking a cell that is thought to have a bomb.
 *                   (Tip for the reader: if you're not familiar with this game, please play a few rounds online first.)
 *              
 *                   상세 그림 필요....
 */