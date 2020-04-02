/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_05_ex4;

import java.util.Iterator;

public class ED_FP_05_ex4 {

    public static void main(String[] args) throws EmptyCollectionException, ElementDoesntExistException{
        
        NonOrderedList<String> lista1 = new NonOrderedList();

        int teste = 5;

        switch (teste) {
            case 0: 
                //teste addToRear
                lista1.addToRear("A");
                lista1.addToRear("C");
                lista1.addToRear("D");
                lista1.addToRear("B");

                Iterator it1 = lista1.iterator();

                while (it1.hasNext()) {
                    String obj = (String) it1.next();
                    System.out.println(obj);
                }
                
                break;

            case 1: 
                //teste addToFront com lista vazia
                lista1.addToFront("A");

                Iterator it2 = lista1.iterator();

                while (it2.hasNext()) {
                    String obj = (String) it2.next();
                    System.out.println(obj);
                }
                
                break;

            case 2: 
                //teste addToFront
                lista1.addToFront("D");
                lista1.addToFront("B");
                lista1.addToFront("A");
                lista1.addToFront("C");

                Iterator it3 = lista1.iterator();

                while (it3.hasNext()) {
                    String obj = (String) it3.next();
                    System.out.println(obj);
                }
                
                break;

            case 3: 
                //teste addToFront com lista cheia
                lista1.addToFront("D");
                lista1.addToFront("B");
                lista1.addToFront("A");
                lista1.addToFront("C");
                lista1.addToFront("F");
                lista1.addToFront("H");

                Iterator it4 = lista1.iterator();

                while (it4.hasNext()) {
                    String obj = (String) it4.next();
                    System.out.println(obj);
                }
                
                break;

            case 4: 
                //teste com apenas dois elementos
                lista1.addToRear("D");
                lista1.addToFront("B");

                Iterator it5 = lista1.iterator();

                while (it5.hasNext()) {
                    String obj = (String) it5.next();
                    System.out.println(obj);
                }
                
                break;

            case 5:
                //testar addAfter, quando o target existe na lista
                lista1.addToRear("E");
                lista1.addToRear("D");
                lista1.addToRear("C");
                lista1.addToRear("B");
                lista1.addToRear("A");
                
                lista1.addAfter("Z","C");

                Iterator it6 = lista1.iterator();

                while(it6.hasNext()) {
                    String obj = (String) it6.next();
                    System.out.println(obj);
                }
                
                break;
                
            case 6: 
                //testar addAfter, quando o target não existe na lista
                lista1.addToRear("E");
                lista1.addToRear("D");
                lista1.addToRear("C");
                lista1.addToRear("B");
                lista1.addToRear("A");

                lista1.addAfter("Z","X");

                Iterator it7 = lista1.iterator();

                while (it7.hasNext()) {
                    String obj = (String) it7.next();
                    System.out.println(obj);
                }

                //System.out.println(lista1.toString());

                break;     
        }
    }
}
