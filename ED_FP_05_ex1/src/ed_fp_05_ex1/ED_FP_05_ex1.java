package ed_fp_05_ex1;

import java.util.Iterator;

public class ED_FP_05_ex1 {
    
    public static void main(String[] args) throws EmptyCollectionException{
        
        OrderedList<String> lista1 = new OrderedList();
        
        int teste = 0;
        
        switch (teste) {
            case 0: 
                //teste para ordenar alguns elementos
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");

                Iterator it = lista1.iterator();

                while (it.hasNext()) {
                    String obj = (String) it.next();
                    System.out.println(obj);
                }
                
                break;

            case 1: 
                //teste para ordenar com todos os elemtos do array ocupados
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");
                lista1.add("E");

                Iterator it2 = lista1.iterator();

                while (it2.hasNext()) {
                    String obj = (String) it2.next();
                    System.out.println(obj);
                }
                
                break;

            case 2:
                //teste para ordenar com todos os elementos do array ocupados mais um para fazer expandCapacity do array
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");
                lista1.add("E");
                lista1.add("G");
                lista1.add("F");

                Iterator it3 = lista1.iterator();

                while (it3.hasNext()) {
                    String obj = (String) it3.next();
                    System.out.println(obj);
                }
                
                break;
        }
    }  
}
