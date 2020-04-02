package ed_fp_05_ex5;

public class DoubleNode<T> {
    private DoubleNode<T> next;
    private T element;
    private DoubleNode<T> previous;

    /**
     * Creates an empty node.
     */
    public DoubleNode() {
        this.next = null;
        this.element = null;
        this.previous = null;
    }

    /**
     * Creates a node storing the specified element.
     * @param elem the element to be stored into the new node
     */
    public DoubleNode(T elem) {
        this.next = null;
        this.element = elem;
        this.previous = null;
    }

    /**
     * Returns the node that follows this one.
     * @return the node that follows the current one
     */
    public DoubleNode<T> getNext() {
        return this.next;
    }

    /**
     * Sets the node that precedes this one.
     * @param dnode the node to be set as the one to precede the current one
     */
    public void setPrevious(DoubleNode<T> dnode) {
        this.previous = dnode;
    }

    /**
     * Returns the node that precedes this one.
     * @return the node that precedes the current one
     */
    public DoubleNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Sets the node that follows this one.
     * @param next the node to be set as the one to follows the current one
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the element stored in this node.
     * @return the element stored in this node
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Sets the element stored in this node.
     * @param elem the element to be stored in this node
     */
    public void setElement(T elem) {
        this.element = elem;
    }
}
