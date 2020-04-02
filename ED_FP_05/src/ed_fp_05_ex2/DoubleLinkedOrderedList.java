package ed_fp_05_ex2;

public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T>{

    /**
     * Método construtor
     */
    public DoubleLinkedOrderedList(){
        super();
    }
    
    /**
     * Método para adicionar elementos
     * @param element 
     */
    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            DoubleNode<T> current = this.head;
            Comparable<T> temp = (Comparable<T>) element;
            DoubleNode<T> newNode = new DoubleNode<>(element);
            int count2 = 0;
            
            //Se a lista estiver vazia
            if (isEmpty()) {
                this.head = newNode;
                this.tail = this.head;
                this.count++;
                return;
            }
            
            //Inserir à cabeça da lista
            if (temp.compareTo(this.head.getElement()) < 0) {
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
                this.head = newNode;
                this.count++;
                return;
            }
            
            //inserir no meio de uma lista
            while(current.getNext() != null && temp.compareTo(current.getElement()) > 0){
                current = current.getNext();
            }
            
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            newNode.setNext(current);
            newNode.getPrevious().setNext(newNode);
            this.count++;
        }
    }
}
