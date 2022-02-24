//This is stack for integer that use array as the base of the data structure
public class IntStack {

    // initialise the required data
    private int[] arr; // array
    private int position = 0; // slot

    public IntStack(int maximumSize) { // constructor
        arr = new int[maximumSize];
    }

    public int size() { // return the size of the array
        return position;
    }

    public boolean isEmpty() { // return the position = 0 because it is empty
        return position == 0;
    }

    public int peek() { // peek the last slot of the array
        return arr[position - 1]; // must - 1 because the index of the array is start from 0
    }

    public void push(int value) {
        arr[position++] = value; // when push an new element into the array , the possition in the array must +
        // in the meantime the new slot of array equals to the new value
    }

    public int pop() {
        return arr[--position]; // just remove the last position of the array which automatically remove the
                                // value inside the array
    }

    public static void main(String[] args) { // examples
        IntStack s = new IntStack(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop()); // pop 5
        System.out.println(s.pop()); // pop 4
        System.out.println(s.pop()); // pop 3

        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.pop());

            benchMarkTest();
        }
    }

    private static void benchMarkTest() {

        int n = 10000000;
        IntStack intStack = new IntStack(n);

        // IntStack times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            intStack.push(i);
        for (int i = 0; i < n; i++)
            intStack.pop();
        long end = System.nanoTime();
        System.out.println("IntStack Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); //
        // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++)
            arrayDeque.push(i);
        for (int i = 0; i < n; i++)
            arrayDeque.pop();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);

    }

}
