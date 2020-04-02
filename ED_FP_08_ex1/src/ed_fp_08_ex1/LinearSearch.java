/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_08_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinearSearch {
    public static <T extends Comparable<? super T>> boolean LinearSearch(T[] data, int min, int max, T target){
        int index = min;
        boolean found = false;
        
        while(!found && index <= max){
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            
            index++;
        }
        
        return found;
    }
}
