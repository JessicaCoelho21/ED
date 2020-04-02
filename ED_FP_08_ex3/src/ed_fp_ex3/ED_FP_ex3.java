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
public class ED_FP_ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] a = {8, 4, 2, 5, 6};
        
        // SortingAndSearching.quickSort(a, 0, 4);
        // SortingAndSearching.bubbleSort(a);
        SortingAndSearching.mergeSort(a, 0, 4);
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
}
