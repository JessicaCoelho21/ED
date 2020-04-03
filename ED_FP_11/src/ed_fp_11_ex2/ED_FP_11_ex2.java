package ed_fp_11_ex2;

import java.util.Iterator;

public class ED_FP_11_ex2 {

     public static void main(String[] args) throws EmptyCollectionException {
        PriorityQueue<Integer> binary = new PriorityQueue<>();
        
        // adiciona(elemento, prioridade)
        binary.addElement(15, 2);
        binary.addElement(10, 1);
        binary.addElement(30, 3);
        binary.addElement(5, 4);
        binary.addElement(12, 6);
        //binary.addElement(20);
        binary.addElement(20, 5);
        binary.addElement(35, 0);

        System.out.println("o removido: " + binary.removeNext());

        Iterator it = binary.iteratorLevelOrder();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
