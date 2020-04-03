package ed_fp_08_ex2;

public class ED_FP_ex2 {

    public static void main(String[] args) {
        Carro car1 = new Carro("Mercedes", 150);
        Carro car2 = new Carro("BMW", 200);
        Carro car3 = new Carro("Ferrari", 350);
        Carro car4 = new Carro("Ford", 100);
        Carro car5 = new Carro("Peugeot", 150);
        Carro car6 = new Carro("Renault", 120);

        LinkedList test = new LinkedList();
        test.addHead(car1);
        test.addHead(car2);
        test.addHead(car3);
        test.addHead(car4);
        test.addHead(car5);
        test.print();
        System.out.println(LinkedLinearSearch.linearsearch(test,car4));
        System.out.println(test.size());
        System.out.println("-----------------------------------");
        
        DoubleLinkedOrderedList<Carro> test2 = new DoubleLinkedOrderedList();
        test2.add(car1);
        test2.add(car2);
        test2.add(car3);
        test2.add(car4);
        test2.add(car5);
        test2.add(car6);
        test2.toString();
        
        System.out.println(LinkedBinarySearch.binarySearch(test2, 0, 5,car1));
    }
}
