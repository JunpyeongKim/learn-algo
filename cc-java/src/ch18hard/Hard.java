package ch18hard;

// WIP 5
/**
 * 18.5 단어들이 적여있는 아주 큰 텍스트 파일이 있다.
 *      단어 두 개가 입력으로 주어졌을 때, 해당 파일 안에서 그 두 단어 사이의 최단거리(단어 수를 기준으로 측정한)를 구하는 코드를 작성하라.
 *      같은 파일에 대해 단어 간 최단거리를 구하는 연산을 여러 번 반복하게 된다고 했을 때(단어 쌍은 서로 다른 것을 사용한다) 어떤 최적화 기법을 사용할 수 있는가?
 * 
 * (4E)
 * 20.5 You have a large text file containing words. 
 *      Given any two words, find the shortest distance (in terms of number of words) between them in the file. 
 *      Can you make the searching operation in O(1) time? 
 *      What about the space complexity for your solution?
 * 
 * (6E)
 * 17.11 Word Distance: You have a large text file containing words. 
 *                      Given any two words, 
 *                      find the shortest distance (in terms of number of words) between them in the file. 
 *                      If the operation will be repeated many times for the same file (but different pairs of words), 
 *                      can you optimize your solution?
 * 
 *                      Hints: 
 *                      #486, 
 *                      #501, 
 *                      #538, 
 *                      #558, 
 *                      #633
 */


// TBD 6
/**
 * 18.6
 */

// TBD 8
/**
 * 18.8
 */

// TBD 9
/**
 * 18.9
 */

// TBD 19
/**
 * 18.19
 *
 */

// TBD 13
/**
 * 18.13
 */


// TBD 26
/**
 * 17.26 Sparse Similarity: The similarity of two documents (each with distinct words) is defined to be the size of the intersection divided by the size of the union. 
 *                          For example, if the documents consist of integers, the similarity of {1, 5, 3} and {1, 7, 2, 3} is 0.4, 
 *                          because the intersection has size 2 and the union has size 5.
 *                          We have a long list of documents (with distinct values and each with an associated ID) where the similarity is believed to be "sparse".
 *                          That is, any two arbitrarily selected documents are very likely to have similarity O. 
 *                          Design an algorithm that returns a list of pairs of document IDs and the associated similarity.
 * 
 *                          Print only the pairs with similarity greater than O. 
 *                          Empty documents should not be printed at all. 
 *                          For simplicity, you may assume each document is represented as an array of distinct integers.
 * 
 *                          EXAMPLE
 *                          Input:
 *                              13: {14, 15, 100, 9, 3}
 *                              16: {32, 1, 9, 3, 5}
 *                              19: {15, 29, 2, 6, 8, 7}
 *                              24: {7, 10}
 *                          Output:
 *                              ID1, ID2 : SIMILARITY
 *                              13, 19   : 0.1
 *                              13, 16   : 0.25
 *                              19, 24   : 0.14285714285714285
 * 
 *                          Hints: #484, #498, #510, #518, #534, #547, #555, #561, #569, #577, #584, #603, #611, #636
 */

/*
# Completed 
- KE(13개: - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
- 4E(13개: - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
- 6E(26개: - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
*/
public class Hard {
}
