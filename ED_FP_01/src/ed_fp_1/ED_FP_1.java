package ed_fp_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ED_FP_1 {
    static void printCollection(Collection<?> c) {
        for (Object e: c){
        System.out.println(e);
        }
    }
        
    public static void main(String[] args) {
        TwoTypePair <String, String> teste1 = new TwoTypePair<>("Jéssica","Coelho");
        TwoTypePair <String, String> teste2 = new TwoTypePair<>("Ema", "Silva");   
        
        //System.out.println(teste1.toString());
        //System.out.println(teste2.toString());
        //System.out.println(teste1.equals(teste2));

        Pair <Integer> teste3 = new Pair<>(21,2);
        
        UnorderedPair<String> p1 = new UnorderedPair<>("peanuts", "beer");
        UnorderedPair<String> p2 = new UnorderedPair<>("beer", "peanuts");
        
        if (p1.equals(p2)) {
            System.out.println(p1.getFirst() + " and " + p1.getSecond() + " is the same as");
            System.out.println(p2.getFirst() + " and " + p2.getSecond());
        }
        
    
    
    List<Integer> stones = new ArrayList<>();
        stones.add(1);
        stones.add(2);
    
        printCollection(stones);
    }
}
