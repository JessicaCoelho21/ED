package ed_fp_12_ex1;

public class EmptyCollectionException extends Exception{
    public EmptyCollectionException(){
        super();
    }
    
    public EmptyCollectionException(String message) {
        super(message);
    }
}
