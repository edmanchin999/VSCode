import java.util.*;

public class ArrayForInt implements Iterable<Integer> {
    // This is the attributes of the array
    private static final int DEFAULT_CAP = 1 << 3;

    public int[] arr;
    public int lengthOftheArray = 0;
    public int capacityOftheArray = 0;

    // Initialise the array with the default capacity
    public ArrayForInt() {
        this(DEFAULT_CAP);
    }

    // Initialise the array with certain of capacity
    public ArrayForInt(int capacityOftheArray) {
        if (capacityOftheArray < 0)
            throw new IllegalArgumentException("Illgeal Capacity: " + capacityOftheArray);
        this.capacityOftheArray = capacityOftheArray;
        arr = new int[capacityOftheArray];
    }

    // Give an array to make it more dynamic
    public ArrayForInt(int[] array) {
        if (array == null)
            throw new IllegalArgumentException("Array cannot be empty");
        arr = java.util.Arrays.copyOf(array, array.length);
        capacityOftheArray = lengthOftheArray = array.length;
    }

    // return the size of the array
    public int size() {
        return lengthOftheArray;
    }

    // return boolean statement whether the array is empty or not
    public boolean isEmpty() {
        return lengthOftheArray == 0;
    }

    // The get and set method for the array
    // array_obj.arr[index] is used to get 10x the speed
    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int element) {
        arr[index] = element;
    }

    // add an element to this dynamic array

    public void add(int element) {
        if (lengthOftheArray + 1 >= capacityOftheArray) {
            if (capacityOftheArray == 0) {
                capacityOftheArray = 1;// cannot let an array is zero
            } else {
                capacityOftheArray *= 2; // double the size to add the capacity
            }
            arr = java.util.Arrays.copyOf(arr, capacityOftheArray); // pads with extra 0/null element
        }
        arr[lengthOftheArray++] = element;
    }

    // remove the element at the specific index in the list
    // remove and recontruct a new array to displace the old array

    public void removeAt(int remove_index) {
        System.arraycopy(arr, remove_index + 1, arr, remove_index, lengthOftheArray - remove_index - 1);
        --lengthOftheArray;
        --capacityOftheArray;
    }

    // search and remove an element if it is found in the array
    public boolean remove(int element) {
        for (int i = 0; i < lengthOftheArray; i++) {
            if (arr[i] == element) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // reverse the contents of the array
    public void reverse() {
        for (int i = 0; i < lengthOftheArray / 2; i++) { // scan the whole array
            int temporary = arr[i]; // create a temporary array
            arr[i] = arr[lengthOftheArray - i - 1]; // reverse the array
            arr[lengthOftheArray - i - 1] = temporary; // then change back to the array
        }
    }

    // perform binary search on this array that is find the element in O(log(n))
    // time
    // Make sure that this array is sorted first! It will returns the value < 0 if
    // the item is not found

    public int BinarySearch(int key) {
        int index = java.util.Arrays.binarySearch(arr, 0, lengthOftheArray, key);
        // if (index < 0) index = -index - 1; // If not found this will tell you where
        // to insert
        return index;
    }

    // sort this array
    public void sort() {
        java.util.Arrays.sort(arr, 0, lengthOftheArray);
    }

    // Iterator is still quite fast
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < lengthOftheArray;
            }

            public Integer next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // basically change it to string and print it out
    public String toString() {
        if (lengthOftheArray == 0) {
            return "[]"; // if there is no element in the array
        } else {
            StringBuilder sb = new StringBuilder(lengthOftheArray).append("[");
            for (int i = 0; i < lengthOftheArray - 1; i++) {
                sb.append(arr[i] + ", ");
            }
            return sb.append(arr[lengthOftheArray - 1] + "]").toString();
        }

    }

    // Example usage
    public static void main(String[] args) {

        ArrayForInt ar = new ArrayForInt();
        ar.add(3);
        ar.add(7);
        ar.add(6);
        ar.add(-2);

        ar.sort(); // [-2, 3, 6, 7]

        // Prints [-2, 3, 6, 7]
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Prints [-2, 3, 6, 7]
        System.out.println(ar);
    }

}
