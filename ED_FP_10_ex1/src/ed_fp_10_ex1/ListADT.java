/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

import java.util.Iterator;

/**
 *
 * @author Jéssica Beatriz
 */
public interface ListADT<T> extends Iterable<T> {
    /**
     * Remove e retorna o primeiro elemento desta lista.
     *
     * @return o primeiro elemento desta lista
     * @throws ed_09_exercicio1.EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;

    /**
     * Remove e retorna o último elemento desta lista.
     *
     * @return o último elemento desta lista
     * @throws ed_09_exercicio1.EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;

    /**
     * Remove e retorna o elemento especificado dessa lista.
     *
     * @param element o elemento a ser removido da lista
     * @return
     * @throws ed_09_exercicio1.EmptyCollectionException
     * @throws ed_09_exercicio1.ElementoNaoExisteException
     */

    public T remove(T element) throws EmptyCollectionException, ElementDoesntExistException;

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     *
     * @return uma referência ao primeiro elemento nesta lista
     * @throws ed_09_exercicio1.EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

    /**
     * Retorna uma referência ao último elemento nesta lista.
     *
     * @return uma referência ao último elemento nesta lista
     * @throws ed_09_exercicio1.EmptyCollectionException
     */
    public T last() throws EmptyCollectionException;

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     *
     * @param target o target que está sendo procurado na lista
     * @return true se a lista contiver esse elemento
     */
    public boolean contains(T target);

    /**
     * Retornará true se esta lista não contiver elementos.
     *
     * @return true se esta lista não contiver elementos
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta lista.
     *
     * @return a representação inteira do número de elementos nesta lista
     */
    public int size();

    /**
     * Retorna um iterador para os elementos nesta lista.
     *
     * @return um iterador sobre os elementos nesta lista
     */
    @Override
    public Iterator<T> iterator();

    /**
     * Retorna uma representação de sequência desta lista.
     *
     * @return uma representação em cadeia desta lista
     */
    @Override
    public String toString();
}

