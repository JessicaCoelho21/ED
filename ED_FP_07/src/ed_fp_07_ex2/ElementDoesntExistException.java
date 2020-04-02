package ed_fp_07_ex2;

public class ElementDoesntExistException extends Exception{
    
    public ElementDoesntExistException() {
        super();
    }
    
    public ElementDoesntExistException(String s){
        super(s);
    }
}
