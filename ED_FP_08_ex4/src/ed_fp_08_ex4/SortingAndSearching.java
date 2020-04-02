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
public class SortingAndSearching {
    
    /**
     * Classifica o array especificado de números inteiros usando o algoritmo de
     * classificação de seleção
     * @param <T>
     * @param list 
     */
    public static <T extends Comparable<? super T>> void selectionSort(DoubleLinkedList<T> list){
        LinearNode<T> node = list.front;
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (i != 0) {
                node = node.getNext();
            }
            
            for (int j = 1; j < list.size() - 1; j++) {
                if (node.getValue().compareTo(node.getNext().getValue()) > 0) {
                    if (j == 0) {
                        list.front.setPrevious(node.getNext());
                        list.front.setPrevious(null);
                        node.setNext(node.getNext().getNext());
                        list.front.setNext(node);
                        node.setPrevious(list.front);
                        node.getNext().setPrevious(node);
                    }
                    
                    else if(j == list.size() - 2){
                        list.rear.setPrevious(node.getPrevious());
                        list.rear.setNext(node);
                        node.getPrevious().setNext(list.rear);
                        node.setPrevious(list.rear);
                        node.setNext(null);
                        list.rear = node;
                    }
                    
                    else{
                        node.getPrevious().setNext(node.getNext());
                        node.getNext().setPrevious(node.getPrevious());
                        node.getNext().getNext().setPrevious(node);
                        node.setPrevious(node.getNext());
                        node.setNext(node.getNext().getNext());
                        node.getPrevious().setNext(node);
                    }
                }
            }
        }
    }
}
