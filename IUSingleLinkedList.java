import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Single-linked node implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported.
 * 
 * @author Morgan Zabriskie
 * 
 * @param <T> type to store
 */
public class IUSingleLinkedList<T> implements IndexedUnsortedList<T> {
    private Node<T> head, tail;
    private int size;
    private int modCount;

    /** TODO: make java doc
     * Creates an empty list */
    public IUSingleLinkedList() {
        head = tail = null;
        size = 0;
        modCount = 0;
    }

    @Override
    public void addToFront(T element) {
        if (size == 0) {
            Node<T> newNode = new Node<T>(element);
            head = newNode;
            tail = newNode;
            size++;
            modCount++;
        } else {
            Node<T> newNode = new Node<T>(element);
            newNode.setNext(head);
            head = newNode;
            size++;
            modCount++;
        }

    }

    @Override
    public void addToRear(T element) {
        // TODO

    }

    @Override
    public void add(T element) {
        // TODO

    }

    @Override
    public void addAfter(T element, T target) {
        // TODO

    }

    @Override
    public void add(int index, T element) {
        // TODO

    }

    @Override
    public T removeFirst() {
        // TODO
        return null;
    }

    @Override
    public T removeLast() {
        // TODO
        return null;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        boolean found = false;
        Node<T> previous = null;
        Node<T> current = head;

        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new NoSuchElementException();
        }

        if (size() == 1) { // only node
            head = tail = null;
        } else if (current == head) { // first node
            head = current.getNext();
        } else if (current == tail) { // last node
            tail = previous;
            tail.setNext(null);
        } else { // somewhere in the middle
            previous.setNext(current.getNext());
        }

        size--;
        modCount++;

        return current.getElement();
    }

    @Override
    public T remove(int index) {
        // TODO
        return null;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) { // if index is head
            head.setElement(element);
        } else if (index == (size - 1)) { // if index is tail
            tail.setElement(element);
        } else {
            Node<T> currNode = null;
            currNode = head.getNext();
            int nodeIndex = 1;
            while(nodeIndex != index) {
                currNode = currNode.getNext();
                nodeIndex++;
            }
            currNode.setElement(element);
        }
    }

    @Override
    public T get(int index) {
        T element;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) { // if index is head
            element = head.getElement();
        } else if (index == (size - 1)) { // if index is tail
            element = tail.getElement();
        } else {
            Node<T> currNode = null;
            currNode = head.getNext();
            int nodeIndex = 1;
            while(nodeIndex != index) {
                currNode = currNode.getNext();
                nodeIndex++;
            }
            element = currNode.getElement();
        }
        return element;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        Node<T> currNode = head;
        for(int i = 0; i < size; i++) {
            if (currNode.getElement().equals(element)) {
                index = i;
                break;
            }
            currNode = currNode.getNext();
        }
        if(index == -1) {
            throw new NoSuchElementException();
        } else {
            return index;
        }
    }

    @Override
    public T first() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }

    @Override
    public T last() {
        // TODO
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return tail.getElement();
        }
    }

    @Override
    public boolean contains(T target) {
        boolean targetExists = false;
        Node<T> currNode = head;
        for (int i = 0; i < size; i++) {
            if (currNode.getElement() == target) {
                targetExists = true;
                break;
            }
            currNode = currNode.getNext();
        }
        return targetExists;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new SLLIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int startingIndex) {
        throw new UnsupportedOperationException();
    }

    /** Iterator for IUSingleLinkedList */
    private class SLLIterator implements Iterator<T> {
        private Node<T> nextNode;
        private int iterModCount;

        /** Creates a new iterator for the list */
        public SLLIterator() {
            nextNode = head;
            iterModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            // TODO
            return false;
        }

        @Override
        public T next() {
            // TODO
            return null;
        }

        @Override
        public void remove() {
            // TODO
        }
    }
}