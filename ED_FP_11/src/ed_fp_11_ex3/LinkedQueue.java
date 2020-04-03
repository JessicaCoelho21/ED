package ed_fp_11_ex3;

public class LinkedQueue<T> implements QueueADT<T> {
    private LinearNode<T> head;
    private LinearNode<T> tail;
    private int size;

    /**
     * Método construtor
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /**
     * Adiciona o elemento especificado na parte traseira da fila.
     * @param element
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> novo = new LinearNode<>(element);
        if (isEmpty()) {
            this.head = novo;
            this.tail = novo;
        } else {
            this.tail.setNext(novo);
            this.tail = novo;
        }
        
        this.size++;
    }

    /**
     * Remove o elemento na frente da fila e retorna um referência a ele. Lança
     * um EmptyCollectionException se o fila está vazia.
     * @return
     * @throws ed_fp_11_ex3.EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException{
        if (isEmpty()){
            throw new EmptyCollectionException ("queue");
        }
        
        T result = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;

        return result;
    }

    /**
     * Retorna uma referência ao elemento na frente da fila. O elemento não é
     * removido da fila. Lança um EmptyCollectionException se a fila estiver
     * vazia.
     * @return
     * @throws ed_fp_11_ex3.EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty())
         throw new EmptyCollectionException ("queue"); 
        
        return this.head.getElement();
    }

    /**
     * Método para ver se LinkedStack está vazia
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Método para o tamanho
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Método toString
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        LinearNode<T> current = this.head;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
