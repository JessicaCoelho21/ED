package ed_fp_11_extra_exercise;

public class EmptyCollectionException extends Exception{
    public EmptyCollectionException(){
        super();
    }
    
    public EmptyCollectionException(String message) {
        super(message);
    }
}
