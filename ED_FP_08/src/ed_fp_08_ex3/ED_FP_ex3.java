package ed_fp_08_ex3;

public class ED_FP_ex3 {

    public static void main(String[] args) {
        Integer[] a = {8, 4, 2, 5, 6};
        
        // SortingAndSearching.quickSort(a, 0, 4);
        // SortingAndSearching.bubbleSort(a);
        SortingAndSearching.mergeSort(a, 0, 4);
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
