package ed_fp_2_ex1;

public class LinkedList<T>{
    private LinearNode<T> head, tail;
    private int count;

    /**
     * Método construtor
     */
    public LinkedList(/*LinearNode<T> head, LinearNode<T> tail, int count*/) {
        this.count = 0;
        this.head = this.tail = null;
    }

    /**
     * Método que obtém o elemento head
     * @return 
     */
    public LinearNode<T> getHead() {
        return this.head;
    }

    /**
     * Método que atribui uma head
     * @param head 
     */
    public void setHead(LinearNode<T> head) {
        this.head = head;
    }

    /**
     * Método que obtém o elemento tail
     * @return 
     */
    public LinearNode<T> getTail() {
        return this.tail;
    }

    /**
     * Método que atribui uma tail
     * @param tail 
     */
    public void setTail(LinearNode<T> tail) {
        this.tail = tail;
    }

    /**
     * Método de acesso getter (count = número de nodos)
     * @return 
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Método que atribui um número de nodos
     * @param count 
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * Método para adicionar um nodo
     * @param element 
     */
    public void add(T element){
        LinearNode<T> newElement = new LinearNode<>(element);
        
        /**
         * A lista está vazia. Temos que apontar o head e o tail ao novo elemento.
         * Caso fosse usado o setNext, estaríamos a apontar o novo elemento a num nodo nulo, o que não é posível
         */
        if (this.count == 0) {
            this.head = this.tail = newElement;
        } else{
            /**
             * A lista já contem elementos. O novo elemento tem que ligar ao elemento anteriormente ligado à Head
             * e a head ao novo elemento adicionado
             */
            newElement.setNext(this.head);
            this.head = newElement;
        }
        
        this.count++;
    }
    
    private boolean isEmpty() {
        return (this.count == 0);
    }
    
    /**
     * Método para remover nodos
     * @param element 
     */
    public void remove(T element){
        if (isEmpty()) {
            return; 
        }else {
            LinearNode<T> current = this.head.getNext(); //current aponta para o seguinte
            LinearNode<T> anterior = this.head; //current aponta para o anterior
            
            while (current != null) {
                if (element.equals(current.getElement())) {
                    anterior.setNext(current.getNext());
                }
                
                anterior = current;
                current = current.getNext();
            }
        }
        
        this.count--;
    }

    /**
     * Método para remover o primeiro elemento da lista
     */
    public void removeFirst(){  
        if (isEmpty()) { 
            return;
        } else {
            this.head = this.head.getNext(); //remove o nó a cabeça
            this.count--; 
        }
    }
    
    /**
     * Método que remove o elemento armazenado no ultimo nó da lista
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        } else {
            LinearNode<T> current = this.head;
            LinearNode<T> nodeAux = null;
                     
            while (current.getNext() != null) { //enquanto o current.getNext for diferente de null
                nodeAux = current; //node auxiliar vai guardar a posição do current naquele momento
                current = nodeAux.getNext(); //cuurent vai ser igual a posição seguinte do current
            }
            
            nodeAux.setNext(null); //node auxiliar vai tomar o valor de null
            this.tail = nodeAux; // o ultimo vai ser igual ao node auxiliar isto é null       
            this.count--;
        }
    }
    
    /**
     * Método toString
     * @return 
     */
    @Override
    public String toString() {
        String result = this.head + " ";
        LinearNode next = this.head.getNext();
        
        if (next != null) {
            result += next.toString();
        }
        return result;
    }
}
