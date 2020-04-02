/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_04_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class CircularArrayQueue<T> implements QueueADT<T>{
    private final int DEFAULT = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularArrayQueue() {
        this.front = this.rear = this.size = 0;
        queue = (T[]) (new Object[DEFAULT]);
    }
    
    public CircularArrayQueue(int tam) {
        this.front = this.rear = this.size = 0;
        queue = (T[]) (new Object[tam]);
    }

    @Override
    public void enqueue(T element) {
        if (size() == this.queue.length) {
            expandCapacity();
        }
        
        this.queue[this.rear] = element;
        this.rear = (this.rear + 1) % this.queue.length;
        this.size++;
    }

    public void expandCapacity(){
        T[] expandedQueue = (T[]) (new Object[this.queue.length * 2]);
        
        for (int i = 0; i < this.size; i++) {
            expandedQueue[i] = this.queue[this.front];
            this.front = (this.front + 1) % this.queue.length;
        }
        
        this.front = 0;
        this.rear = this.size;
        this.queue = expandedQueue;
    }
    
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(this.isEmpty()){
            throw new EmptyCollectionException("Queue");
        }
        
        T result = this.queue[this.front];
        this.queue[this.front] = null;
        this.front = (this.front + 1) % this.queue.length;
        this.size--;
        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }
        
        return this.queue[this.front];
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
        String s = "";
        int tempfront = this.front;
        
        for (int i = 0; i < this.size; i++) {
            s+= this.queue[tempfront].toString() + " ";
            tempfront = (tempfront + 1) % this.queue.length;
        }
        
        return s;
    }
}
