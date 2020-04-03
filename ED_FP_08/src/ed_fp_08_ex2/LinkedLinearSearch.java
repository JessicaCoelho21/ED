package ed_fp_08_ex2;

public class LinkedLinearSearch {
    /**
     * Pesquisa a lista especificada usando um algoritmo de pesquisa linear.
     * @param <T>
     * @param data the array to be sorted
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable> boolean linearsearch(LinkedList data,T target){
        boolean found = false;
        Node aux = data.getHead();
        
        while (found ==false && aux != null) {
            if (target.compareTo(aux.getElement()) == 0) {
                found = true;
            }
            
            aux = aux.getNext();
        }
        
        return found; 
    }
}
