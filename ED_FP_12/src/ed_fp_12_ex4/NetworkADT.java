package ed_fp_12_ex4;

public interface NetworkADT<T> extends GraphADT<T> {
    
    /**
     * Inserts an edge betweem two vertices of this graph
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    public void addEdge(T vertex1, T vertex2, double weight);
    
    /**
     * Returns the weight of the shortest path in this network
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     * @throws ed_fp_12_ex4.EmptyCollectionException
     * @throws ed_fp_12_ex4.UnknownPathException
     */
    public ArrayUnorderedList<T> shortestPathWeight(T vertex1, T vertex2)throws EmptyCollectionException, UnknownPathException;
}
