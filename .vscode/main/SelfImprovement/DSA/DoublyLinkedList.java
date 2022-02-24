import java.util.*;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

//it is a linked list that able to traverse forward and backwards within the nodes
public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0; // size of the linked list
    private Node<T> firstNode = null; // the first Node of the linked list
    private Node<T> lastNode = null; // the last Node of the linked list

    // initialise the node
    private static class Node<T> {
        private T data; // data within the node
        private Node<T> previousNode, nextNode;

        // constructor
        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

        @Override
        // return everything to string
        public String toString() {
            return data.toString();
        }

    }

    // function to clear the node(element) inside the Doubly linked list
    public void clear() {
        Node<T> traverse = firstNode; // this Node(object ) specifically to traverse
        while (traverse != null) { // while loop to move from each node and vise versa
            Node<T> nextNode = traverse.nextNode;
            traverse.previousNode = traverse.nextNode = null;
            traverse.data = null;
            traverse = nextNode;
        }
        firstNode = lastNode = traverse = null;
        size = 0;
    }

    // return the size of the linked list
    public int size() {
        return size;
    }

    // to check is the linked list empty or not
    public boolean isEmpty() {
        return size() == 0;
    }

    // Add an element to the tail of the linked list,O(1)
    public void add(T elem) {
        addLast(elem);
    }

    // add an elemt to the tail of the linked list ,O(1)
    public void addLast(T elem) {
        if (isEmpty()) { // if whole linked list is enpty then the first node is equals to the last node
            firstNode = lastNode = new Node<T>(elem, null, null); // because it only has one node
        } else {
            lastNode.nextNode = new Node<T>(elem, lastNode, null); // else it will add a node behind every single node ,
                                                                   // which the previous node is the last node and the
                                                                   // next node is null
            lastNode = lastNode.nextNode; // then it will goes to the last node
        }
        size++; // then increase the size because your alr add one node
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            firstNode = lastNode = new Node<T>(elem, null, null);
        } else {
            firstNode.previousNode = new Node<T>(elem, null, firstNode);
            firstNode = firstNode.previousNode;
        }
        size++; // increase the size because you alr add one node
    }

    // function to check the data of the first node , O(1)
    public T peekFirstNode() {
        if (isEmpty()) { // if the firstNode is empty means linked list is not formed in the first place
            throw new RuntimeException("This is a empty list");
        } else {
            return firstNode.data; // else just return the data of the first node
        }
    }

    // function to check the data of the last node, O(1)
    public T peekLastNode() {
        if (isEmpty()) { // if the lastNode is empty means linked list is not formed in the first place
            throw new RuntimeException("This is a empty list");
        } else {
            return lastNode.data; // else just return the data of the last node
        }
    }

    // function to remove the FirstNode and push all the behind node to the front
    public T removeFirstNode() {
        if (isEmpty()) { // if the lastNode is empty means linked list is not formed in the first place
            throw new RuntimeException("This is a empty list"); // cannot remove data from an empty list
        }
        // if there is a linked list then
        T data = firstNode.data; // it extract the data at the firstNode
        firstNode = firstNode.nextNode; // then all the node move front and remove the firstNode
        --size; // then reduce the size by 1

        // After it remove
        if (isEmpty()) { // if the list is empty set the lastNode is null
            lastNode = null;
        } else { // Do a memory cleanup of the previousNode
            firstNode.previousNode = null;
        }
        return data; // return the data that was the firstNode we just remove

    }

    // function to remove the lastNode
    public T removeLastNode() {
        if (isEmpty()) {
            throw new RuntimeException("This is a empty list");
        }
        T data = lastNode.data; // extract the data of the lastNode
        lastNode = lastNode.previousNode; // then all the node move backwards and remove the lastNode
        --size; // reduce the size by 1

        // After it remove
        if (isEmpty()) { // if the list is empty size then the firstNode is null
            firstNode = null;
        } else {
            lastNode.nextNode = null;
        }
        return data;
    }

    public T remove(Node<T> node) {
        if (node.previousNode == null) {
            return removeFirstNode();
        } else if (node.nextNode == null) {
            return removeLastNode();
        }

        T data = node.data;
        node.data = null;
        node = node.previousNode = node.nextNode = null;

        --size; // reduce the size by 1

        return data;
    }

    public T removeAt(int index) {
        // Make sure the index provided is valid
        if (index < 0 || index >= size) { // if the index given is less than 0 and more than the size of the linked list
            throw new IllegalArgumentException(); // because the index given is not valid
        }
        int i;
        Node<T> traverseNode;

        // Search from the front of the list
        if (index < size / 2) {
            for (i = 0, traverseNode = firstNode; i != index; i++) {
                traverseNode = traverseNode.nextNode;
            }
        } else {
            for (i = size - 1, traverseNode = lastNode; i != index; i--) {
                traverseNode = traverseNode.previousNode;
            }
        }
        return remove(traverseNode);
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node<T> traverseNode = firstNode;

        // Support searching for null
        if (obj == null) {
            for (traverseNode = firstNode; traverseNode != null; traverseNode = traverseNode.nextNode) {
                if (traverseNode.data == null) {
                    remove(traverseNode);
                    return true;
                }
            }
        } else {
            for (traverseNode = firstNode; traverseNode != null; traverseNode = traverseNode.nextNode) {
                if (obj.equals(traverseNode.data)) {
                    remove(traverseNode);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particluar value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> traverseNode = firstNode;

        // support searching for null
        if (obj == null) {
            for (; traverseNode != null; traverseNode = traverseNode.nextNode, index++) {
                if (traverseNode.data == null) {
                    return index;
                }
            }
            // Search for non null object
        } else {
            for (; traverseNode != null; traverseNode = traverseNode.nextNode, index++) {
                if (obj.equals(traverseNode.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new java.util.Iterator<T>() {
            private Node<T> traverseNode = firstNode;

            public boolean hasNext() {
                return traverseNode != null;
            }

            public T next() {
                T data = traverseNode.data;
                traverseNode = traverseNode.nextNode;
                return data;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> traversNode = firstNode;
        while (traversNode != null) {
            sb.append(traversNode.data + ", ");
            traversNode = traversNode.nextNode;
        }
        sb.append(" ]");
        return sb.toString();
    }

}
