package ed_fp_11_extra_exercise;

public class BinaryTreeNode<T> {

    protected T element;
    protected BinaryTreeNode<T> left, right;

    /**
     * Cria um novo nó da árvore com os dados especificados.
     * @param obj o elemento que se tornará parte do novo nó da árvore
     */
    public BinaryTreeNode(T obj) {
        this.element = obj;
        this.left = null;
        this.right = null;
    }

    /**
     * Método que obtém o nó esquerdo
     * @return 
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Método que atribui um nó esquerdo
     * @param left 
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Método que obtém o nó direito
     * @return 
     */
    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    /**
     * Método que atribui um nó direito
     * @param right 
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Retorna o número de filhos não nulos deste nó. Este método pode ser
     * capaz de ser escrito com mais eficiência.
     * @return o número inteiro de filhos não nulos deste nó
     */
    public int numChildren() {
        int children = 0;
        if (this.left != null) {
            children = 1 + this.left.numChildren();
        }
        
        if (this.right != null) {
            children = children + 1 + this.right.numChildren();
        }
        
        return children;
    }
}