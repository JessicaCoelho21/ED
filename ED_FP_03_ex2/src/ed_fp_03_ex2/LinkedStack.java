/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_03_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinkedStack<T> {
    private int size;
    private LinearNode<T> first;

    public LinkedStack() {
        this.size = 0;
        this.first = null;
    }
    
    /**
     * Adds one element to the top of this stack
     * @param element 
     */
    public void push(T element){
        LinearNode<T> newElement = new LinearNode<> (element);
        
        /**
         * Se o primeiro for nulo, fica o novo elemento nessa posição e é incrementado o tamanho da stack
         * Senão, o novo elemento ocupa a posição seguinte, e é incrementado o tamanho da stack
         */
        if(this.first == null){
            this.first = newElement;
            this.size++;
        }
        
        else {
           newElement.setNext(this.first);
           this.first = newElement;
           this.size++;
        }
    }
    
    /**
     * Removes and returns the top element from this stack.
     * @return 
     */
    public T pop(){
        /**
         * Se a stack estiver vazia, retorna null
         */
        if(isEmpty()){
            return null;
        }
            
        /**
         * É obtida a posição do elemento a remover
         * O elemento de first é substituído pelo seguinte
         * O tamanho da stack é decrementado
         */
        T element = this.first.getElement();
        this.first = this.first.getNext();
        this.size--;
        
        return element;
    }
    
    /**
     * Returns without removing the top element of this stack.
     * @return 
     */
    public T peek(){
        /**
         * Se a stack estiver vazia, retorna null
         */
        if(this.isEmpty()){
            return null;
        }
        
        //É retornado o elemento
        return first.getElement();
    }
    
    /** Returns true if this stack contains no elements.
     * @return boolean whether or not this stack is empty
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /** Returns the number of elements in this stack.
     * @return int number of elements in this stack
     */
    public int size(){
        return size;
    }

    /** Returns a string representation of this stack.
     * @return String representation of this stack
     */
    @Override
    public String toString() {
        String str = "";
        LinearNode<T> c = this.first;
        
        for(int i = 0; i < this.size; i++){
            str = str + c.getElement() + " ";
            c = c.getNext();
        }
        
        return str + "";
    }
}
