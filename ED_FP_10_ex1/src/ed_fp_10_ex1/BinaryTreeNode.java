/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class BinaryTreeNode<T> {
    protected T element;
    protected BinaryTreeNode<T> left, right;

    /**
     * Creates a new tree node with the specified data
     * @param obj the element that will become a part of the new tree node
     */
    public BinaryTreeNode(T obj) {
        this.element = obj;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Returns the number of non-null children of this node.
     * This method may be able to be written more efficiently
     * @return the integer number of non-null children of this node
     */
    public int numChildren(){
        int children = 0;
        
        if (this.left != null) {
            children = 1 + this.left.numChildren();
        }
        
        if (this.right != null) {
            children = 1 + this.left.numChildren();
        }
        
        return children;
    }
}
