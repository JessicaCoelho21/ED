/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_09_ex1;

import java.util.Iterator;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Creates a binary tree woth the specified element as its root
     * @param element the element that will become the root of the new binary tree
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<T> (element);
    }

    @Override
    public T getRoot() {
        return (T) this.root;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean contains(T targetElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns a reference to the specified target element if it is found in this
     * binary tree. Throws a NoSuchElementException if the specified target element
     * is not found in the binary tree
     * @param targetElement the element being sought in this tree
     * @returna reference to the specified target
     * @throws ElementDoesntExistException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementDoesntExistException{
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        
        if (current == null) {
            throw new ElementDoesntExistException("Binary Tree");
        }
        
        return (current.element);
    }
    
    /**
     * Returns a reference to the specified target element if it is found in this
     * binary tree
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     * @return 
     */
    public BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next){
        if (next == null) {
            return null;
        }
        
        if (next.element.equals(targetElement)) {
            return next;
        }
        
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        
        if(temp == null){
            temp = findAgain(targetElement, next.right);
        }
        
        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
