package ed_fp_09_ex2;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

    /**
     * Método para adicionar no início
     * @param element elemento a adicionar
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
     * Método para adicionar no fim
     * @param element elemento a adicionar
     */
    @Override
    public void addToRear(T element) {
        if (this.rear == this.list.length) {
            this.expandCapacity();
            this.list[this.rear] = element;
            this.rear++;
        }
        
        else {
            this.list[this.rear] = element;
            this.rear++;
        }
    }

    /**
     * Método para adicionar depois de um elemento
     * @param element elemento a adicionar
     * @param target elemento depois do qual se quer adicionar o novo elemento
     * @throws ed_fp_09_ex2.ElementDoesntExistException
     */
    @Override
    public void addAfter(T element, T target) throws ElementDoesntExistException{
        int pos = this.find(target);
        
        //se o target não existir
        if (pos == -1) {
            throw new ElementDoesntExistException("Elemento não existe!");
        }
        
        //se a lista estiver cheia
        if (this.rear == this.list.length) {
            this.expandCapacity();
        }
       
        //percorre a lista ao contrário, até encontrar o target
        for (int i = this.rear - 1; i > pos; i--) {
            this.list[i + 1] = this.list[i];
        }
        
        //a lista na posição do target + 1 é ocupada por element, e aumenta-se o rear (último elemento da lista)
        this.list[pos + 1] = element;
        this.rear++;
    }
}
