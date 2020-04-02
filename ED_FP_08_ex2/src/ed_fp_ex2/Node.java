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
public class Node<T> {
    public Node<T> next;
    public T element;
    
    /**
     * Método construtor
     * @param element 
     */
    public Node(T element){
        this.next = null;
        this.element = element;
    }

    /**
     * Método para obter o nó seguinte
     * @return 
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Método para atribuir um nó seguinte
     * @param next 
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Método para obter o elemento a armazenar no nó
     * @return 
     */
    public T getElement() {
        return element;
    }
}
