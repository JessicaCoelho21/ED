package ed_fp_10_ex1;

public class ElementDoesntExistException extends Exception{
    
    public ElementDoesntExistException() {
        super();
    }
    
    public ElementDoesntExistException(String s){
        super(s);
    }
}
