package ed_fp_2_ex4;

public class DoubleLinearNode<T> {
    private DoubleLinearNode<T> next;
    private DoubleLinearNode<T> previous;
    private T element;

    /**
     * Método construtor
     * @param element 
     */
    public DoubleLinearNode(T element) {
        this.next = this.previous = null;
        this.element = element;
    }
    
    /**
     * Método de acesso getter
     * @return 
     */
    public DoubleLinearNode<T> getNext() {
        return next;
    }

    /**
     * Método de acesso setter
     * @param node 
     */
    public void setNext(DoubleLinearNode<T> node) {
        this.next = node;
    }

    /**
     * Método de acesso getter
     * @return 
     */
    public DoubleLinearNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Métodod de acesso setter
     * @param previous 
     */
    public void setPrevious(DoubleLinearNode<T> previous) {
        this.previous = previous;
    }
    
    /**
     * Método de acesso getter
     * @return 
     */
    public T getElement() {
        return element;
    }

    /**
     * Método de acesso setter
     * @param element 
     */
    public void setElement(T element) {
        this.element = element;
    }
}
