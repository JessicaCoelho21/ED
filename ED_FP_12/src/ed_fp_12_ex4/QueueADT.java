package ed_fp_12_ex4;

public interface QueueADT<T> {
    /**
     * Adiciona um elemento na parte traseira desta fila. elemento
     * @param element a ser adicionado a parte traseira desta fila
     */
    public void enqueue(T element);

    /**
     * Remove e retorna o elemento na frente desta fila.
     * @return o elemento na frente desta fila
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Retorna sem remover o elemento na frente desta fila.
     * @return o primeiro elemento nesta fila
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    public T first() throws EmptyCollectionException;

    /**
     * Retorna true se essa fila não contiver elementos.
     * @return true se esta fila estiver vazia
     */
    public boolean isEmpty();

    /**
     * Retorna o número de elementos nesta fila.
     * @return a representação inteira do tamanho dessa fila
     */
    public int size();

    /**
     * Retorna uma representação de string dessa fila.
     * @return a representação em cadeia desta fila
     */
    @Override
    public String toString();
}
