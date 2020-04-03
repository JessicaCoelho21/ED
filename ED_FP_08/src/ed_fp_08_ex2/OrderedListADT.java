package ed_fp_08_ex2;

public interface OrderedListADT<T> extends ListADT<T>{
    
    /**
     * Adds the specified element to this list at the proper location
     * @param element elemento a adicionar
     */
    public void add(T element);
}
