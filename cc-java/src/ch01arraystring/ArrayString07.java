package ch01arraystring;

import lib.AssortedMethods;

/**
 * 1.7 MxN 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
 *
 * (4E)
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0,
 *     its entire row and column is set to 0.
 *
 * (6E)
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 *                  its entire row and column are set to 0.
 *
 */
public class ArrayString07 {
    //--------------------------------------------------------------------------------
    // Common
    //--------------------------------------------------------------------------------
    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }


    //--------------------------------------------------------------------------------
    // Solution #1. Buffer - boolean or a bit vector
    //              - Space Complexity: O(n)
    //--------------------------------------------------------------------------------
    public static void setZeros01(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        // Flags the zero locations
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        // Nullify
//        /* Alternative 01: Time Complexity, O(n)
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < columns.length; j++) {
            if (columns[j]) {
                nullifyColumn(matrix, j);
            }
        }
        //*/

        /* Alternative 02: Time Complexity, O(n^2)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        //*/
    }


    //--------------------------------------------------------------------------------
    // Solution #1. No Buffer - in place
    //              - Space Complexity: O(1)
    //--------------------------------------------------------------------------------
    public static void setZeros02(int[][] matrix) {
        boolean firstRowHasZero = false,
                firstColumnHasZero = false;

        // Check if the first row and first column have any zeros.
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        // Flags the zero locations in the rest of the array.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Nullify
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (firstRowHasZero) {
            nullifyRow(matrix, 0);
        }

        if (firstColumnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }


    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    private static int[][] cloneMatrix(int[][] matrix) {
        int nrows = matrix.length;
        int ncolumns = matrix[0].length;
        int[][] clone = new int[nrows][ncolumns];

        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncolumns; j++) {
                clone[i][j] = matrix[i][j];
            }
        }

        return clone;
    }

    private static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int nrows = 10, ncolumns = 15;
        int[][] matrix01 = AssortedMethods.randomMatrix(nrows, ncolumns, -10, 10);
        int[][] matrix02 = cloneMatrix(matrix01);

        System.out.println("Before...");
        AssortedMethods.printMatrix(matrix01);

        setZeros01(matrix01);
        setZeros02(matrix02);

        System.out.println("After...");
        AssortedMethods.printMatrix(matrix01);
        AssortedMethods.printMatrix(matrix02);

        if (matricesAreEqual(matrix01, matrix02)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
