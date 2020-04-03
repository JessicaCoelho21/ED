package ed_fp_08_ex1;

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
