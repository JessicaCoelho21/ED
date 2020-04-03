package ed_fp_12_ex4;

public class ElementDoesntExistException extends Exception{
    public ElementDoesntExistException(){
        super();
    }
     
     public ElementDoesntExistException(String message) {
        super(message);
    }
}
