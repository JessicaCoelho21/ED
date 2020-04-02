package ed_fp_04_ex2;

public class ED_FP_04_ex2 {

    public static void main(String[] args) throws EmptyCollectionException{
        CircularArrayQueue<String> c = new CircularArrayQueue<>();
        
        c.enqueue("A");
        c.enqueue("B");
        c.enqueue("C");
        c.enqueue("D");
        c.enqueue("E");

        c.dequeue();
        c.dequeue();
        c.dequeue();
        c.dequeue();

        c.enqueue("F");
        c.enqueue("J");
        c.dequeue();
        c.enqueue("J");
        c.enqueue("E");
        c.dequeue();
        c.enqueue("Z");
        System.out.println(c.toString());
    }
}
