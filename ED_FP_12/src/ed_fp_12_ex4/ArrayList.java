package ed_fp_12_ex4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListADT<T> {
    protected T[] list;
    protected int rear;
    protected static int DEFAULT_CAPACITY = 5;

    /**
     * Cria uma lista vazia usando a capacidade padrão(default).
     */
    public ArrayList() {
        this.list = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    /**
     * Cria uma lista vazia usando a capacidade especificada
     * @param tamanho
     */
    public ArrayList(int tamanho) {
        this.list = (T[]) (new Object[tamanho]);
        this.rear = 0;
    }

    /**
     * Usado apenas para teste. Adiciona um elemento na parte traseira desta
     * lista
     * @param element
     */
    public void add(T element) {
        if (this.rear == this.list.length) {
            this.expandCapacity();
            this.list[this.rear] = element;
            this.rear++;
        } else {
            this.list[this.rear] = element;
            this.rear++;
        }
    }

    /**
     * Usado apenas para teste. Expande a capacidade desta fila
     */
    public void expandCapacity() {
        T[] newList = (T[]) (new Object[DEFAULT_CAPACITY * 2]);

        for (int i = 0; i < this.rear; i++) {
            newList[i] = this.list[i];
        }

        this.list = newList;
    }

    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return the first element from this list
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        } else {
            T removido = this.first();
            
            for (int i = 0; i < this.rear - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
            
            this.list[this.rear - 1] = null;
            this.rear--;
            
            return removido;
        }
    }

    /**
     * Remove e retorna o último elemento desta lista.
     * @return the last element from this list
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        } else {
            T removido = this.last();
            this.list[this.rear - 1] = null;
            this.rear--;
            
            return removido;
        }
    }

    /**
     * Remove e retorna o elemento especificado dessa lista.
     * @param element the element to be removed from the list
     * @return the removed element
     * @throws ed_fp_12_ex4.EmptyCollectionException
     * @throws ed_fp_12_ex4.ElementDoesntExistException
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementDoesntExistException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }

        int elementPosition = this.find(element);

        if (elementPosition == -1) {
            throw new ElementDoesntExistException("Elemento não existe");
        }
        
        T removido = this.list[elementPosition];
        
        for (int i = elementPosition; i < this.rear - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        
        this.list[this.rear - 1] = null;
        this.rear--;
        
        return removido;
    }

    /**
     * Retorna uma referência ao primeiro elemento nesta lista.
     * @return a reference to the first element in this list
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        
        return this.list[0];
    }

    /**
     * Retorna uma referência ao último elemento nesta lista.
     * @return a reference to the last element in this list
     * @throws ed_fp_12_ex4.EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        
        return this.list[this.rear - 1];
    }

    /**
     * Método que retorna a posição de um elemento
     * @param element - elemento que procura
     * @return posicao desse elemento
     */
    public int find(T element) {
        for (int i = 0; i < this.rear; i++) {
            if (this.list[i].equals(element)) {
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Retornará true se esta lista contiver o elemento de destino especificado.
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        if (this.find(target) != -1) {
            return true;
        }
        
        return false;
    }

    /**
     * Retornará true se esta lista não contiver elementos.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        //se o rear for a primeira posição
        return this.rear == 0;
    }

    /**
     * Retorna o número de elementos nesta lista.
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Retorna um iterador para os elementos nesta lista.
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator iterator() {
        return new MeuIterador();
    }

    /**
     * Retorna uma representação de sequência desta lista.
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        if (!this.isEmpty()) {
            str.append("Primeiro elemento: ");
            str.append(this.list[0]);
            str.append("\n");
            str.append("Ultimo elemento: ");
            str.append(this.list[this.rear - 1]);
            str.append("\n");
        }
        
        str.append("Nº elementos: ");
        str.append(this.rear);
        str.append("\n");
        str.append("Tamanho da lista: ");
        str.append(this.list.length);
        str.append("\n");

        for (int i = 0; i < this.size(); i++) {
            str.append(this.list[i]);
            str.append("\n");
        }
        
        return str.toString();
    }

    /**
     * Classe que representa um Iterador
     */
    private class MeuIterador implements Iterator<T> {
        int cursor = 0;
        
        /**
         * Cria um iterador.
         */
        MeuIterador() {
            
        }
        
        /**
         * Verifica se existe um elemento e se existir faz o has next
         * @return true if the element exists
         */
        @Override
        public boolean hasNext() {
            return ((this.cursor < list.length) && (list[this.cursor] != null));
        }

        /**
         * Move o iterador para a próxima posição.
         * @return the previous position the cursor was
         */
        @Override
        public T next() {
            if (!hasNext()) { // senão existir hasNext retorna a exceção
                throw new NoSuchElementException();
            }
            
            // se existir has next retorna a posição e só depois vai para a seguinte
            return list[this.cursor++]; 
        }
    }
}
