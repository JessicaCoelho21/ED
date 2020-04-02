/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

/**
 * BinarySearchTreeADT defines the interface to a binary search tree.
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    
    /**
     * Adds the specified element to the proper location in this tree.
     * @param element the element to be added to this tree
     */
    public void addElemet(T element);
    
    /**
     * Removes all occurences of the specified element from this tree
     * @param targetElement the element that the list will have all instances of it removed
     * @return 
     * @throws ed_fp_10_ex1.ElementDoesntExistException 
     */
    public T removeElement(T targetElement) throws ElementDoesntExistException;
    
    /**
     * Remove os elementos que correspondem ao elemento de destino especificado
     * do binário árvore de pesquisa Lança uma ElementNotFoundException se o
     * destino sepcificado o elemento não foi encontrado na árvore de pesquisa
     * binária.
     * @param targetElement
     * @throws ed_fp_10_ex1.ElementDoesntExistException
     */
    public void removeAllOccurrences(T targetElement) throws ElementDoesntExistException;
    
    /**
     * Removes and returns the smallest element from this tree.
     * @return the smallest element from this tree.
     * @throws ed_fp_10_ex1.EmptyCollectionException
     */
    public T removeMin() throws EmptyCollectionException;
    
    /**
     * Removes and returns the largest element from this tree.
     * @return the largest element from this tree
     * @throws ed_fp_10_ex1.EmptyCollectionException
     */
    public T removeMax() throws EmptyCollectionException;
    
    /**
     * Returns a reference to the smallest element in this tree
     * @return a reference to the smallest element in this tree
     * @throws ed_fp_10_ex1.EmptyCollectionException
     */
    public T findMin() throws EmptyCollectionException;
    
    /**
     * Returns a reference to the largest element in this tree
     * @return a reference to the largest element in this tree
     * @throws ed_fp_10_ex1.EmptyCollectionException
     */
    public T findMax() throws EmptyCollectionException;
}
