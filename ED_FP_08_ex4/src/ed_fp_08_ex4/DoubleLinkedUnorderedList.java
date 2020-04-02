/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_08_ex4;

/**
 *
 * @author Jéssica Beatriz
 */
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

        if (front == null) {
            front = newNode;
            rear = front;
            front.setPrevious(null);
            front.setNext(null);
            this.count++;
        } else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
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
        if (front == null) {
            front = newNode;
            rear = front;
            front.setPrevious(null);
            front.setNext(null);
            this.count++;
        } else {

            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
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
            LinearNode<T> curr = front;
            Comparable<T> targett = (Comparable<T>) target;

            LinearNode<T> newNode = new LinearNode<>(element);
            int conta = 0;

            if (!contains(target)) {
                return;
            }

            //maior que o ultimo
            if (targett.compareTo(rear.getValue()) == 0) {
                rear.setNext(newNode);
                newNode.setPrevious(rear);
                rear = newNode;
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
