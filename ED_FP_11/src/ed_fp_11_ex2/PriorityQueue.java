package ed_fp_11_ex2;

public class PriorityQueue<T> extends ArrayHeap<PriorityQueueNode<T>> {
    
    /**
     * Cria uma fila de prioridade vazia.
     */
    public PriorityQueue() {
        super();
    }

    /**
     * Adiciona o elemento fornecido a este PriorityQueue.
     * @param object o elemento a ser adicionado à fila de prioridade
     * @param priority a prioridade inteira do elemento a ser adicionado
     */
    public void addElement(T object, int priority) {
        PriorityQueueNode<T> node = new PriorityQueueNode<>(object, priority);
        super.addElement(node);
    }

    /**
     * Remove o próximo elemento de maior prioridade desta fila de prioridade e
     * retorna uma referência a ele.
     * @return uma referência ao próximo elemento de maior prioridade nesta fila
     * @throws ed_fp_11_ex2.EmptyCollectionException
     */
    public T removeNext() throws EmptyCollectionException {
        PriorityQueueNode<T> temp = (PriorityQueueNode<T>) super.removeMin();
        
        return temp.getElement();
    }
}
