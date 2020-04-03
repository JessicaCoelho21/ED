package ed_fp_08_ex1;

public class ED_FP_08_ex1 {

    public static void main(String[] args) {
        Car[] arraycar = new Car[3];
        
        arraycar[0] = new Car("Jaguar", 100);
        arraycar[1] = new Car("Porsche", 500);
        arraycar[2] = new Car("Ferrari", 1000);
        
        System.out.println(LinearSearch.LinearSearch(arraycar, 0, 2, arraycar[2]));
        System.out.println(BinarySearch.BinarySearch(arraycar, 0, 2, arraycar[2]));
    }
}
