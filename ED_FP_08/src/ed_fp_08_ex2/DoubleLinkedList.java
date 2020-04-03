package ed_fp_08_ex2;

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

    /**
     * Método para obter a head a lista ligada
     * @return 
     */
    public DoubleNode<T> getHead() {
        return head;
    }
    
    /**
     * Removes and returns the first element from this list.
     * @return the first element from this list
     */
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

    /**
     * Removes and returns the last element from this list.
     * @return the last element from this list
     */
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

    /**
     * Removes and returns the specified element from this list.
     * @param element the element to be removed from the list
     * @return
     */
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

    /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return this.head.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return this.tail.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
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

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Returns the number of elements in this list
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
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
    
    private String printRecursivo(DoubleNode<T> n){
        String lista="";
        
        if(n == null){
            return lista;
        } else{
            lista = n.getElement() + printRecursivo(n.getNext());
        }
        
        return lista;
    }
     
     private String printReverse(DoubleNode<T> n){
        String lista="";
        
        if(n==null){
            return lista;
        }
        else{
            lista = " " + n.getElement() + printReverse(n.getPrevious());
        }
        
        return lista;
    }
     
     /**
      * Método para print 
      * @return 
      */
     public String print(){
         //return this.printRecursivo(this.head);
         return this.printReverse(this.tail);
     }
}
