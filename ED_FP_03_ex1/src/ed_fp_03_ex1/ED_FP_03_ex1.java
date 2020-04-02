package ed_fp_03_ex1;

public class ED_FP_03_ex1 {

    public static void main(String[] args) throws EmptyCollectionException{
        ArrayStack<Integer> a=new ArrayStack<>(2);
        
        a.push(1);
        System.out.println(a.toString());
        
        a.push(2);
        System.out.println(a.peek());
        System.out.println(a.toString());
        
        a.push(3);
        System.out.println(a.peek());
        System.out.println(a.toString());
        
        a.pop();
        System.out.println(a.peek());
        System.out.println(a.toString());
    }
}
