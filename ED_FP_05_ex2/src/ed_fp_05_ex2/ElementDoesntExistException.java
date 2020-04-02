package ed_fp_05_ex2;

public class ElementDoesntExistException extends Exception{
    
    public ElementDoesntExistException() {
        super();
    }
    
    public ElementDoesntExistException(String s){
        super(s);
    }
}
