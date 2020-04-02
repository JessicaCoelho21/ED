package ed_fp_05_ex5;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;
    protected int count;
    protected int n_oper;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
        this.n_oper = 0;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = this.head.getElement();
        this.head = this.head.getNext();
        this.head.setPrevious(null);
        this.count--;
        this.n_oper++;
        return first;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T last = this.tail.getElement();
        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        this.count--;
        this.n_oper++;
        return last;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            return null;
        }

        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.head;

        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            return null;
        }

        if (size() == 1) {
            this.head = this.tail = null;
        } else if (current.equals(this.head)) {
            this.head = current.getNext();
        } else if (current.equals(this.tail)) {
            this.tail = previous;
            this.tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }

        this.count--;
        this.n_oper++;
        
        return current.getElement();
    }

    @Override
    public T first() {
        return this.head.getElement();
    }

    @Override
    public T last() {
        return this.tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        if (isEmpty()) {
            return false;
        }

        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.head;

        while (current != null && !found) {
            if (target.equals(current.getElement())) {
                return true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        return false;

    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedIterator<>(this.n_oper);
    }

    private class DoubleLinkedIterator<T> implements Iterator<T> {

        private DoubleNode<T> actual;
        private int expected;
        private boolean can;

        public DoubleLinkedIterator(int expected) {
            this.actual = (DoubleNode<T>) head;
            this.expected = expected;
            this.can = false;
        }

        @Override
        public boolean hasNext() {
            return (this.actual.getNext() != null);
        }

        @Override
        public T next() {
            if (this.expected == n_oper) {
                this.can = true;
            }
            if (this.can == true) {
                this.actual = this.actual.getNext();
                
                return this.actual.getPrevious().getElement();
            }
            
            return null;
        }
    }
}
