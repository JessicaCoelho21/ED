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
public class BinarySearch {
    public static <T extends Comparable<? super T>> boolean BinarySearch (T[] data, int min, int max, T target){
        boolean found = false;
        //determine the midpoint
        int midpoint = (min + max) / 2;
        
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        }
        
        else if (data[midpoint].compareTo(target) > 0){
            if (min <= midpoint - 1) {
                found = BinarySearch(data, min, midpoint - 1, target);
            }
        }    
        
        else if (midpoint + 1 <= max) {
            found = BinarySearch(data, midpoint + 1, max, target);
        }
        
        return found;
    }
}
