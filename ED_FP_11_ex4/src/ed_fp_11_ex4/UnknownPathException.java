/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_11_ex4;

/**
 *
 * @author Jéssica Beatriz
 */
public class UnknownPathException extends Exception {
    public UnknownPathException(){
        super();
    }
    
    public UnknownPathException(String message){
        super(message);
    }
}
