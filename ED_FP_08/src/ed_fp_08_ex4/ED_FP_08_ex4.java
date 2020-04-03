package ed_fp_08_ex4;

public class ED_FP_08_ex4 {

    public static void main(String[] args) {
        DoubleLinkedUnorderedList<Integer> d = new DoubleLinkedUnorderedList<>();
        d.addToFront(4);
        d.addToRear(2);
        d.addToRear(3);

        SortingAndSearching.selectionSort(d);
        System.out.println(d.toString());
    }
}
