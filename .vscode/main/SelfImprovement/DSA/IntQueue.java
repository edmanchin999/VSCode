public class IntQueue {

    // intialise the data;
    private int[] arr;
    private int first, last, size;

    // Initialise the queue
    public IntQueue(int maximumSize) {
        first = last = 0;
        size = maximumSize + 1;
        arr = new int[size];

        // so the array will have [0,0] with the size of 2
    }

    // check if the array is empty or not
    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        if (first > last) { // if the fist is greater than last
            return (last + size - first);
        } else {
            return last - first;
        }
    }

    public int peek() {
        return arr[first]; // just return the first element in the array
    }

    public void enqueue(int value) {
        arr[last] = value; // insert or append the value into the array
        if (++last == size) { // if the last index value is equal to the size of the array
            last = 0; // then the last value will be automatically assign to 0 because there is no
                      // spot
        } else if (last == first) { // if the last element of the array is equals to the first
            throw new RuntimeException("Queue is too small"); // throw exception because the queue is too small which
                                                              // there is only one element in the array
        }
    }

    public int dequeue() {
        int get_value = arr[first]; // first get the first value of the element in the array
        if (++first == size) { // if the first value = the size of the array
            first = 0; // then change tht first value = 0 becuse it is only have one element in the
                       // array
        } // else the other will move forward to the queue
        return get_value; // last return the value for future algo
    }

    public static void main(String[] args) {
        IntQueue q = new IntQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3
        System.out.println(q.dequeue()); // 4

        System.out.println(q.isEmpty()); // false

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue()); // 5
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        System.out.println(q.dequeue()); // 3

        System.out.println(q.isEmpty()); // true

        benchMarkTest();
    }

    // BenchMark IntQueue vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        IntQueue intQ = new IntQueue(n);

        // IntQueue times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            intQ.enqueue(i);
        for (int i = 0; i < n; i++)
            intQ.dequeue();
        long end = System.nanoTime();
        System.out.println("IntQueue Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); //
        // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++)
            arrayDeque.offer(i);
        for (int i = 0; i < n; i++)
            arrayDeque.poll();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
    }
}
