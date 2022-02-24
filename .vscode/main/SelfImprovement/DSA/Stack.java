import java.util.*;

//this stack uses list as the base of the data structure 
public class Stack<T> implements Iterable<T> {
    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    // Constructor 1
    public Stack() { // create an empty stack

    }

    // Constructor 2
    public Stack(T firstElement) { // push the first element in the list
        push(firstElement);
    }

    public int size() { // return the size of the list
        return list.size();
    }

    public boolean isEmpty() { // determine the list is empty
        return size() == 0;
    }

    public void push(T element) { // add element on last slot of the list
        list.addLast(element);
    }

    public T pop() { // remove the last element
        if (isEmpty())
            throw new java.util.EmptyStackException(); // if the list is empty in the first place then must throw an
                                                       // exception to end the program
        return list.removeLast();
    }

    public T peek() { // to peek the last element
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return list.iterator(); // return the iterator
    }

}
