package ed_fp_12_ex4;

public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {
    
    /**
     * Método construtor
     */
    public ArrayHeap() {
        super();
    }

    /**
     * Adiciona o elemento especificado a este heap na posição apropriada de
     * acordo com seu valor-chave. Observe que elementos iguais são adicionados
     * ao direito.
     * @param obj o elemento a ser adicionado a este heap
     */
    @Override
    public void addElement(T obj) {
        if (this.count == this.tree.length) {
            expandCapacity();
        }
        
        this.tree[this.count] = obj;
        this.count++;
        
        if (this.count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Reordena esse heap para manter a propriedade de pedido após adicionar um
     * nó.
     */
    private void heapifyAdd() {
        T temp;
        int next = this.count - 1;

        temp = this.tree[next];

        while ((next != 0) && (((Comparable) temp).compareTo(this.tree[(next - 1) / 2]) < 0)) {
            this.tree[next] = this.tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        
        this.tree[next] = temp;
    }

    /**
     * Remova o elemento com o valor mais baixo nesta pilha e retorne um
     * referência a ele. Lança um EmptyCollectionException se o heap estiver
     * vazio.
     * @return uma referência ao elemento com o menor valor nesta cabeça
     * @throws EmptyCollectionException se ocorrer uma exceção de coleção vazia
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        
        T minElement = this.tree[0];
        this.tree[0] = this.tree[this.count - 1];
        heapifyRemove();
        this.count--;

        return minElement;
    }

    /**
     * Reordena esse heap para manter a propriedade do pedido.
     */
    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((this.tree[left] == null) && (this.tree[right] == null)) {
            next = this.count;
        } else if (this.tree[left] == null) {
            next = right;
        } else if (this.tree[right] == null) {
            next = left;
        } else if (((Comparable) this.tree[left]).compareTo(this.tree[right]) < 0) {
            next = left;
        } else {
            next = right;
        }
        
        temp = this.tree[node];
        
        while ((next < this.count) && (((Comparable) this.tree[next]).compareTo(temp) < 0)) {
            this.tree[node] = this.tree[next];
            node = next;
            left = 2 * node + 1;
            right = 2 * (node + 1);
            
            if ((this.tree[left] == null) && (this.tree[right] == null)) {
                next = this.count;
            } else if (this.tree[left] == null) {
                next = right;
            } else if (this.tree[right] == null) {
                next = left;
            } else if (((Comparable) this.tree[left]).compareTo(this.tree[right]) < 0) {
                next = left;
            } else {
                next = right;
            }
        }
        
        this.tree[node] = temp;
    }

    /**
     * Retorna o elemento com o menor valor na pilha. Lança um
     * EmptyHeapException se o heap estiver vazio.
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }

        return this.tree[0];

    }
}
