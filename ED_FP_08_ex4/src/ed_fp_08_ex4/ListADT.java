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
public interface ListADT<T> extends Iterable<T>{
    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return the first element from this list
     */
    public T removeFirst();

    /**
     * Remove e retorna o último elemento desta lista.
     * @return the last element from this list
     */
    public T removeLast();

    /**
     * Remove e retorna o elemento especificado dessa lista.
     * @param element the element to be removed from the list
     * @return 
     */
    public T remove(T element);

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     * @return a reference to the first element in this list
     */
    public T first();

    /**
     * Retorna uma referência ao último elemento nesta lista.
     *
     * @return a reference to the last element in this list
     */
    public T last();

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target);

    /**
     * Retorna true se esta lista não contiver elementos.
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta lista.
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Retorna uma representação de sequência desta lista.
     * @return a string representation of this list
     */
    @Override
    public String toString();
    
    public String print();
}
