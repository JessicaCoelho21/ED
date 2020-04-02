package ed_fp_04_ex1;

public interface QueueADT<T> {
    
    /**
     * Adds omne element to the rear of this queue
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue (T element);
    
    /**
     * Removes and returns the element at the front of this queue
     * @return the element at the front of this queue
     * @throws EmptyCollectionException 
     */
    public T dequeue() throws EmptyCollectionException;
    
    /**
     * Returns without removing the element at the front of this queue
     * @return the first element on this queue
     * @throws EmptyCollectionException 
     */
    public T first() throws EmptyCollectionException;
    
    /**
     * Returns true if this queue contains no elements
     * @return true if this queue is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this queue
     * @return the integer representation of this size of this queue
     */
    public int size();
    
    /**
     * Returns a string representation of this queue
     * @return the string representation of thsi queue
     */
    @Override
    public String toString();
}
