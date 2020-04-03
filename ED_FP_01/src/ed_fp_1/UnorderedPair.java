package ed_fp_1;

public class UnorderedPair<T extends Comparable> extends Pair<T> {
    
    /**
     * Método contrutor
     */
    public UnorderedPair() {
        
    }
    
    /**
     * Método construtor
     * @param firstItem
     * @param secondItem 
     */
    public UnorderedPair(T firstItem, T secondItem) {
        setFirst(firstItem);
        setSecond(secondItem);
    }
    
    /**
     * Método equals
     * @param otherObject
     * @return 
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            UnorderedPair<T> otherPair = (UnorderedPair<T>) otherObject;
            
            return (getFirst().equals(otherPair.getFirst())
            && getSecond().equals(otherPair.getSecond()))
            || (getFirst().equals(otherPair.getSecond())
            && getSecond().equals(otherPair.getFirst()));
         }
    }
}
