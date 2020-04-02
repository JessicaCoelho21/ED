/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Jéssica Beatriz
 */
public class ArrayList<T> implements ListADT<T>{
    /**
     * Array de elementos genéricos para representar o ArrayList
     */
    protected T[] array;

    /**
     * int que representa a próxima posição disponível no ArrayList
     */
    protected int rear;

    /**
     * constante para representar a capacidade default do ArrayList
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Cria uma lista vazia usando a capacidade especificada
     *
     * @param tam
     */
    public ArrayList(int tam) {
        this.array = (T[]) (new Object[tam]);
        this.rear = 0;
    }

    /**
     * Cria uma lista vazia usando a capacidade padrão(default).
     */
    public ArrayList() {
        this.array = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    /**
     * Remove e retorna o primeiro elemento desta lista.
     *
     * @return the first element from this list
     */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        
        T temp = this.first();
        
        for (int i = 0; i < this.rear; i++) {
            this.array[i] = this.array[i + 1];
        }
        
        this.array[this.rear] = null;
        this.rear--;
        
        return temp;
    }

    /**
     * Remove e retorna o último elemento desta lista.
     *
     * @return the last element from this list
     */
    @Override
    public T removeLast() {
        if (this.rear == 0) {
            try {
                throw new EmptyCollectionException();
            } 
            
            catch (EmptyCollectionException ex) {
                ex.getMessage();
            }
        }
        
        T k = this.last();
        this.array[rear - 1] = null;
        this.rear--;
        
        return k;
    }

    /**
     * Remove e retorna o elemento especificado dessa lista.
     *
     * @param element the element to be removed from the list
     * @return the removed element
     */
    @Override
    public T remove(T element) {
        if (!this.contains(element)) {
            return null;
        }
        
        int i;
        
        for (i = 0; i < this.rear; i++) {
            if (element.equals(this.array[i])) {
                break;
            }
        }
        
        T temp = this.array[i];

        for (; i < this.rear; i++) {
            this.array[i] = this.array[i + 1];
        }
        
        this.array[i] = null;
        this.rear--;
        
        return temp;
    }

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() {
        return this.array[0];
    }

    /**
     * Retorna uma referência ao último elemento nesta lista.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() {
        return this.array[rear - 1];
    }

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        for (T o : this.array) {
            if (target.equals(o)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Retornará true se esta lista não contiver elementos.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }

    /**
     * Retorna o número de elementos nesta lista.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Retorna um iterador para os elementos nesta lista.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator iterator() {
        return new MeuIterador();
    }

    /**
     * Class that represents a Iterator
     */
    private class MeuIterador implements Iterator<T> {

        private final int expectedModCount;
        private boolean okToRemove;

        /**
         * int that represents the position of the iterator
         */
        int cursor = 0;

        /**
         * Creates an Iterator.
         *
         */
        MeuIterador() {
            this.expectedModCount = size();
            okToRemove = false;
        }

        /**
         * Verifies if there is a element next to the current
         *
         * @return true if the element exists
         */
        @Override
        public boolean hasNext() {
            if (this.expectedModCount != size()) {
                throw new ConcurrentModificationException("Lista incompativel!");
            }

            return cursor != size();
        }

        /**
         * Moves the iterator to the next position.
         *
         * @return the previous position the cursor was
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            okToRemove = true;

            return array[cursor++];
        }
    }
}
