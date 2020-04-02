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
public class LinkedStack<T> implements StackADT<T> {
    private LinearNode<T> head;
    private int size;

    /**
     * Método construtor
     */
    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }
     
    /**
     * Adiciona o elemento especificado ao topo desta pilha, expandindo a
     * capacidade do array de pilhas, se necessário.
     * @param element elemento genérico a ser empurrado para a pilha
     */
    @Override
    public void push(T element) {
        LinearNode <T> newNode = new LinearNode<>(element);
        if(this.head == null){
            this.head = newNode;
            this.size ++;
        }
        
        else {
           newNode.setNext(this.head);
           this.head = newNode;
           this.size++;
        }
    }

    /**
     * Remove o elemento na parte superior desta pilha e retorna uma referência a isto. 
     * Lança um EmptyCollectionException se a pilha estiver vazia.
     * @return T element removido do topo da pilha
     */
    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
       
        T element = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;       
        
        return element;
    }

    /**
     * Retorna uma referência ao elemento na parte superior desta pilha. O elemento
     * não é removido da pilha. 
     * Lança um EmptyCollectionException se a pilha está vazia.
     * @return T element no topo da pilha
     */
    @Override
    public T peek() {
        if(this.isEmpty()){
            return null;
        }
            
        return this.head.getElement();
    }

    /**
     * Método para ver se LinkedStack está vazia
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Método para o tamanho
     * @return 
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString() {
        String str = "";
        LinearNode<T> c = this.head;
        
        for(int i = 0; i < this.size; i++){
            str = str + c.getElement() + " ";
            c = c.getNext();
        }
        
        return str + "";
    }
}
