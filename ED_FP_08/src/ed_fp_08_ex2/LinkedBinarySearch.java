package ed_fp_08_ex2;

public class LinkedBinarySearch {
    /**
     * Pesquisa oa lista usando um algoritmo de pesquisa binária.
     * @param <T>
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
     public static <T extends Comparable<? super T>> boolean binarySearch(DoubleLinkedOrderedList<T> data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2;
        int i = 0;
        DoubleNode<T> aux = data.getHead(); //criação de um node auxiliar
        T[] array = (T[]) new Comparable[data.size()];//passa os elementos da lista para um array

        while (aux != null) {
            array[i] = (T) aux.getElement();
            aux = aux.getNext();
            i++;
        }

        return BinarySearch.binarySearch(array, 0, data.size(), target);
    }
}
