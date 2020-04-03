package ed_fp_2_ex2;

public class LinkedListNosSentinela<T> {
    private LinearNode head;
    private LinearNode tail;
    private int count;

    /**
     * Método construtor para uma lista vazia
     */ 
    public LinkedListNosSentinela() {
        this.head = new LinearNode<>(null);
        this.tail = new LinearNode<>(null);
        this.count = 0;
    }

    /**
     * Método para obter o contador
     * @return 
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Método para verificar se a lista está vazia
     * @return 
     */
    private boolean isEmpty() {
        return (this.count == 0);
    }
     
    /**
     * Método para adicionar a lista
     * @param novo
     */
   public void add(T novo) {
        //criação de um novo node
        LinearNode<T> newNode = new LinearNode<>(novo);
        
        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);
        this.count++;
    }
    
    /**
     * Método que remove o primeiro elemento igual ao valor pretendido 
     * @param novo
     */
    public boolean remove(T novo) {
        boolean found = false;
        
        LinearNode<T> previous = this.head;
        LinearNode<T> current = this.head.getNext();

        while (current.getElement() != null ) {
            if (current.getElement().equals(novo)) {
                previous.setNext(current.getNext());
                this.count--;
                return true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }  
        
        return false;
    }

    /**
     * Método para imprimir a lista
     */
    public void print() {
        LinearNode<T> current = this.head;
        
        //enquanto o current for diferent de null
        while (current != null) {
            //imprime o elemento
            System.out.println(current.getElement().toString()); 
            //imprime o elemento e os seguintes
            current = current.getNext(); 
        }

        //conta o numero de elementos
        System.out.println(this.count); 
        
        //se o head for diferente de null
        if (this.head !=null) { 
            //dá o valor do 1 elemento
            System.out.println("head: "+this.head.getElement().toString()); 
        }
        
        //se tail for diferente de null
        if (this.tail !=null) { 
            //dá o valor do ultimo elemento
            System.out.println("tail: "+this.tail.getElement().toString()); 
        }
    }
}
