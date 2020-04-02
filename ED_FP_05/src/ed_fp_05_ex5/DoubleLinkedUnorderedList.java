package ed_fp_05_ex5;

public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements NonOrderedListADT<T> {
    public DoubleLinkedUnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setPrevious(null);
            this.head.setNext(null);
            this.count++;
        } else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
            this.count++;
        }
    }

    @Override
    public void addToRear(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);
        
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setPrevious(null);
            this.head.setNext(null);
            this.count++;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
            this.count++;
        }
    }

    /**
     * Método que procura um elemento e insere a seguir a ele
     * @param element
     * @param target 
     */
    @Override
    public void addAfter(T element, T target) {
        if (element instanceof Comparable) {
            DoubleNode<T> curr = this.head;
            Comparable<T> targett = (Comparable<T>) target;

            DoubleNode<T> newNode = new DoubleNode<>(element);
            int conta = 0;

            if (!contains(target)) {
                return;
            }

            //maior que o ultimo
            if (targett.compareTo(this.tail.getElement()) == 0) {
                this.tail.setNext(newNode);
                newNode.setPrevious(this.tail);
                this.tail = newNode;
                this.count++;
                return;
            }

            //adicionar no meio
            while (curr.getNext() != null && targett.compareTo(curr.getElement()) != 0) {
                curr = curr.getNext();
            }

            newNode.setPrevious(curr);
            newNode.setNext(curr.getNext());
            curr.getNext().setPrevious(newNode);
            curr.setNext(newNode);

            this.count++;
        }
    }
}
