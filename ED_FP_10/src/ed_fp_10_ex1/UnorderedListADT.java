package ed_fp_10_ex1;

public interface UnorderedListADT<T> extends ListADT<T>{
    
    public void addToFront(T element);
    
    public void addToRear(T element);
    
    public void addAfter(T element, T target);
}
