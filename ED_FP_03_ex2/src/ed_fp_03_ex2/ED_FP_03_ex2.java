/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_03_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class ED_FP_03_ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedStack<Integer> test = new LinkedStack<>();
        
        System.out.println(test.isEmpty());
        
        test.push(1);
        test.push(2);
        test.push(3);
        
        System.out.println(test.toString());
        System.out.println(test.peek());
        
        test.push(4);
        
        System.out.println(test.size());
        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        
        test.pop();
        
        System.out.println(test.toString());
    }
}
