package ch11scalablememory;// WIP 1
/**
 * 11.1 서비스 하나를 구현한다고 하자.
 *      이 서비스는 폐장 시점에 주가 정보(시작가, 종가, 최고가, 최저가)를 최대 1000개 클라이언트에게 제공한다.
 *      데이터는 이미 가지고 있고, 원하는 아무 형태로나 저장할 수 있다고 가정해도 좋다.
 *      이 서비스를 어떻게 설계하면 좋겠는가?
 *      여러분은 개발과 배포를 책임져야 하고, 지속적으로 시스템을 모니터링해야 하는 한편 사용자에게 전송되는 정보를 관리해야 한다.
 *      생각했던 방법들에 대해 설명한 다음, 어떤 접근법을 왜 선택했는지 설명하라.
 *      어떤 기술을 사용해도 좋다.
 *      클라이언트 프로그램에 정보를 전송하는 방법도 원하는 대로 선택할 수 있다.
 * 
 * (4E)
 * 12.1 If you were integrating a feed of end of day stock price information (open, high, low, and closing price) for 5,000 companies, 
 *      how would you do it? 
 *      You are responsible for the development, rollout and ongoing monitoring and maintenance of the feed. 
 *      Describe the different methods you considered and why you would recommend your approach. 
 *      The feed is delivered once per trading day in a comma-separated format via an FTP site. 
 *      The feed will be used by 1000 daily users in a web application.
 * 
 * (6E)
 * 9.1 Stock Data: Imagine you are building some sort of service that will be called by up to 1,000 client applications 
 *                 to get simple end-of-day stock price information (open, close, high, low). 
 *                 You may assume that you already have the data, and you can store it in any format you wish. 
 *                 How would you design the client-facing service that provides the information to client applications? 
 *                 You are responsible for the development, rollout, and ongoing monitoring and maintenance of the feed. 
 *                 Describe the different methods you considered and why you would recommend your approach. 
 *                 Your service can use any technologies you wish, and can distribute the information to the client applications 
 *                 in any mechanism you choose.
 * 
 *                 Hints: #385, #396
 */


// WIP 2
/**
 * 11.2 페이스북이나, 링크드인과 같은 대규모 소셜 네트워크를 위한 자료구조는 어떻게 설계하겠는가?
 *      두 사람 사이의 관계를 보여주는 알고리즘은 어떻게 설계하겠는가?
 *      (가령 나 -> 밥 -> 수잔 -> 제이슨 -> 당신)
 * 
 * (4E)
 * 12.2 How would you design the data structures for a very large social network (Facebook, LinkedIn, etc)? 
 *      Describe how you would design an algorithm to show the connection, or path, between two people 
 *      (e.g., Me -> Bob -> Susan -> Jason -> You).
 * 
 * (6E)
 * 9.2 Social Network: How would you design the data structures for a very large social network like Facebook or Linkedln? 
 *                     Describe how you would design an algorithm to show the shortest path between two people 
 *                     (e.g., Me -> Bob -> Susan -> Jason -> You).
 * 
 *                     Hints: #270, #285, #304, #327
 */


//--------------------------------------------------------------------------------
// Korean Edition: Unsolved --> 3, 4, 5, 6, 7
//--------------------------------------------------------------------------------
/**
 * 3. 40억 개의 0을 포함하는 양의 정수가 들어 있는 파일이 있다.
 *    이 파일에 없는 정수 하나를 찾는 알고리즘을 고안하라.
 *    1GB의 메모리를 사용할 수 있다.
 *    - 연관 문제
 *          메모리가 10MB 밖에 없다면? 중복된 수는 없으며, 전부 10억개 이하라고 가정하라.
 * 
 * 4. 1부터 N까지 숫자가 든 배열이 있다.
 *    N은 최대 32,000이다,
 *    이 배열에는 중복된 숫자가 있으며, N이 얼마인지 모른다.
 *    메모리는 4Kbytes 로 제한되어 있다.
 *    배열에 있는 모든 중복 원소를 출력하려면 어떻게 해야 하겠는가?
 * 
 * 5. 웹에 있는 데이터를 긁어오는 Crawler 를 설계할 때, 무한 루프에 빠지는 걸 방지하려면 어떻게 해야 하겠는가?
 * 
 * 6. 100억개의 URL이 있다.
 *    중복된 문서를 찾으려면 어떻게 해야 하겠는가?
 *    '중복'은 '같은 URL'이라는 뜻이다.
 * 
 * 7. 단순화된 검색 엔진을 탑재한 웹 서버를 상상해 보자.
 *    검색 질의에 답하기 위한 100개의 기계가 있다.
 *    이 각각은 processSearch(string query)를 통해 또 다른 서버 클러스터에게 검색 결과를 요구한다.
 *    주어진 질의를 처리할 기계는 무작위로 설정되기 때문에, 같은 질의를 항상 같은 기계가 처리하리라는 보장은 없다.
 *    processSearch 는 처리 비용이 굉장히 비싼 메서드다.
 *    가장 최근에 주어진 질의의 처리 결과를 캐싱하는 방법을 설계하라.
 *    데이터가 변경되었을 때 캐시를 어떻게 갱신할 것인지 반드시 설명하라.
 */


//--------------------------------------------------------------------------------
// English Edition: Unsolved --> 4E(), 6E()
//--------------------------------------------------------------------------------