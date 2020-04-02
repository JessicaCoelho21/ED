package ed_fp_05_ex2;

public class ED_FP_05_ex2 {

    public static void main(String[] args) throws ElementDoesntExistException{
        OrderedListADT <String> teste = new DoubleLinkedOrderedList<>();
        
        teste.add("E");
        teste.add("B");
        teste.add("C");
        teste.add("A");
        teste.add("D");
        
        System.out.println(teste.toString());
    }
}
