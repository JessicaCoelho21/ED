package ed_fp_05_ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderedList<T extends Comparable<T>> extends ArrayList<T> implements OrderedListADT<T> {
        
    /**
     * Adds the specified element to this list at the proper location
     * @param element elemento a adicionar
     */
    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            Comparable<T> x = (Comparable<T>) element;
            
            //Se a lista estiver cheia
            if(this.rear == this.list.length){
                this.expandCapacity();
            }
            
            //Inserção no início com o array vazio
            if (this.isEmpty()) {
                this.list[this.rear] = element;
                this.rear++;
                
                return;
            }            
            //Inserção a meio
            else {
//                int i = 0;
//                while(i < this.rear){
//                    if(x.compareTo(this.list[i]) < 0){
//                        i++;
//                    }
//                }
//                
//                for (int j = this.rear - 1; j >= i; j--) {
//                    this.list[j + 1] = this.list[j];
//                }
//                        
//                this.list[i] = element;
//                this.rear++;
                
                for (int i = 0; i < this.rear; i++) {
                    if (x.compareTo(this.list[i]) < 0) {
                        for (int j = this.rear - 1; j >= i; j--) {
                            this.list[j + 1] = this.list[j];
                        }
                        
                        this.list[i] = element;
                        this.rear++;
                        
                        return;
                    }
                }
            }
            
            //Inserção no fim
            this.list[this.rear] = element;
            this.rear++;
        }
        
        else{
            try {
                throw new NonComparableException("Nao e comparavel");
            }
            
            catch (NonComparableException ex) {
                Logger.getLogger(OrderedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
