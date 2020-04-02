/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_08_ex4;

import java.util.Iterator;

/**
 *
 * @author Jéssica Beatriz
 */
public class DoubleLinkedList <T> implements ListADT<T>{
    protected LinearNode<T> front;
    protected LinearNode<T> rear;
    protected int count;
    protected int n_oper;
    
    /**
     * Método construtor
     */
    public DoubleLinkedList() {
        this.front = null;
        this.rear = null;
        this.count = 0;
        this.n_oper = 0;
    }

    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return o elemento removido
     */
    @Override
    public T removeFirst() {
        //se estiver vazio, retorna null
        if (isEmpty()) {
            return null;
        }
        
        //obtem o valor do primeiro node
        T first = this.front.getValue();
        //a primeira posição toma o valor da segunte
        this.front = this.front.getNext();
        this.front.setPrevious(null);
        this.count--;
        this.n_oper++;
        
        return first;
    }

    /**
     * Remove e retorna o último elemento desta lista.
     * @return o elemento removido
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T last = this.rear.getValue();
        this.rear = this.rear.getPrevious();
        this.rear.setNext(null);
        this.count--;
        this.n_oper++;
        
        return last;
    }

    /**
     * Remove e retorna o elemento especificado dessa lista.
     * @param element elemento a ser removido
     * @return elemento removido
     */
    @Override
    public T remove(T element) {
        if (isEmpty()) {
            return null;
        }

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = this.front;

        while (current != null && !found) {
            if (element.equals(current.getValue())) {
                found = true;
            }
            
            else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            return null;
        }

        if (size() == 1) {
            this.front = this.rear = null;
        } 
        
        else if (current.equals(this.front)) {
            this.front = current.getNext();
        }
        
        else if (current.equals(this.rear)) {
            this.rear = previous;
            this.rear.setNext(null);
        }
        
        else {
            previous.setNext(current.getNext());
        }

        this.count--;
        this.n_oper++;
        
        return current.getValue();
    }

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     * @return primeiro elemento
     */
    @Override
    public T first() {
        return this.front.getValue();
    }

    /**
     * Retorna uma referência ao último elemento nesta lista.
     * @return último elemento
     */
    @Override
    public T last() {
        return this.rear.getValue();
    }

    /**
     * Retorna true se esta lista contiver o elemento de destino especificado.
     * @param target
     * @return 
     */
    @Override
    public boolean contains(T target) {
        if (isEmpty()) {
            return false;
        }

        boolean found = false;
        LinearNode<T> previous = null;
        LinearNode<T> current = this.front;

        while (current != null && !found) {
            if (target.equals(current.getValue())) {
                return true;
            } 
            
            else {
                previous = current;
                current = current.getNext();
            }
        }

        return false;
    }

    /**
     * Verifica se o array está vazio
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Verifica o tamanho do array
     * @return 
     */
    @Override
    public int size() {
        return this.count;
    }
    
    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString(){
        String s = "List:";
        LinearNode<T> c = this.front;
        
        for(int i = 0; i < this.size(); i++){
           s += c.getValue();
           c = c.getNext();     
       }
       
       return s;
    }

    /**
     * Método Iterator
     * @return 
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedIterator<>(this.n_oper);
    }
    
    @Override
    public String print() {
        //return this.printRecursivo(this.front);
        return this.printReverse(this.rear);
    }
    
    /**
     * Criação da classe DoubleLinkedIterator
     * @param <T> 
     */
    private class DoubleLinkedIterator<T> implements Iterator<T>{
        private LinearNode<T> actual;
        private int expected;
        private boolean can;

        public DoubleLinkedIterator(int expected) {
            this.actual = (LinearNode<T>) front;
            this.expected = expected;
            this.can = false;
        }

        @Override
        public boolean hasNext() {
            return(this.actual.getNext() != null);
        }

        @Override
        public T next() {
            if(this.expected == n_oper){
                this.can = true;
            }
            
            if(this.can == true){
                this.actual = this.actual.getNext();
                return this.actual.getPrevious().getValue();
            }
            
            return null;
        }

    }

     private String printRecursivo(LinearNode<T> n){
        String lista = "";

        if(n == null){
            return lista;
        }
        
        else{
            lista = n.getValue() + printRecursivo(n.getNext());
        }
        
        return lista;
    }

     private String printReverse(LinearNode<T> n){
        String lista = "";

        if(n == null){
            return lista;
        }
        
        else{
            lista = " " + n.getValue() + printReverse(n.getPrevious());
        }
        
        return lista;
    }
}
