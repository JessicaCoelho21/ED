package ed_fp_11_extra_exercise;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
    
    /**
     * Returns a reference to the root element
     * @return  a reference to the root
     * @throws ed_fp_11_extra_exercise.EmptyCollectionException
     */
    public T getRoot() throws EmptyCollectionException ;
    
    /**
     * Returns true if this binary tree is empty and false otherwise
     * @return true if this binary tree is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this binary tree
     * @return the integer number of elements in this tree
     */
    public int size();
    
    /**
     * Returns ture if the binary tree contains an element that matches the specified
     * element and false otherwise
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T targetElement);
    
    /**
     * Returns a reference to the specified element if it is found in this binary
     * tree. Throws an exception if the specified element is not found
     * @param targetElement the element boing sought in the tree
     * @return a reference to the specified element
     * @throws ed_fp_11_extra_exercise.ElementDoesntExistException
     */
    public T find(T targetElement) throws ElementDoesntExistException;
    
    /**
     * Returns the string representation of the binary tree
     * @return a string reperesentation of the binary tree
     */
    @Override
    public String toString();
    
    /**
     * Performs an inorder traversal on this binary tree by calling an overloaded,
     * recursive inorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder();
    
    /**
     * Performs an preorder traversal on this binary tree by calling an overloaded,
     * recursive preorder method that starts
     * @return an iterator over the element of this binary tree
     */
    public Iterator<T> iteratorPreOrder();
    
    /**
     * Performs a postorder traversal on this binary tree by
     * calling an overloaded, recursive postorder
     * method that starts with the root.
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder();
    
    /**
     * Performs a levelorder traversal on the binary tree,
     * using a queue.
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}
