package ed_fp_2;

public class LinkedList<T>{
    private LinearNode<T> head, tail;
    private int count;

    public LinkedList(/*LinearNode<T> head, LinearNode<T> tail, int count*/) {
        this.count = 0;
        this.head = this.tail = null;
    }

    public LinearNode<T> getHead() {
        return this.head;
    }

    public void setHead(LinearNode<T> head) {
        this.head = head;
    }

    public LinearNode<T> getTail() {
        return this.tail;
    }

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
        }
        
        else{
            /**
             * A lista já contem elementos. O novo elemento tem que ligar ao elemento anteriormente ligado à Head
             * e a head ao novo elemento adicionado
             */
            newElement.setNext(this.head);
            this.head = newElement;
        }
        
        this.count++;
    }
    
    /**
     * Método para remover nodos
     * @param element 
     */
    public T remove(T element){
        boolean found = false;
        
        LinearNode<T> previous = null;
        LinearNode<T> current = this.head;
        
        while(!found && current != null){
            if (element.equals(current.getElement())) {
                found = true;
            }
            
            else{
                previous = current;
                current = current.getNext();
            }
        }
        
        if (this.count == 1) {
            this.head = this.tail = null;
        }
        
        else if(current.equals(this.head)){
            this.head = current.getNext();
        }
        
        else if (current.equals(this.tail)) {
            this.tail = previous;
            this.tail.setNext(null);
        }
        
        else{
            previous.setNext(current.getNext());
        }
        
        current.setNext(null);
        
        --this.count;
        
        return current.getElement();
        
        /*LinearNode current = this.head;
        LinearNode prev = null;
        boolean found = false;
        
        while(current != null){
            
            if (current == element) {
                prev = current;
                
            }
            
        }
        
        this.count--;*/
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
