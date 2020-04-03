package ed_fp_09_ex1;

import java.util.Iterator;

public class ED_FP_09_ex1 {

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> b = new LinkedBinaryTree<>(1);

        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> b7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> b4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> b5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> b6 = new BinaryTreeNode<>(6);

        b.root.setLeft(b2);
        b.root.setRight(b7);

        b2.setLeft(b4);

        b7.setLeft(b5);
        b7.setRight(b6);

        /*
        System.out.println(b.size());
        
        Iterator a = b.iteratorInOrder();
        Iterator a = b.iteratorPreOrder();
        Iterator a = b.iteratorPostOrder();
        */
        Iterator a = b.iteratorLevelOrder();

        while (a.hasNext()) {
            System.out.print(a.next() + " ");
        }
    }
}
