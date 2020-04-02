/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_04_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class ED_FP_04_ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException{
        LinkedQueue<String> que = new LinkedQueue<>();

        que.enqueue("A");
        que.enqueue("B");
        que.enqueue("C");
        que.enqueue("D");
        System.out.println(que.toString());

        System.out.println(que.dequeue());
        System.out.println(que.dequeue());
        que.enqueue("K");
        System.out.println(que.first());
        System.out.println(que.toString());
    }
    
}
