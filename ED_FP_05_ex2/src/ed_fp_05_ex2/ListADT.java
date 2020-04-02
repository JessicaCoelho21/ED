package ed_fp_05_ex2;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T>{
    /**
     * Removes and returns the first element from this list
     * @return the first element from this list
     * @throws ed_fp_05_ex2.EmptyCollectionException
     */
    public T removeFirst() throws EmptyCollectionException;
    
    /**
     * Removes and returns the last element from this list
     * @return the last element from this list
     * @throws ed_fp_05_ex2.EmptyCollectionException
     */
    public T removeLast() throws EmptyCollectionException;
    
    /**
     * Removes and returns the specified element from this list
     * @param element the element to be removed from the list
     * @return 
     * @throws ed_fp_05_ex2.EmptyCollectionException 
     * @throws ed_fp_05_ex2.ElementDoesntExistException 
     */
    public T remove (T element) throws EmptyCollectionException, ElementDoesntExistException;
     /**
      * Returns a reference to the first element in this list
      * @return a reference to the first element on this list
      */
    public T first();
    
    /**
     * Returns a reference to the last element in this list
     * @return a reference to the last element in this list
     */
    public T last();
    
    /**
     * Returns true if this list contains the specified target element
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains (T target);
    
    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this list.
     * @return the integer representation of number of elements in this list
     */
    public int size();
     
    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator();
     
    /**
     * Returns a string representation of this list.
     * @return a string representation of this list      
     */
    @Override
    public String toString();
    }
