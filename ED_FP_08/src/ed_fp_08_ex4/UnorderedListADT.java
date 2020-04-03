package ed_fp_08_ex4;

public interface UnorderedListADT <T> extends ListADT <T>{
    public void addToFront(T element);
    
    public void addToRear(T element);
    
    public void addAfter(T element,T target);
}
