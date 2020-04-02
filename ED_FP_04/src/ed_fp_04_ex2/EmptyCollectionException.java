package ed_fp_04_ex2;

public class EmptyCollectionException extends Exception{
    public EmptyCollectionException() {
        super();
    }
    
    public EmptyCollectionException(String s){
        super(s);
    }
}
