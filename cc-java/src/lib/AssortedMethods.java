package lib;

public class AssortedMethods {
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max - min + 1) + min;
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(randomIntInRange(min, max), null, null);
        LinkedListNode previous = root;

        for (int i = 1; i < N; i++) {
            int data = randomIntInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            previous.setNext(next);
            previous = next;
        }

        return root;
    }

    public static LinkedListNode createLinkedListFromArray(int[] vals) {
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;

        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }

        return head;
    }

    //--------------------------------------------------------------------------------
    // Matrix
    //--------------------------------------------------------------------------------
    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        String DELIMITER = " ";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(DELIMITER);
                }

                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(DELIMITER);
                }

                if (matrix[i][j] >= 0) {
                    System.out.print(DELIMITER);
                }

                System.out.print(DELIMITER + matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }


    //--------------------------------------------------------------------------------
    // Array
    //--------------------------------------------------------------------------------
    public static String arrayToString(int[] array, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            sb.append(array[i] + ", ");
        }

        return sb.toString();
    }

    public static String arrayToString(int[] array) {
        if (array == null)
            return "";

        return arrayToString(array, 0, array.length - 1);
    }

    public static String stringArrayToString(String[] array) {
        if (array.length == 0)
            return "";

        StringBuilder sb = new StringBuilder(array.length);
        for (String str : array) {
            sb.append(str + ", ");
        }

        return sb.toString();
    }

    //TODO:
    public static TreeNode createTreeFromArray(int[] arr) {
        return null;
    }
}
