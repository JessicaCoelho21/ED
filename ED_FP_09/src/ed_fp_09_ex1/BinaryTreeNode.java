package ed_fp_09_ex1;

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
     * Método que obtém o nó esquerdo do atual
     * @return 
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Método que atribui um nó esquerdo ao nó atual
     * @param left 
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Método que obtém o nó direito do atual
     * @return 
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    /**
     * Método que atribui um nó direito ao nó atual
     * @param right
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
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
