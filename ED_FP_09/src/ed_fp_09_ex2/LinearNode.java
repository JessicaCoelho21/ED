package ed_fp_09_ex2;

public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;

    /**
     * Cria um nó vazio.
     */
    public LinearNode() {
        this.next = null;
        this.element = null;
    }

    /**
     * Cria um nó que armazena o elemento especificado.
     * @param elem elemento a ser armazenado
     */
    public LinearNode(T elem) {
        this.next = null;
        this.element = elem;
    }

    /**
     * Retorna o nó que segue este.
     * @return LinearNode<T> referência ao próximo nó
     */
    public LinearNode<T> getNext() {
        return this.next;
    }

    /**
     * Define o nó que segue este.
     * @param node nó para seguir este
     */
    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    /**
     * Retorna o elemento armazenado neste nó.
     * @return T elemento armazenado neste nó
     */
    public T getElement() {
        return this.element;
    }

    /**
     * Define o elemento armazenado neste nó
     * @param elem elemento a ser armazenado neste nó
     */
    public void setElement(T elem) {
        this.element = elem;
    }
}
