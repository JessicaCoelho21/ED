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
public class LinearNode<T> {
    /**
     * reference to next node in list
     */
    private LinearNode<T> next;
    
    /**
     * Element stored at this node
     */
    private T element;
    
    /**
     * Creates an empty node
     */
    public LinearNode(){
        next = null;
        element = null;
    }
    
    /**
     * Creates a node storing the specified element
     * @param elem element to be stored
     */
    public LinearNode(T elem){
        next = null;
        element = null;
    }

    /**
     * Returns the node that follows this one
     * @return LinearNode<T> reference to next node
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one
     * @param node node to follow this one 
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Returns the element stored in this node
     * @return T element stored at this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node
     * @param element element to be stored at this node
     */
    public void setElement(T element) {
        this.element = element;
    }
}
