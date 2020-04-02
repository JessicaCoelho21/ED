/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_ex3;

/**
 *
 * @author Jéssica Beatriz
 */

public class SortingAndSearching {
    
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     * @param <T>
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void selectionSort (T[] data){
        int min;
        T temp;
        
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            
            for (int scan = index + 1; scan < data.length - 1; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            
            //Swap the values
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }
    
    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     * @param <T>
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void insertionSort (T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;
            
            /** Shift larger values to the right */
            while (position > 0 && data[position - 1].compareTo(key) > 0){
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;
        }
    }
    
    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     * @param <T>
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void bubbleSort (T[] data) {
        int position, scan;
        T temp;
        
        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    /** Swap the values */
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                }
            }
        }
    }
    
    /**
     * Sorts the specified array of objects using the quick sort
     * algorithm.
     * @param <T>
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void quickSort (T[] data, int min, int max) {
        int indexofpartition;
        
        if (max - min > 0) {
            /** Create partitions */
            indexofpartition = findPartition(data, min, max);
            /** Sort the left side */
            quickSort(data, min, indexofpartition - 1);
            /** Sort the right side */
            quickSort(data, indexofpartition + 1, max);
        }
    }
    
    /**
     * Usado pelo algoritmo de classificação rápida para encontrar a partição.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    private static <T extends Comparable<? super T>> int findPartition(T[] data, int min, int max) {
        int left, right;
        T temp, partitionelement;
        int middle = (min + max) / 2;
        
        // use middle element as partition
        partitionelement = data[middle];
        left = min;
        right = max;
        
        while (left < right) {
            //procure um elemento que seja > o elemento de partição
            while (data[left].compareTo(partitionelement) < 0) {
                left++;
            }

            //procure um elemento que seja < the particionament
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }
            
            //swap the elements
            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
        
        //mover o elemento de partição para o índice de partição
        temp = data[min];
        data[min] = data[right];
        data[right] = temp;

        return right;
    }
    
    /**
     * Classifica o array de objetos especificada usando o algoritmo de merge sort.
     *
     * @param <T>
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
        T[] temp;
        int index1, left, right;
        
        //retornar na lista de length um
        if (min == max) {
            return;
        }
        
        //encontre o length e o ponto médio da lista
        int size = max - min + 1;
        int pivot = (min + max) / 2;
        temp = (T[]) (new Comparable[size]);
        
        // classificar metade esquerda da lista
        mergeSort(data, min, pivot); 
        // classificar metade direita da lista
        mergeSort(data, pivot + 1, max); 
        
        //copiar dados classificados na área de trabalho
        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = data[min + index1];
        }

        //merge as duas listas classificadas
        left = 0;
        right = pivot - min + 1;
        
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= pivot - min) {
                    if (temp[left].compareTo(temp[right]) > 0) {
                        data[index1 + min] = temp[right++];
                    } 
                    
                    else {
                        data[index1 + min] = temp[left++];
                    }
                } 
                
                else {
                    data[index1 + min] = temp[right++];
                }
            } 
            
            else {
                data[index1 + min] = temp[left++];
            }
        }
    }
}
