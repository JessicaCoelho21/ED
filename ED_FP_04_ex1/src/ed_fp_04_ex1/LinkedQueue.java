/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_04_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinkedQueue<T> implements QueueADT<T>{
    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int size;

    public LinkedQueue() {
        this.size = 0;
        this.front = this.rear = null;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> newElement = new LinearNode<> (element);
        
        
        if (this.front == null) {
            this.front = newElement;
        } else {
            this.rear.setNext(newElement);
        }
        this.rear = newElement;
        size++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue");
        }
        
        T element = this.front.getElement();
        this.front = this.front.getNext();
        this.size--;
        
        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue");
        }
        
        return this.front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public String toString(){
        String str = "";
        LinearNode<T> c = this.front;
        
        for(int i = 0; i < this.size; i++){
            str = str + c.getElement() + " ";
            c = c.getNext();
        }
        
        return str + "";
    }
}
