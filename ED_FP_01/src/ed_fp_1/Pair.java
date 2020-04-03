package ed_fp_1;

public class Pair<T extends Comparable> {
    private T first;
    private T second;

    /**
     * Método construtor
     */
    public Pair() {
        
    }

    /**
     * Método construtor
     * @param first
     * @param second 
     */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Método que retorna o maior dos 2
     * @return 
     */
    public T max() {
        if (this.first.compareTo(this.second)>=0){
            return this.first;
        } else{
            return this.second;
        }
    }

    /**
     * Método que obtém o primeiro elemento
     * @return 
     */
    public T getFirst() {
        return this.first;
    }

    /**
     * Método que obtém o segundo elemento
     * @return 
     */
    public T getSecond() {
        return this.second;
    }

    /**
     * Método que atribui o primeiro elemento
     * @param first 
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Método que atribui o segundo elemento
     * @param second 
     */
    public void setSecond(T second) {
        this.second = second;
    }
}
