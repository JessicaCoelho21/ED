package ed_fp_04_ex2;

public class CircularArrayQueue<T> implements QueueADT<T>{
    private final int DEFAULT = 100;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    /**
     * Método construtor
     */
    public CircularArrayQueue() {
        this.front = this.rear = this.size = 0;
        this.queue = (T[]) (new Object[DEFAULT]);
    }
    
    /**
     * Método construtor
     * @param tam 
     */
    public CircularArrayQueue(int tam) {
        this.front = this.rear = this.size = 0;
        this.queue = (T[]) (new Object[tam]);
    }

    /**
     * Adds omne element to the rear of this queue
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        if (size() == this.queue.length) {
            expandCapacity();
        }
        
        this.queue[this.rear] = element;
        this.rear = (this.rear + 1) % this.queue.length;
        this.size++;
    }

    /**
     * Método para aumentar a capacidade do array
     */
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
    
    /**
     * Removes and returns the element at the front of this queue
     * @return the element at the front of this queue
     * @throws EmptyCollectionException 
     */
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

    /**
     * Returns without removing the element at the front of this queue
     * @return the first element on this queue
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }
        
        return this.queue[this.front];
    }

    /**
     * Returns true if this queue contains no elements
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Returns the number of elements in this queue
     * @return the integer representation of this size of this queue
     */
    @Override
    public int size() {
        return this.size;
    }
    
    /**
     * Returns a string representation of this queue
     * @return the string representation of thsi queue
     */
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
