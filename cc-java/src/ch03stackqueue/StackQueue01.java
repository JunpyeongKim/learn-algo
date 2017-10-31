package ch03stackqueue;

/**
 * 3.1 하나의 배열을 사용하여 세 개의 스택을 구현하는 방법을 설명하라.
 *
 * (4E)
 * 3.1 Describe how you could use a single array to implement three stacks.
 * 
 * (6E)
 * 3.1 Three in One: Describe how you could use a single array to implement three stacks.
 *
 *                  Hint #2.
 *                  Hint #12.
 *                  Hint #38.
 *                  Hint #58.
 */
public class StackQueue01 {

    //--------------------------------------------------------------------------------
    // Main
    //--------------------------------------------------------------------------------
    public static void main(String[] args) {
        // FixedMultiStack: 3 Stacks
        FixedMultiStack stacks = new FixedMultiStack(4);

        System.out.print("FixedMultiStack                       ---> ");
        stacks.print();

        try {
            stacks.push(0, 10);
            stacks.push(1, 20);
            stacks.push(2, 30);
            System.out.print("push(0, 10), push(1, 20), push(2, 30) ---> ");
            stacks.print();

            stacks.push(1, 21);
            stacks.push(0, 11);
            stacks.push(0, 12);
            System.out.print("push(1, 21), push(0, 11), push(0, 12) ---> ");
            stacks.print();

            stacks.pop(0);
            System.out.print("pop(0)                                ---> ");
            stacks.print();

            stacks.push(2, 31);
            System.out.print("push(2, 31)                           ---> ");
            stacks.print();

            stacks.push(0, 13);
            stacks.push(1, 22);
            System.out.print("push(0, 13), push(1, 22)              ---> ");
            stacks.print();

            stacks.push(2, 31);
            stacks.push(2, 32);
            System.out.print("push(2, 31), push(2, 32)              ---> ");
            stacks.print();

            // Test: FullStackException
            // stacks.push(2, 33);

            // Test: EmptyStackException
            // stacks.pop(0);
            // stacks.pop(0);
            // stacks.pop(0);
            // stacks.pop(0);
        } catch (FullStackException | EmptyStackException e) {
            e.printStackTrace();
        }

        // MultiStack
        //TODO: ???
    }
}
