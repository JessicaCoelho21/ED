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
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;
    
    /**
     * Método construtor
     */
    public LinkedList(){
        this.head = this.tail = null;
        this.count = 0;
    }

    /**
     * Método para obter o primeiro elemento da lista
     * @return 
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Método para obter o número de elementos da lista
     * @return 
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Método de lista vazia
     * @return 
     */
    private boolean isEmpty(){
        return (this.count == 0);
    }
    
    /**
     * Método para adicionar na cabeça da lista
     * @param element 
     */
    public void addHead(T element){
        Node<T> newNode = new Node<>(element);
        
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        
        else{
            //newNode vai ser atribuído à referência de head
            newNode.setNext(this.head);
            //newNode passa a primeiro elemento da lista
            this.head = newNode;
        }
        
        this.count++;
    }
    
    /**
     * Método para adicionar um elemento à lista
     * @param element 
     */
    public void add(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
        }
        
        else{
            //é criado um nó auxiliar com o valor de head
            Node<T> current = this.head;
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        
        this.count++;
    }
    
    /**
     * Método que remove o elemento armazenado no último nó da lista
     */
    public void removeLast(){
        if (isEmpty()) {
            return;
        }
        
        else{
            Node<T> current = this.head;
            Node<T> nodeAux = null;
            
            while(current.getNext() != null){
                nodeAux = current;
                current = nodeAux.getNext();
            }
            
            nodeAux.setNext(null);
            this.tail = nodeAux;
            this.count--;
        }
    }
    
    
}
