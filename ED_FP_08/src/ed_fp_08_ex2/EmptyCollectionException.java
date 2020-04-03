package ed_fp_08_ex2;

public class EmptyCollectionException extends Exception{
    
    public EmptyCollectionException() {
        super();
    }
    
    public EmptyCollectionException(String s){
        super(s);
    }
}
