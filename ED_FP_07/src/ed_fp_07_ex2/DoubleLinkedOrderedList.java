package ed_fp_07_ex2;

public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    /**
     * Método construtor
     */
    public DoubleLinkedOrderedList() {
        super();
    }

    /**
     * Adds the specified element to this list at the proper location
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            DoubleNode<T> curr = this.head;
            Comparable<T> temp = (Comparable<T>) element;

            DoubleNode<T> newNode = new DoubleNode<>(element);
            int conta = 0;

            if (isEmpty()) {  //lista vazia
                this.head = newNode;
                this.tail = this.head;
                this.count++;
                this.n_oper++;

                return;
            }

            //menor que o primeiro
            if (temp.compareTo(this.head.getElement()) < 0) {
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
                this.head = newNode;
                this.count++;
                this.n_oper++;

                return;
            }

            //maior que o ultimo
            if (temp.compareTo(this.tail.getElement()) > 0) {
                this.tail.setNext(newNode);
                newNode.setPrevious(this.tail);
                this.tail = newNode;
                this.count++;
                this.n_oper++;

                return;
            }

            //inserir no meio da lista            
            while (curr.getNext() != null && temp.compareTo(curr.getElement()) > 0) {
                curr = curr.getNext();
            }

            newNode.setPrevious(curr.getPrevious());
            curr.setPrevious(newNode);
            newNode.setNext(curr);
            newNode.getPrevious().setNext(newNode);
            this.count++;
            this.n_oper++;
        }
    }
}
