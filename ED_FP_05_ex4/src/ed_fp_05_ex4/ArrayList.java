package ed_fp_05_ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListADT<T>{
    
    protected int rear;
    protected T[] list;
    protected final int DEFAULT = 5;

    /**
     * Método construtor que define um array com um tamanho por defeito
     */
    public ArrayList() {
        this.rear = 0;
        this.list = (T[])(new Object[DEFAULT]);
    }
    
    /**
     * Método construtor que define um arrau com um dado tamanho
     * @param tam tamanho do array
     */
    public ArrayList(int tam){
        this.rear = 0;
        this.list = (T[])(new Object[tam]);
    }
    
    /*
    public void add(T element){
        if (this.rear == this.list.length) {
            this.expandCapacity();
            this.list[this.rear] = element;
            this.rear++;
            this.size++;
        }
        
        else{
            this.list[this.rear] = element;
            this.rear++;
            this.size++;
        }
    }
    */
    
    /**
     * Método para aumentar tamanho do array
     */
    public void expandCapacity(){
        T[] expandedList = (T[]) (new Object[this.DEFAULT * 2]);

        for(int i = 0; i < this.size(); i++) {
            expandedList[i] = this.list[i];
        }
        
        this.list = expandedList;
    }
    
    /**
     * Encontrar o elemento num array
     * @param element
     * @return 
     */
    public int find (T element){
        for (int i = 0; i < this.rear; i++) {
            if (this.list[i].equals(element)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Removes and returns the first element from this list
     * @return the first element from this list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException{
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        
        else{
            T removed = this.list[0];

            for (int i = 0; i < this.list.length - 1; i++) {
                this.list[i] = this.list[i + 1];
            }

            this.list[this.rear - 1] = null;
            this.rear--;
            return removed;
        }
    }

    /**
     * Removes and returns the last element from this list
     * @return the last element from this list
     * @throws ed_fp_05_ex4.EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException{
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        
        else{
            T removed = this.list[this.rear];
            this.list[this.rear] = null;
            this.rear--;
            return removed;
        }
    }

    /**
     * Removes and returns the specified element from this list
     * @param element the element to be removed from the list
     * @return 
     * @throws ed_fp_05_ex4.EmptyCollectionException 
     * @throws ed_fp_05_ex4.ElementDoesntExistException 
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementDoesntExistException{
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        
        if (this.contains(element)) {
            int pos = this.find(element);
            T removed = this.list[this.find(element)];
            
            for (int i = pos; i < this.rear - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
            
            this.list[this.rear - 1] = null;
            this.rear--;
            return removed;
        }
        
        else{
            throw new ElementDoesntExistException("Elemento não existe");
        }
    }
    
    /**
      * Returns a reference to the first element in this list
      * @return a reference to the first element on this list
      */
    @Override
    public T first() {
        return this.list[0];
    }

    /**
     * Returns a reference to the last element in this list
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return this.list[this.rear - 1];
    }

    /**
     * Returns true if this list contains the specified target element
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        for (int i = 0; i < this.rear && this.list != null; i++) {
            if(this.list[i].equals(target)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }

    /**
     * Returns the number of elements in this list.
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator iterator() {
        return new MyItr();
    }
    
    /**
     * Returns a string representation of this list.
     * @return a string representation of this list      
     */
    @Override
    public String toString(){
        /*
        String s = "";
        
        for (int i = 0; i < this.rear; i++) {
            s += this.list[i].toString() + " ";
        }
        
        return s;
        */
        StringBuilder str = new StringBuilder();
        if (!this.isEmpty()) {
            str.append("Primeiro elemento: ");
            str.append(this.list[0]);
            str.append("\n");
            str.append("Ultimo elemento: ");
            str.append(this.list[this.rear - 1]);
            str.append("\n");
        }
        
        str.append("Nº elementos: ");
        str.append(this.rear);
        str.append("\n");
        str.append("Tamanho da lista: ");
        str.append(this.list.length);
        str.append("\n");

        for (int i = 0; i < this.size(); i++) {
            str.append(this.list[i]);
            str.append("\n");
        }
        
        return str.toString();
    }

    /**
     * Class that represents an Iterator
     * @param <T> 
     */
    public class MyItr<T> implements Iterator<T>{
        //representa a posição do iterador
        private int cursor = 0;

        /**
         * Método construtor
         */
        public MyItr() {
        }

        /**
         * Método que verifica se há um elemento a seguir ao elemento atual
         * @return true se o elemento existir
         */
        @Override
        public boolean hasNext(){
            return (this.cursor != size());
        }

        /**
         * Método que move o iterador para a próxima posição
         * @return o elemento anterior onde o cursor estava
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (T) list[this.cursor++];
        }
    }
}
