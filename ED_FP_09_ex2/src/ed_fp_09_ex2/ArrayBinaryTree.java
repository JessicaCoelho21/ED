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
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;
    
    /**
     * Creates an empty binary tree
     */
    public ArrayBinaryTree(){
        this.count = 0;
        this.tree = (T[]) new Object[CAPACITY];
    }
    
    /**
     * Creates a binary tree with the specified element as its root
     * @param element the element which will become the root of the ney tree
     */
    public ArrayBinaryTree(T element){
        this.count = 1;
        this.tree = (T[]) new Object[CAPACITY];
        this.tree[0] = element;
    }

    @Override
    public T getRoot() {
        return this.tree[0];
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
     * @param targetElement the element being sought in the tree
     * @returntrue if the element is in the tree
     * @throws ElementDoesntExistException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementDoesntExistException {
        T temp = null;
        boolean found = false;
        
        for (int ct = 0; ct < this.count && !found; ct++) {
            if (targetElement.equals(this.tree[ct])) {
               found = true;
               temp = this.tree[ct];
            }
        }
        
        if (!found) {
            throw new ElementDoesntExistException("Binary tree");
        }
        
        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Performs a recursive inorder traversal
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void inorder(int node){
        
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
