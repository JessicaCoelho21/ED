/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_ex3;

/**
 *
 * @author Jéssica Beatriz
 */
public class Contact implements Comparable{

    private String firstName, lastName, phone;
    
    /**
     * Configura esse contato com as informações especificadas.
     *
     * @param first a string representation of a first name
     * @param last a string representation of a last name
     * @param telephone a string representation of a phone number
     */
    public Contact(String first, String last, String telephone) {
        this.firstName = first;
        this.lastName = last;
        this.phone = telephone;
    }

    /**
     * Retorna uma descrição desse contato como uma sequência.
     *
     * @return a string representation of this contact
     */
    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName + "\t" + this.phone;
    }

    /**
     * Usa o sobrenome e o primeiro nome para determinar a ordem lexical.
     *
     * @param other the contact to be compared to this contact
     * @return the integer result of the comparison
     */
    @Override
    public int compareTo(Object other) {
        int result;
        if (lastName.equals(((Contact) other).lastName)) {
            result = firstName.compareTo(((Contact) other).firstName);
        } else {
            result = lastName.compareTo(((Contact) other).lastName);
        }
        return result;
    }
}
