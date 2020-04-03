package ed_fp_08_ex4;

public class DoubleLinkedUnorderedList <T> extends DoubleLinkedList<T> implements UnorderedListADT<T>{
    public DoubleLinkedUnorderedList() {
        super();
    }

    /**
     * Método para adicionar ao front
     * @param element 
     */
    @Override
    public void addToFront(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (this.front == null) {
            this.front = newNode;
            this.rear = this.front;
            this.front.setPrevious(null);
            this.front.setNext(null);
            this.count++;
        } else {
            newNode.setNext(this.front);
            this.front.setPrevious(newNode);
            this.front = newNode;
            this.count++;
        }
    }

    /**
     * Método para adicionar ao rear
     * @param element 
     */
    @Override
    public void addToRear(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (this.front == null) {
            this.front = newNode;
            this.rear = this.front;
            this.front.setPrevious(null);
            this.front.setNext(null);
            this.count++;
        } else {
            this.rear.setNext(newNode);
            newNode.setPrevious(this.rear);
            this.rear = newNode;
            this.count++;
        }
    }

    /**
     * Método para adicionar a seguir ao atual
     * @param element
     * @param target 
     */
    @Override
    public void addAfter(T element, T target) {
        if (element instanceof Comparable) {
            LinearNode<T> curr = this.front;
            Comparable<T> targett = (Comparable<T>) target;

            LinearNode<T> newNode = new LinearNode<>(element);
            int conta = 0;

            if (!contains(target)) {
                return;
            }

            //maior que o ultimo
            if (targett.compareTo(this.rear.getValue()) == 0) {
                this.rear.setNext(newNode);
                newNode.setPrevious(this.rear);
                this.rear = newNode;
                this.count++;
                
                return;
            }

            //meter no meio
            while (curr.getNext() != null && targett.compareTo(curr.getValue()) != 0) {
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
