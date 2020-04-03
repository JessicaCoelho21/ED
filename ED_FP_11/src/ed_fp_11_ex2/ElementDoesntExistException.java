package ed_fp_11_ex2;

public class ElementDoesntExistException extends Exception{
    public ElementDoesntExistException(){
        super();
    }
     
     public ElementDoesntExistException(String message) {
        super(message);
    }
}
