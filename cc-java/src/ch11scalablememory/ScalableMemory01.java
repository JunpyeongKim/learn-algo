package ch11scalablememory; /**
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