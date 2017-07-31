package ch09recursiondp;

/**
 * 8.6 Implement the “paint fill” function that one might see on many image editing programs.
 *     That is, given a screen (represented by a 2 dimensional array of Colors),
 *     a point, and a new color, fill in the surrounding area until you hit a border of that color.’
 *
 * 9.7 이미지 편집 프로그램에서 흔히 쓰이는 '영역 칠하기paint fill' 함수를 구현하라.
 *     즉, 색상이 칠해진 이차원 배열로 표현되는 스크린과 그 스크린상의 한 지점, 그리고 새로운 색상이 주어졌을 때,
 *     주어진 지점을 포함하는 영역의 색상을 원래 색상에서 새로운 색상으로 변경하는 함수를 작성하라.
 */
public class Question06 {
    enum Color {
        Black, White, Red, Yellow, Green
    }

    boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
        return false;
    }
}
