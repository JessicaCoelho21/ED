/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_09_ex2;

import java.util.Iterator;

/**
 *
 * @author Jéssica Beatriz
 */
public interface BinaryTreeADT<T> {
    /**
     * Returns a reference to the root element
     * @return a reference to the root
     */
    public T getRoot();
    
    /**
     * Returns true if this binary tree is empty and false otherwise
     * @return true if this binary tree is empty
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in this binary tree
     * @return ihe integer number of elements in this tree
     */
    public int size();
    
    /**
     * Returns true if the binaru tree contains an element that matches the
     * specified element and false otherwise
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains (T targetElement);
    
    /**
     * Returns a reference to the specified element if it is found in this
     * binaru tree. Throws an exception if the specified element is not found
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     * @throws ed_fp_09_ex1.ElementDoesntExistException
     */
    public T find(T targetElement) throws ElementDoesntExistException;
    
    /**
     * Returns the string representation of the binary tree
     * @return a tring representation of the binary tree
     */
    @Override
    public String toString();
    
    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder();
    
    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPreOrder();
    
    /**
     * Performs a postorder traversal on this binary tree by calling an
     * overloaded, recursive postorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder();
    
    /**
     * Performs a levelorder traversal on this binary tree, using a queue
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}
