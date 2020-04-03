package ed_fp_08_ex2;

public class ElementDoesntExistException extends Exception{
    
    public ElementDoesntExistException() {
        super();
    }
    
    public ElementDoesntExistException(String s){
        super(s);
    }
}
