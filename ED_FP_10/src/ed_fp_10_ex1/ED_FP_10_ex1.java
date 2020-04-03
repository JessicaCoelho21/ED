package ed_fp_10_ex1;

import java.util.Iterator;

public class ED_FP_10_ex1 {

    public static void main(String[] args) throws ElementDoesntExistException {
        LinkedBinarySearchTree<Integer> binary = new LinkedBinarySearchTree<>();
        
        binary.addElement(40);
        binary.addElement(30);
        binary.addElement(50);
        binary.addElement(55);
        binary.addElement(60);
        
        //binary.addElement(20);
        
        binary.addElement(25);
        binary.addElement(35);
        binary.addElement(20);
        binary.addElement(28);
        binary.addElement(34);
        binary.addElement(37);
        
        binary.removeElement(20);
        binary.removeElement(25);
        binary.removeElement(30);
        
        Iterator it =  binary.iteratorLevelOrder();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
