/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_08_ex2;

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
    
    /**
     * Método para remover o primeiro elemento da lista
     */
    public void removeFirst(){  
        if (isEmpty()) { 
            return;
        } else {
            this.head = this.head.getNext(); //remove o nó a cabeça
            this.count--; 
        }
    }
    
     /**
    * Método que remove o primeiro elemento igual ao valor pretendido 
    */
    public void remove(T value) {
        if (isEmpty()) {
            return; 
        } else {
            Node<T> current = this.head.getNext(); //current aponta para o seguinte
            Node<T> anterior = this.head; //current aponta para o anterior
            
            while (current != null) {
                if (value.equals(current.getElement())) {
                    anterior.setNext(current.getNext());
                }
                
                anterior = current;
                current = current.getNext();
            }
        }
        
        this.count--;
    }
    
    /**
     * Retorna o número de elementos nesta lista.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size() {
        return this.count;
    }
    
    /**
     * Método para imprimir a lista
     */
    public void print() {
        Node<T> current = this.head; 
        
        while (current != null) { //enquanto o current for diferent de null
            System.out.println(current.getElement().toString()); //print o elemento
            current = current.getNext(); // print o elemento e os seguintes
        }

        System.out.println(this.count); //conta o numero de elementos
        
        if (this.head != null) { // se o head for diferente de null
            System.out.println("head: " +this.head.getElement().toString()); // dá o valor do 1 elemento
        }
        
        if (this.tail != null) { // se tail for diferente de null
            System.out.println("tail: " +this.tail.getElement().toString()); // dá o valor do ultimo elemento
        }
    }
}
