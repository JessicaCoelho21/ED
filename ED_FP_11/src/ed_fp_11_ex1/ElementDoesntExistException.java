package ed_fp_11_ex1;

public class ElementDoesntExistException extends Exception{
    public ElementDoesntExistException(){
        super();
    }
     
     public ElementDoesntExistException(String message) {
        super(message);
    }
}
