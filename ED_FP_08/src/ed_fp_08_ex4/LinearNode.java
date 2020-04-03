package ed_fp_08_ex4;

import java.util.Objects;

public class LinearNode <T>{
    private T value;
    private LinearNode<T> next;
    private LinearNode<T> previous;

    /**
     * Método construtor
     * @param value 
     */
    public LinearNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /**
     * Método construtor
     */
    public LinearNode() {
        this.value = null;
        this.next = null;
        this.previous = null;
    }

    /**
     * Método getter
     * @return 
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Método getter
     * @return 
     */
    public LinearNode<T> getNext() {
        return this.next;
    }

    /**
     * Método getter
     * @return 
     */
    public LinearNode<T> getPrevious() {
        return this.previous;
    }

    /**
     * Método setter
     * @param value 
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Método setter
     * @param Next 
     */
    public void setNext(LinearNode<T> Next) {
        this.next = Next;
    }

    /**
     * Método setter
     * @param Previous 
     */
    public void setPrevious(LinearNode<T> Previous) {
        this.previous = Previous;
    }

    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    /**
     * Método equals
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final LinearNode<?> other = (LinearNode<?>) obj;
        
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        
        return true;
    }
}
