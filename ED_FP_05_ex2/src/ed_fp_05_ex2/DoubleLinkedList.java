/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_05_ex2;

import java.util.Iterator;

public class DoubleLinkedList <T> implements ListADT<T>{
    protected DoubleNode<T> head, tail;
    protected int count, oper;

    /**
     * Método construtor
     */
    public DoubleLinkedList() {
        this.count = this.oper = 0;
        this.head = this.tail = null;
    }

    /**
     * Método para remover o primeiro elemento
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            return null;
        }
        
        T first = this.head.getElement();
        this.head = this.head.getNext();
        this.head.setPrevious(null);
        this.count--;
        this.oper++;
        
        return first;
    }

    /**
     * Método para remover o último elemento
     * @return
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            return null;
        }
        
        T last = this.tail.getElement();
        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        this.count--;
        this.oper++;
        
        return last;
    }

    /**
     * Método pare remover um elemento
     * @param element
     * @return
     * @throws EmptyCollectionException
     * @throws ElementDoesntExistException 
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementDoesntExistException {
        if (isEmpty()) {
            throw new ElementDoesntExistException("Element");
        }
        
        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.head;
        
        while(current != null && !found){
            if (element.equals(current.getElement())) {
                found = true;
            }
            
            else{
                previous = current;
                current = current.getNext();
            }
        }
        
        if (!found) {
            return null;
        }
        
        if (size() == 1) {
            this.head = this.tail = null;
        }
        
        else if (current.equals(this.head)) {
            this.head = current.getNext();
        }
        
        else if (current.equals(this.tail)) {
            this.tail = previous;
            this.tail.setNext(null);
        }
        
        else{
            previous.setNext(current.getNext());
        }
        
        this.count--;
        this.oper++;
        
        return current.getElement();
    }

    /**
     * Método para retornar o primeiro elemento
     * @return 
     */
    @Override
    public T first() {
        return this.head.getElement();
    }

    /**
     * Método para retornar o último elemento
     * @return 
     */
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
        
        while(current != null && !found){
            if (target.equals(current.getElement())) {
                return true;
            }
            
            else{
                previous = current;
                current = current.getNext();
            }
        }
        
        return false;
    }

    /**
     * Retorna true se esta lista não contiver elementos
     * @return true is this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    /**
     * Retorna um iterador para os elementos desta lista
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new myItr<>(this.oper);
    }
    
    /**
     * Classe que representa um Iterador
     * @param <T> 
     */
    private class myItr<T> implements Iterator<T>{
        private DoubleNode <T> atual;
        private int expected;
        private boolean can;

        public myItr(int expected) {
            this.atual = (DoubleNode<T>) head;
            this.expected = expected;
            this.can = false;
        }
        
        @Override
        public boolean hasNext() {
            return this.atual.getNext()!= null;
        }

        @Override
        public T next() {
            if (this.expected == oper) {
                this.can = true;
            }
            
            if (this.can == true) {
                this.atual = this.atual.getNext();
                return this.atual.getPrevious().getElement();
            }
            
            return null;
        }
    }
    
    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString(){
        String s = "\n";
        DoubleNode<T> temp = head;
        
        while(temp != null){
            s += (temp.getElement() + "\n");
            temp = temp.getNext();
        }
        
        return s;
    }
}
