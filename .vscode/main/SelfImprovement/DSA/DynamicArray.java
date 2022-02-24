import java.util.*;
import javax.management.ObjectInstance;

public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int lengthOftheArray = 0;
    private int capacityOftheArray = 0;

    // 2 contructor
    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacityOftheArray) {
        if (capacityOftheArray < 0)
            throw new IllegalArgumentException("Wrong Capacity: " + capacityOftheArray);
        this.capacityOftheArray = capacityOftheArray;
        arr = (T[]) new Object[capacityOftheArray];
    }

    // print the size method
    public int size() {
        return lengthOftheArray;
    }

    // check the arrays is empty or not
    public boolean isEmpty() {
        return size() == 0;
        // return lengthOfthrArray == 0;
    }

    // get and set for the object
    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    // clear the whole array method
    public void clear() {
        for (int i = 0; i < lengthOftheArray; i++) { // loop every index then change the data inside into NULL
            arr[i] = null;
        }
        lengthOftheArray = 0; // then change the length of the array is 0
    }

    // add the element into the array method

    public void add(T element) {
        if (lengthOftheArray + 1 >= capacityOftheArray) { // if the new add array is more than the capacity of the array
                                                          // , it needs to increase the 2x the capacity.
            if (capacityOftheArray == 0) { // if length is more than 0
                capacityOftheArray = 1; // this is to make sure that there is at least one capacity to insert element
            } else {
                capacityOftheArray *= 2; // create double the initial array size
            }
            T[] new_arr = (T[]) new Object[capacityOftheArray]; // create a new array
            for (int i = 0; i < lengthOftheArray; i++) { // copy all values to the new arrray
                new_arr[i] = arr[i]; // insert the existing element from old array into new array
            }
            arr = new_arr; // replace back the name into old variable.
        }
        arr[lengthOftheArray++] = element; // else just copy the new array
    }

    // removes an element at the specific index in this array
    public T removeAt(int remove_index) {
        if (remove_index >= lengthOftheArray || remove_index < 0)
            throw new IndexOutOfBoundsException();// to check the index is valid or not
        T data = arr[remove_index];
        T[] new_arr = (T[]) new Object[lengthOftheArray - 1]; // initialise new array
        for (int i = 0, j = 0; i < lengthOftheArray; i++, j++) {
            if (i == remove_index) {
                j--; // skip over remove_index by fixing j temporary
            } else {
                new_arr[j] = new_arr[i];
            }

        }
        arr = new_arr;
        capacityOftheArray = --lengthOftheArray;
        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj); // scan through the array and return the index number
        if (index == -1) { // if the index is out of the array then return false
            return false;
        } else {
            removeAt(index); // else it will scan through all the array and remove the element
            return true;
        }
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < lengthOftheArray; i++) { // scan through all the element in the array
            if (obj == null) { // check the object which is the array is null or not
                if (arr[i] == null) { // if the slot of that array is null then it will return the index number
                    return i;
                } else {
                    if (obj.equals(arr[i])) { // else if the object
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    // Iterator is still fast but not as fast iterative for loop
    // Purpose for it to move(traverse) from one element to another element
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < lengthOftheArray;
            }

            public T next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public String toString() {
        if (lengthOftheArray == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(lengthOftheArray).append("[");
            for (int i = 0; i < lengthOftheArray; i++) {
                sb.append(arr[i] + ", ");
            }
            return sb.append(arr[lengthOftheArray - 1] + "]").toString();
        }

    }

}
