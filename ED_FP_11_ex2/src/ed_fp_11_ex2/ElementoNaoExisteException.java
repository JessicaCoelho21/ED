/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_11_ex2;

/**
 *
 * @author Jéssica Beatriz
 */
public class ElementoNaoExisteException extends Exception{
    public ElementoNaoExisteException(){
        super();
    }
     
     public ElementoNaoExisteException(String message) {
        super(message);
    }
}
