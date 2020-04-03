package ed_fp_2_ex4;

public class DoubleLinkedList<T> {
    private DoubleLinearNode<T> head; //atributo para a cabeça da lista
    private DoubleLinearNode<T> tail; //atributo para a cauda da lista
    private int count;
   
    /**
     * Método construtor
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
        
    /**
     * Método de lista vazia
     * @return 
     */
    private boolean isEmpty() {
        return (this.count == 0);
    }
    
    /**
     * Método para obter o head
     * @return 
     */
    public DoubleLinearNode getHead() {
        return this.head;
    }

    /**
     * Método para atribuir o head
     * @param head 
     */
    public void setHead(DoubleLinearNode head) {
        this.head = head;
    }

    /**
     * Método para adicionar a cabeça da Lista
     * @param elem
     */
    public void addHead(T elem) {
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(elem);
      
        if(this.count == 0){
            this.head = newNode;
        }else{
            newNode.setNext(this.head);
            //newNode vai ser atribuido a referencia do head
            this.head.getNext().setPrevious(newNode); 
            //newNode passa a primeiro elemento   
            this.head = newNode;          
        }
        
        this.count ++;
    }
    
     /**
     * Método para adicionar a lista
     * @param elem
     */
    public void add(T elem){
        //criação de um newNode node
        DoubleLinearNode<T> newNode = new DoubleLinearNode<>(elem);
   
        if (isEmpty()) { 
            this.head = newNode; 
            this.tail = this.head; 
        } else {
            //criamos um node auxiliar com o valor de head
            DoubleLinearNode<T> current = this.head; 
            
            //enquanto o elemento seguinte for diferente de null
            while (current.getNext() != null) { 
                //inserir a frente até chegar onde o next do corrent seja null
                current = current.getNext(); 
            }
            
            //liga o newNode no a lista
            current.setNext(newNode);
            //liga o newNode nó a lista e tem a ligação ao previous(setPrevious)
            current.getNext().setPrevious(newNode);
            //o último elemento vai ser o que entrou o newNode
            this.tail = newNode; 
        }
        
        this.count++; 
    }
 
    /**
     * Método para remover o primeiro elemento da lista
     */
    public void removeFirst(){  
        if (isEmpty()) { 
            return;
        } else {
            this.head = this.head.getNext();//remove o nó a cabeça 
            this.head.getNext().setPrevious(null);// passam a ligar a null    
            this.count--; //reduz o numero de elementos
        }
    }
    
    /**
     * Método que remove o primeiro elemento igual ao valor pretendido 
     * @param value
     */
    public void remove(T value) {
        if (isEmpty()) {
            return; 
        }else {
            //current aponta para o seguinte
            DoubleLinearNode<T> current = this.head.getNext(); 
            //current aponta para o previous
            DoubleLinearNode<T> previous = this.head; 
            
            while (current != null) {
                if (value.equals(current.getElement())) {
                    previous.setNext(current.getNext());
                    previous.getNext().setPrevious(previous.getPrevious());
                }
                
                previous = current;
                current = current.getNext();
            }
        }
        
        this.count--;
    }

    /**
     * Método que remove o elemento armazenado no ultimo nó da lista
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        } else {
            DoubleLinearNode<T> current = this.head;
            DoubleLinearNode<T> nodeAux = this.head;
                     
            //enquanto o current.getNext for diferente de null
            while (current.getNext() != null) { 
                //node auxiliar vai guardar a posição do current naquele momento
                nodeAux = current; 
                //current vai ser igual a posição seguinte do current
                current = nodeAux.getNext(); 
            }
            
            //node auxiliar vai tomar o valor de null
            nodeAux.setNext(null); 
            nodeAux.setPrevious(nodeAux.getPrevious()); 
            //o ultimo vai ser igual ao node auxiliar isto é null
            this.tail = nodeAux;
            this.count--;
        }
    }

    /**
     * Método para imprimir a lista
     */
    public void print() {
        DoubleLinearNode<T> current = this.head; 
        
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
        if (this.head != null) { 
            //dá o valor do 1 elemento
            System.out.println("head: " + this.head.getElement().toString()); 
        }

        //se tail for diferente de null
        if (this.tail != null) { 
            //dá o valor do ultimo elemento
            System.out.println("tail: " + this.tail.getElement().toString()); 
        }
    }
}
