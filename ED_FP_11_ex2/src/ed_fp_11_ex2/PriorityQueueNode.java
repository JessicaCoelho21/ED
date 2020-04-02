/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_11_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode> {

    private static int nextorder = 0;
    private int priority;
    private int order;
    private T element;

    /**
     * Cria um novo PriorityQueueNode com os dados especificados.
     *
     * @param obj o elemento do novo nó da fila de prioridade
     * @param prio a prioridade inteira do novo nó da fila
     */
    public PriorityQueueNode(T obj, int prio) {
        this.element = obj;
        this.priority = prio;
        this.order = this.nextorder;
        this.nextorder++;
    }

    /**
     * Retorna o elemento neste nó.
     *
     * @return o elemento contido neste nó
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Retorna o valor da prioridade para este nó.
     *
     * @return a prioridade inteira para este nó
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Retorna a ordem para este nó.
     *
     * @return a ordem inteira para este nó
     */
    public int getOrder() {
        return this.order;
    }

    /**
     * Retorna uma representação de sequência para este nó.
     *
     * @return 
     */
    @Override
    public String toString() {
        String temp = (this.element.toString());
        
        return temp;
    }

    /**
     * Retorna 1 se o nó atual tiver prioridade mais alta que o nó especificado
     * e -1 caso contrário.
     *
     * @param obj o nó para comparar com este nó
     * @return o resultado inteiro da comparação do nó obj e este
     */
    @Override
    public int compareTo(PriorityQueueNode obj) {
        int result;
        PriorityQueueNode<T> temp = obj;
        
        if (this.priority > temp.getPriority()) {
            result = 1;
        } 
        
        else if (this.priority < temp.getPriority()) {
            result = -1;
        } 
        
        else if (this.order > temp.getOrder()) {
            result = 1;
        } 
        
        else {
            result = -1;
        }
        
        return result;
    }
}
