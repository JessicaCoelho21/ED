package ed_fp_1;

public class TwoTypePair<T1, T2> {
    private T1 first;
    private T2 second;

    /**
     * Método construtor
     */
    public TwoTypePair() {
        this.first = null;
        this.second = null;
    }

    /**
     * Método construtor
     * @param firstItem
     * @param secondItem 
     */
    public TwoTypePair(T1 firstItem, T2 secondItem) {
        this.first = firstItem;
        this.second = secondItem;
    }

    /**
     * Método para obter o primeiro elemento
     * @return 
     */
    public T1 getFirst() {
        return this.first;
    }

    /**
     * Método para atribuir um primeiro elemento
     * @param first 
     */
    public void setFirst(T1 first) {
        this.first = first;
    }

    /**
     * Método para obter o segundo elemnto
     * @return 
     */
    public T2 getSecond() {
        return second;
    }

    /**
     * Método para atribuir um segundo elemento
     * @param second 
     */
    public void setSecond(T2 second) {
        this.second = second;
    }

    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString() {
        return ("first: " + this.first.toString() + "\n" + "second: " + this.second.toString());
    }

    /**
     * Método equals
     * @param otherObject
     * @return 
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            TwoTypePair otherPair = (TwoTypePair) otherObject;
            return (this.first.equals(otherPair.first) && this.second.equals(otherPair.second));
        }
    }
}
