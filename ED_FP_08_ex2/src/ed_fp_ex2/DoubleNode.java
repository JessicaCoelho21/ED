/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class DoubleNode<T> {
    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;
    
    /**
     * Creates an empty node
     */
    public DoubleNode(){
        this.next = this.previous = null;
        this.element = null;
    }

    /**
     * Returns the node that follows this one
     * @return the node that follows the current one
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one
     * @param next the node to be set as the one tho follow the current one
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the element stored in this node
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node
     * @param element the element to be stored in this node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the node that precedes this one
     * @return the node that precedes the current one
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
     * Sets the node that precedes this one
     * @param previous the node to be set as the one to precede the current one
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
