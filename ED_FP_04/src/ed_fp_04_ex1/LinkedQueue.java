package ed_fp_04_ex1;

public class LinkedQueue<T> implements QueueADT<T>{
    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int size;

    /**
     * Método construtor
     */
    public LinkedQueue() {
        this.size = 0;
        this.front = this.rear = null;
    }
    
    /**
     * Adds omne element to the rear of this queue
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> newElement = new LinearNode<> (element);
        
        if (this.front == null) {
            this.front = newElement;
        } else {
            this.rear.setNext(newElement);
        }
        
        this.rear = newElement;
        this.size++;
    }

    /**
     * Removes and returns the element at the front of this queue
     * @return the element at the front of this queue
     * @throws EmptyCollectionException 
     */
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

    /**
     * Returns without removing the element at the front of this queue
     * @return the first element on this queue
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Queue");
        }
        
        return this.front.getElement();
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
        String str = "";
        LinearNode<T> c = this.front;
        
        for(int i = 0; i < this.size; i++){
            str = str + c.getElement() + " ";
            c = c.getNext();
        }
        
        return str + "";
    }
}
