public class Queue<T> implements Iterable<T> {

    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Queue() {

    }

    public Queue(T firstElement) {
        push(firstElement);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("It is empty queue");
        }
        return list.peekFirst();
    }

    public T poll() {
        if (isEmpty())
            throw new RuntimeException("It is empty queue");
        return list.removeFirst();
    }

    public void push(T element) {
        list.addLast(element);
    }

    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
