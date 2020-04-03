package ed_fp_11_extra_exercise;

public class HeapNode<T> extends BinaryTreeNode<T> {
    protected HeapNode<T> parent;

    /**
     * Cria um novo nó de heap com os dados especificados.
     * @param obj os dados a serem contidos nos novos nós de heap
     */
    public HeapNode(T obj) {
        super(obj);
        this.parent = null;
    }
}
