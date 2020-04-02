package ed_fp_05_ex5;

public interface NonOrderedListADT<T> extends ListADT<T>{
    
    /**
     * Método para adicionar no início
     * @param element elemento a adicionar
     */
    public void addToFront(T element);

    /**
     * Método para adicionar no fim
     * @param element elemento a adicionar
     */
    public void addToRear(T element);

    /**
     * Método para adicionar depois de um elemento
     * @param element elemento a adicionar
     * @param target elemento depois do qual se quer adicionar o novo elemento
     * @throws ed_fp_05_ex5.ElementDoesntExistException
     */
    public void addAfter(T element, T target)throws ElementDoesntExistException;
}
