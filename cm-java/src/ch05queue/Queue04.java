package ch05queue;

/*
문제-4 움직이는 창의 최대합:
        배열 A[]에 크기가 w인 창이 있어서 배열의 맨 왼쪽으로부터 오른쪽으로 움직인다고 하자.
        창 안의 w개의 숫자만 볼 수 있다고 가정하자. 창은 매번 한 개씩 오른쪽으로 움직인다.
        예를 들어, 배열이 [1 3 -1 -3 5 3 6 7] 이고 w가 3이면 다음 표와 같다.

          창의 위치                     최대값
          [1 3 -1] -3 5 3 6 7           3
          1 [3 -1 -3] 5 3 6 7           3
          1 3 [-1 -3 5] 3 6 7           5
          1 3 -1 [-3 5 3] 6 7           5
          1 3 -1 -3 [5 3 6] 7           6
          1 3 -1 -3 5 [3 6 7]           7

      입력: 긴 배열 A[], 창의 크기 w
      출력: B[i]가 A[i]에서 A[i+w-1]까지의 최대값인 배열 B[]
      요구사항: B[i]를 구하는 최적화된 방법을 찾아라.

Problem-4 Maximum sum in sliding window:
            Given array A[] with sliding window of size w which is moving
            from the very left of the array to the very right.
            Assume that we can only see the w numbers in the window.
            Each time the sliding window moves rightwards by one position.
            For example: The array is [1 3 -1 -3 5 3 6 7], and w is 3.

                Window position               Max
                [1 3 -1] -3 5 3 6 7           3
                1 [3 -1 -3] 5 3 6 7           3
                1 3 [-1 -3 5] 3 6 7           5
                1 3 -1 [-3 5 3] 6 7           5
                1 3 -1 -3 [5 3 6] 7           6
                1 3 -1 -3 5 [3 6 7]           7

         Input: A long array A[], and a window width w.
         Output: An array B[], B[i] is the maximum value from A[i] to A[i+w-1].
         Requirement: Find a good optimal way to get B[i]
 */
public class Queue04 {

}