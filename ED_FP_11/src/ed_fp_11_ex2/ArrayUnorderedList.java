package ed_fp_11_ex2;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    
    /**
     * Método para adicionar elementos a front
     * @param element 
     */
    @Override
    public void addToFront(T element) {
        if (this.rear == this.list.length) {
            this.expandCapacity();
        }

        for (int i = this.rear - 1; i >= 0; i--) {
            this.list[i + 1] = this.list[i];
        }
        
        this.list[0] = element;
        this.rear++;
    }

    /**
     * Método para adicionar elementos a rear
     * @param element 
     */
    @Override
    public void addToRear(T element) {
        if (this.rear == this.list.length) {
            this.expandCapacity();
            this.list[this.rear] = element;
            this.rear++;
        } 
        
        else {
            list[this.rear] = element;
            this.rear++;
        }
    }

    /**
     * Método que adiciona um elemento depois de um outro dado elemento
     * @param element
     * @param atual
     * @throws ElementDoesntExistException 
     */
    @Override
    public void addAfter(T element, T atual) throws ElementDoesntExistException {
        int posicao = this.find(atual);

        if (posicao == -1) {
            throw new ElementDoesntExistException("Elemento não existe");
        }

        if (this.rear == this.list.length) {
            this.expandCapacity();
        }

        for (int i = this.rear - 1; i > posicao; i--) {
            this.list[i + 1] = this.list[i];
        }
        
        this.list[posicao + 1] = element;
        this.rear++;
    }
}
