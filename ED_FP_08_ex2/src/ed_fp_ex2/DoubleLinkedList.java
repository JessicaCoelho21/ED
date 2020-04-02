/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_ex2;

import java.util.Iterator;

/**
 *
 * @author Jéssica Beatriz
 */
public class DoubleLinkedList<T> implements ListADT<T>{
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;
    protected int count, operations;
    
    /**
     * Método cosntrutor
     */
    public DoubleLinkedList(){
        this.head = this.tail = null;
        this.count = this.operations = 0;
    }
    
    public DoubleNode<T> getHead(){
        return this.head;
    }

    /**
     * Método para remover o primeiro elemento da lista
     * @return 
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
        this.operations++;
        return first;
    }

    /**
     * Método para remover o último elemento
     * @return 
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
        this.operations++;
        return last;
    }

    /**
     * Método para remover um elemento da lista
     * @param element
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
        
        while(current != null && !found){
            if (element.equals(current.getElement())){
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
        
        else if (current.equals(this.tail)){
            this.tail = previous;
            this.tail.setNext(null);
        }
        
        else {
            previous.setNext(current.getNext());
        }
        
        this.count--;
        this.operations++;
        return current.getElement();
    }

    /**
     * Método para retornar o primeiro elemento da lista
     * @return 
     */
    @Override
    public T first() {
        return this.head.getElement();
    }

    /**
     * Método para retornar o último elemento da lista
     * @return 
     */
    @Override
    public T last() {
        return this.tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
