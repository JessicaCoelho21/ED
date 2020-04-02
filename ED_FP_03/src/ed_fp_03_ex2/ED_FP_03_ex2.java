package ed_fp_03_ex2;

public class ED_FP_03_ex2 {

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
