/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_05_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class DoubleNode<T> {
    private T element;
    private DoubleNode <T> next, previous;

    /**
     * Método construtor
     */
    public DoubleNode() {
        this.element = null;
        this.next = this.previous = null;
    }

    /**
     * Método construtor dado um elemento
     * @param element elemento do novo nó
     */
    public DoubleNode(T element) {
        this.element = element;
        this.next = this.previous = null;
    }

    /**
     * Método getter para obter o elemento
     * @return elemento
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Método setter para atribuir um elemento
     * @param element 
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Método getter para obter o elemento seguinte ao atual
     * @return elemento seguinte
     */
    public DoubleNode<T> getNext() {
        return this.next;
    }

    /**
     * Método setter para atribuir um elemento a seguir ao atual
     * @param next elemento a seguir ao atual
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Método getter para obter o elemento anterior ao atual
     * @return elemento anterior
     */
    public DoubleNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Método setter para atrivuir um elemento antes do atual
     * @param previous elemento anterior ao atual
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
