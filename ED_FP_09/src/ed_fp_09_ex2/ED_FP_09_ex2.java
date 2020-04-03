package ed_fp_09_ex2;

import java.util.Iterator;

public class ED_FP_09_ex2 {

    public static void main(String[] args) {
        Integer[] a = {1, 2, 7, 4, null, 5, 6};
        ArrayBinaryTree<Integer[]> tree = new ArrayBinaryTree<>(a);

        Iterator c = tree.iteratorInOrder();
        
        /*
        Iterator c = tree.iteratorPreOrder();  
        Iterator c = tree.iteratorPostOrder();
        Iterator c = tree.iteratorLevelOrder();
        */
        
        while (c.hasNext()) {
            System.out.print(c.next() + " ");
        }
    }
}
