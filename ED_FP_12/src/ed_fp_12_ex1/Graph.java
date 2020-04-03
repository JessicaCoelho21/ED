package ed_fp_12_ex1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected boolean[][] adjMatrix;
    protected T[] vertices;

    /**
     * Creates an empty graph
     */
    public Graph() {
        this.numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Método para aumentar a capacidade do grafo em 3 vértices
     */
    public void expandCapacity() {
        Arrays.copyOf(this.vertices, this.numVertices + 3);
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary. It also associates an object with the vertex.
     * @param vertex the vertex to add to the graph
     */
    @Override
    public void addVertex(T vertex) {
        if (this.numVertices == this.vertices.length) {
            expandCapacity();
        }

        //atribui o vértice ao array de vertices na posição atual
        this.vertices[this.numVertices] = vertex;

        //percorre i, e não o associa a nenhum outro
        for (int i = 0; i <= this.numVertices; i++) {
            this.adjMatrix[this.numVertices][i] = false;
            this.adjMatrix[i][this.numVertices] = false;
        }

        //número de vértices incrementado
        this.numVertices++;
    }

    /**
     * Removes a single vertex with the given value from this graph
     * @param vertex the vertex to be removed from this graph
     */
    @Override
    public void removeVertex(T vertex) {
        int i = 0;

        //enquanto o vértice for diferente do vértice na posição i, incrementa i
        while (!vertex.equals(this.vertices[i])) {
            i++;
        }

        //se i for menor que o tamanho do array de vértices, o vértice na posição i fica null
        if (i < this.vertices.length) {
            this.vertices[i] = null;

            //percorre array a partir da posição i, e recua uma posição a todos os vértices seguintes
            for (int j = i; j < this.vertices.length; j++) {
                this.vertices[j] = this.vertices[j + 1];
            }

            //decrementa o número de vértices
            this.numVertices--;
        }
    }

    /**
     * Método que verifica se o número de vértices é válido
     * @param index
     * @return
     */
    public boolean indexIsValid(int index) {
        return index < this.vertices.length;
    }

    /**
     * Método que obtem o índice de um dado vértice
     *
     * @param vertice
     * @return
     */
    public int getIndex(T vertice) {
        int i = 0;

        //enquando o vértice for diferente do da posição i do array de vértices, incrementa i
        while (!vertice.equals(this.vertices[i])) {
            i++;
        }

        //Se i for maior que o número de vértices, retorna -1
        if (i >= this.numVertices) {
            return -1;
        } else { //senão, retorna i
            return i;
        }
    }

    /**
     * Inserts an edge between two vertices of the graph
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        //obtém indice do vértice 1 e 2
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Insertes an edge between two vertices of the graph
     * @param index1
     * @param index2
     */
    public void addEdge(int index1, int index2) {
        //se o índice 1 e 2 forem válidos, associa os vértices pois estão ligados por uma aresta
        if (indexIsValid(index1) && indexIsValid(index2)) {
            this.adjMatrix[index1][index2] = true;
            this.adjMatrix[index2][index1] = true;
        }
    }

    /**
     * Removes an edge between two vertices of this graph
     * @param vertex1
     * @param vertex2
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        //verifica a validade dos índices, e não associa os vértices
        if (indexIsValid(getIndex(vertex1)) && indexIsValid(getIndex(vertex2))) {
            this.adjMatrix[getIndex(vertex1)][getIndex(vertex2)] = false;
            this.adjMatrix[getIndex(vertex2)][getIndex(vertex1)] = false;
        }
    }

    /**
     * Returns an iterator that performs a breadth first search traversal
     * starting at the given index
     * @param startIndex the index to begin the search from
     * @return an iterator that performs a breadth first traversal
     * @throws EmptyCollectionException
     */
    public Iterator<T> iteratorBFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(this.vertices[x.intValue()]);

            //Find all vertices adjacent to x that have not been visited and queue them up
            for (int i = 0; i < this.numVertices; i++) {
                if (this.adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    /**
     * Returns a breadth first iterator starting with the given vertex
     * @param startVertex the starting vertex
     * @return a breadth first iterator beginning at the given vertex
     */
    @Override
    public Iterator iteratorBFS(T startVertex) {
        try {
            return iteratorBFS(getIndex(startVertex));
        } catch (EmptyCollectionException ex) {
            System.out.println("Empty Collection");
        }

        return null;
    }

    public Iterator<T> iteratorDFS(int startIndex) {
        Integer x;
        boolean found;
        
        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        
        boolean[] visited = new boolean[this.numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        for (int i = 0; i < this.numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(this.vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            //Find a vertex adjacent to x that has not been visited and push it on the stack
            for (int i = 0; (i < this.numVertices) && !found; i++) {
                if (this.adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(this.vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }

            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }

        return resultList.iterator();
    }

    /**
     * Returns the depth first iterator stating with the given vertex
     * @param startVertex the starting vertex
     * @return a depth first iterator starting at the given vertex
     */
    @Override
    public Iterator iteratorDFS(T startVertex) {
        return iteratorDFS(getIndex(startVertex));
    }

    /**
     * Return an iterator that contains the shortest path between the two
     * vertices
     * @param startVertex the starting vertex
     * @param targetVertex the ending vertex
     * @return an iterator that contains the shortest path between the two
     * vertices
     */
    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        Integer x;
        
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<>();
        
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
        int[][] info = new int[this.vertices.length][3];
        boolean found = false;
        int counter = 0;

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        //Index of Vertex
        info[counter][0] = startIndex;
        //PathLength
        info[counter][1] = 0;
        //LastVertex
        info[counter][2] = -1;
        visited[startIndex] = true;

        while (!found && !traversalQueue.isEmpty()) {
            try {
                x = traversalQueue.dequeue();

                /**
                 * Find all vertices adjacent to x that have not been visited
                 * and queue them up
                 */
                for (int i = 0; i < this.numVertices; i++) {
                    if (this.adjMatrix[x.intValue()][i] && !visited[i]) {
                        traversalQueue.enqueue(new Integer(i));
                        counter++;
                        
                        info[counter][0] = i;
                        info[counter][1] = info[x.intValue()][1] + 1;
                        info[counter][2] = info[x.intValue()][0];
                        
                        visited[i] = true;
                        
                        if (i == targetIndex) {
                            found = true;
                        }
                    }
                }

                if (found) {
                    resultList.addToFront(this.vertices[info[counter][0]]);
                    int lastIndex = info[counter][2];
                    
                    while (lastIndex != -1) {
                        resultList.addToFront(this.vertices[info[lastIndex][0]]);
                        lastIndex = info[lastIndex][2];
                    }

                }
            } catch (EmptyCollectionException ex) {
                System.out.println("Empty Collection");
            }
        }
        
        return resultList.iterator();
    }

    /**
     * Returns true if this graph is empty, false otherwise
     * @return true if this graph is empty
     */
    @Override
    public boolean isEmpty() {
        return this.numVertices == 0;
    }

    /**
     * Returns true if this graph is connected, false otherwise
     * @return true if this graph is connected
     */
    @Override
    public boolean isConnected() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        } 

        Iterator itr = iteratorBFS(0);
        int counter = 0;

        while (itr.hasNext()) {
            itr.next();
            counter++;
        }

        return (counter == this.numVertices);
    }

    /**
     * Return the number of vertices in this graph
     * @return the integer number of vertices in this graph
     */
    @Override
    public int size() {
        return this.numVertices;
    }
}
