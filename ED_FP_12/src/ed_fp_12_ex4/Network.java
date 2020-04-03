package ed_fp_12_ex4;

public class Network<T> extends Graph<T> implements NetworkADT<T> {
    private double[][] weight;
    private Pair<T> tmpPair;

    /**
     * Inserts an edge betweem two vertices of this graph
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @param weight the weight
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        super.addEdge(vertex1, vertex2);
    }

    /**
     * Returns the weight of the shortest path in this network
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return the weight of the shortest path in this network
     * @throws ed_fp_12_ex4.EmptyCollectionException
     * @throws ed_fp_12_ex4.UnknownPathException
     */
    @Override
    public ArrayUnorderedList<T> shortestPathWeight(T vertex1, T vertex2) throws EmptyCollectionException, UnknownPathException{
        PriorityQueue<Pair<T>> priorityQueue = new PriorityQueue<>();
        UnorderedListADT<T> verticesFromPossiblePath = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> result = new ArrayUnorderedList<>();
        Pair<T> startPair = new Pair<>(null, vertex1, 0.0);
        
        priorityQueue.addElement(startPair, (int)startPair.cost);
        
        while(!priorityQueue.isEmpty()){
            Pair<T> pair = priorityQueue.removeNext();
            T vertex = pair.vertex;
            double minCost = pair.cost;
            
            if (vertex.equals(vertex2)) {
                Pair<T> finalPair = pair;
                
                while(finalPair != null){
                    result.addToFront(finalPair.vertex);
                    finalPair = finalPair.previous;
                }
                
                return result;
            }
            
            verticesFromPossiblePath.addToRear(vertex);
            
            for (int i = 0; i < this.numVertices; i++) {
                if (this.adjMatrix[getIndex(vertex)][i] && !verticesFromPossiblePath.contains(this.vertices[i])) {
                    double minCostToVertex = minCost + this.weight[getIndex(vertex)][i];
                    this.tmpPair = new Pair<>(pair, this.vertices[i], minCostToVertex);
                    priorityQueue.addElement(this.tmpPair, (int) this.tmpPair.cost);
                }
            }
        } 
        
        throw new UnknownPathException("Path doesn't exist");
    }
}