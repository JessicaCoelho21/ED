package ed_fp_04_ex1;

public class ED_FP_04_ex1 {

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
