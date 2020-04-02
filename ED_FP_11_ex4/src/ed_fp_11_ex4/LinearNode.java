/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_11_ex4;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinearNode<T> {
    /**
     * Referência ao próximo nó na lista
     */
    private LinearNode<T> next;
    /**
     * Elemento armazenado neste nó
     */
    private T element;

    /**
     * Cria um nó vazio.
     */
    public LinearNode() {
        next = null;
        element = null;
    }

    /**
     * Cria um nó que armazena o elemento especificado.
     *
     * @param elem elemento a ser armazenado
     */
    public LinearNode(T elem) {
        next = null;
        element = elem;
    }

    /**
     * Retorna o nó que segue este.
     *
     * @return LinearNode<T> referência ao próximo nó
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Define o nó que segue este.
     *
     * @param node nó para seguir este
     */
    public void setNext(LinearNode<T> node) {
        next = node;
    }

    /**
     * Retorna o elemento armazenado neste nó.
     *
     * @return T elemento armazenado neste nó
     */
    public T getElement() {
        return element;
    }

    /**
     * Define o elemento armazenado neste nó
     *
     * @param elem elemento a ser armazenado neste nó
     */
    public void setElement(T elem) {
        element = elem;
    }
}
