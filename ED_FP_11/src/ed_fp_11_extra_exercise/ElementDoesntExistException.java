package ed_fp_11_extra_exercise;

public class ElementDoesntExistException extends Exception{
    public ElementDoesntExistException(){
        super();
    }
     
     public ElementDoesntExistException(String message) {
        super(message);
    }
}
