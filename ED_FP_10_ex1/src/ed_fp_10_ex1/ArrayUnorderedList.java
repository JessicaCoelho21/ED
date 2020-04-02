/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    /**
     * Cria uma lista vazia usando o tamanho especificado.
     *
     * @param tam
     */
    public ArrayUnorderedList(int tam) {
        super(tam);
    }

    /**
     * Cria uma lista vazia usando a capacidade padrão.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Adiciona o elemento especificado à frente da lista.
     *
     * @param element
     */
    @Override
    public void addToFront(T element) {
        if (isEmpty()) {
            this.array[0] = element;
        } 
        
        else {
            if (this.rear == this.array.length) {
                this.createArray();
            }
            
            for (int i = rear; i > 0; i--) {
                this.array[i] = this.array[i - 1];
            }
        }
        
        this.array[0] = element;
        this.rear++;
    }

    /**
     * Adiciona o elemento especificado na parte traseira da lista.
     *
     * @param element
     */
    @Override
    public void addToRear(T element) {
        if (isEmpty()) {
            this.array[0] = element;
        } 
        
        else {

            if (this.rear == this.array.length) {
                this.createArray();
            }
        }
        
        this.array[this.rear] = element;
        this.rear++;
    }

    /**
     * Adiciona o elemento especificado após o elemento de destino especificado.
     * Lança uma ElementNotFoundException se o destino não for encontrado.
     *
     * @param element
     * @param target
     */
    @Override
    public void addAfter(T element, T target) {
        if (this.contains(target)) {
            int i = 0;
            
            while(!this.array[i].equals(target)) {
                i++;
            }
            
            for (int j = rear; j > i + 1; j--) {
                this.array[j] = this.array[j - 1];
            }

            this.array[i + 1] = element;
            this.rear++;
        }
    }

    /**
     * Cria um novo array
     */
    private void createArray() {
        T[] array2 = (T[]) (new Object[this.array.length * 2]);

        for (int i = 0; i < this.rear; i++) {
            array2[i] = this.array[i];
        }
        
        this.array = array2;
    }

}
