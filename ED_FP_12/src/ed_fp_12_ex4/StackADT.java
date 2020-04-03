package ed_fp_12_ex4;

public interface StackADT<T> {
    
    /** 
     * Adiciona um elemento ao topo da pilha.
     * @param element elemento a ser empurrado para a pilha
     */
    public void push(T element);
    
    /** 
     * Remove e retorna o elemento superior da pilha.
     * @return T elemento removido da parte superior da pilha
     */
    public T pop();
    
   /** 
    * Retorna sem remover o elemento superior da pilha.
    * @return T elemento no topo da pilha
    */
    public T peek();
    
    /** 
     * Retorna true se essa pilha não contém elementos.
     * @return boolean se esta pilha está ou não vazia
     */
    public boolean isEmpty();
    
    /** 
     * Retorna o número de elementos na pilha.
     * @return int número de elementos na pilha
     */
    public int size();
    
    /** 
     * Retorna uma representação de string da pilha.
     * @return String representação desta pilha
     */
    @Override
    public String toString();
}
