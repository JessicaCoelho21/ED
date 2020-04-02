package ed_fp_2;

public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;

    /**
     * Método construtor
     * @param element 
     */
    public LinearNode(T element) {
        this.next = null;
        this.element = element;
    }
    
    /**
     * Método de acesso getter
     * @return 
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Método de acesso setter
     * @param node 
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
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
