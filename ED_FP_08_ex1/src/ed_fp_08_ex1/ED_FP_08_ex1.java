/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_08_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class ED_FP_08_ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Car[] arraycar = new Car[3];
        
        arraycar[0] = new Car("Jaguar", 100);
        arraycar[1] = new Car("Porsche", 500);
        arraycar[2] = new Car("Ferrari", 1000);
        
        System.out.println(LinearSearch.LinearSearch(arraycar, 0, 2, arraycar[2]));
        System.out.println(BinarySearch.BinarySearch(arraycar, 0, 2, arraycar[2]));
    }
}
