package ed_fp_05_ex5;

public class ED_FP_05_ex5 {

    public static void main(String[] args) throws ElementDoesntExistException {
        NonOrderedListADT<String> test = new DoubleLinkedUnorderedList<>();
        test.addToRear("E");
        test.addToFront("C");
        test.addToFront("A");
        test.addToRear("D");
        test.addAfter("B", "A");
        test.addAfter("Z", "D");
        test.addAfter("X", "C");
        //System.out.println("Hello");
    }
}
