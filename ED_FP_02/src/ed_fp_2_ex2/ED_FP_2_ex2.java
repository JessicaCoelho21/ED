package ed_fp_2_ex2;

public class ED_FP_2_ex2 {

    public static void main(String[] args) {
        LinkedListNosSentinela<Integer> a = new LinkedListNosSentinela<>();

        a.add(100);
        a.add(200);
        a.add(250);
        
        a.print();

        a.remove(100);
        a.print();
    }
}
