/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_10_ex1;

/**
 *
 * @author Jéssica Beatriz
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{
    
    /**
     * Creates an empty binary search tree
     */
    public LinkedBinarySearchTree(){
        super();
    }
    
    /**
     * Creates a binary search with the specified element as its root
     * @param element the element that will be the root of the new binary search tree
     */
    public LinkedBinarySearchTree(T element){
        super(element);
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its key value. Note that
     * equal elements are added to the right.
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElemet(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
        Comparable<T> comparableElement = (Comparable<T>) element;
        
        /**
         * Se a árvore estiver vazia, o elemento a adicionar torna-se no 
         * elemento root
         */
        if (isEmpty()) {
            this.root = temp;
        }
        
        /**
         * Se não, o elemento atual é a root. Se o elemento ainda não estiver
         * adicionado, se o elemento a adicionar for menor que o elemento atual,
         * e se o elemento à esquerda do atual estiver nulo, essa posição fica
         * com o elemento a adicionar
         */
        else{
            BinaryTreeNode<T> current = this.root;
            boolean added = false;
            while(!added){
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    }
                    
                    /**
                     * Se não, o elemento atual passa a ser o elemento à 
                     * esquerda
                     */
                    else{
                        current = current.left;
                    }
                }
                
                /**
                 * Se não, se o elemento à direita do atual estiver nulo, toma o
                 * valor do elemento a adicionar
                 */
                else{
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    }
                    
                    /**
                     * Se não, o elemento atual passa a ser o elemento à direita
                     */
                    else{
                        current = current.right;
                    }
                }
            }
        }
        
        //número de elementos da árvore é incrementado
        this.count++;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it. Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary
     * search tree
     * @throws ElementDoesntExistException if an element not found
     * exception occurs
     */
    @Override
    public T removeElement(T targetElement) throws ElementDoesntExistException{
        T result = null;
        
        /**
         * Se a árvore não estiver vazia, o elemento passado por parâmetro é 
         * comparado com a raíz da árvore. Caso seja igual, result obtem o valor
         * do elemento root, a root é substituída e é diminuído o número de
         * elementos da árvore
         */
        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(this.root.element)) {
                result = this.root.element;
                this.root = replacement(this.root);
                this.count--;
            }
            
            else{
                //árvore apenas com o root
                BinaryTreeNode<T> current, parent = this.root;
                boolean found = false;
                
                /**
                 * Se o elemento passado por parâmetro for menor que o elemento
                 * root, passamos para o elemento que está à esquerda da root
                 */
                if (((Comparable) targetElement).compareTo(this.root.element) < 0) {
                    current = this.root.left;
                }
                
                /**
                 * Se o elemento passado por parâmetro for maior que o elemento
                 * root, passamos para o elemento que está à direita da root
                 */
                else{
                    current = this.root.right;
                }
                
                /**
                 * Enquanto o elemento atual não for null e não tivermos
                 * encontrado o elemento a remover
                 */
                while(current != null && !found){
                    /**
                     * Se o elemento passado por parâmetro for igual ao elemento
                     * atual, diminuímos o número de elementos da árvore e 
                     * atribui-se o valor desse elemento a result
                     */
                    if (targetElement.equals(current.element)) {
                        found = true;
                        this.count--;
                        result = current.element;
                        
                        /**
                         * Se o elemento atual for igual ao elemento que está
                         * à esquerda do elemento pai, substituímos esse 
                         * elemento pelo atual
                         */
                        if (current == parent.left) {
                            parent.left = replacement(current);
                        }
                        
                        /**
                         * Se não, substituímos o elemento à esquerda do 
                         * elemento pai pelo atual
                         */
                        else{
                            parent.right = replacement(current);
                        }
                    }
                    
                    /**
                     * Se não, o elemento pai fica o elemento atual
                     * Se o elemento passado por parâmetro for maior que o 
                     * elemento atual, passamos para o elemento à esquerda
                     */
                    else{
                        parent = current;
                        
                        if (((Comparable) targetElement).compareTo(current.element) < 0) {
                            current = current.left;
                        }
                        
                        /**
                         * Se não, passamos para o elemento à direita
                         */
                        else{
                            current = current.right;
                        }
                    }
                }
                    
                /**
                 * Se não for encontrado, lança exceção
                 */
                if (!found) {
                    throw new ElementDoesntExistException("Binary Search Tree");
                }
            }
        }
        
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node){
        BinaryTreeNode<T> result = null;
        
        /**
         * Se o nó à direita e à esquerda forem nulos, result é nulo
         */
        if((node.left == null) && (node.right == null)) {
            result = null;
        }
        
        /**
         * Se o nó à esquerda não for nulo mas o nó à direita for, result é o nó
         * à esquerda
         */
        else if((node.left != null) && (node.right == null)) {
            result = node.left;
        }
        
        /**
         * Se o nó à direita não for nulo mas o nó à esquerda for, result é o nó
         * à direita
         */
        else if((node.left == null) && (node.right != null)) {
            result = node.right;
        }
        
        /**
         * Se não, o elemento atual é o nó à direita, e o elemento pai o nó
         */
        else{
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            /**
             * Enquanto o elemento à esquerda do atual não for nulo, o elemento
             * pai passa a ser o atual, e o atual passa a ser o elemento à sua
             * esquerda
             */
            while(current.left != null){
                parent = current;
                current = current.left;
            }
            
            /**
             * Se o nó à direita for igual ao nó atual, o elemento à esquerda
             * toma o valor do nó à esquerda do nó
             */
            if (node.right == current) {
                current.left = node.left;
            }
            
            /**
             * Se não, o elemento à esquerda do pai toma o valor do elemento à
             * direita do atual, o elemento à direita do atual toma o valor do
             * elemento à direira do nó, e o elemento à esquerda do atual toma o
             * valor do elemento à esquerda do nó
             */
            else{
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            
            result = current;
        }
        
        return result;
    }
    
    /**
     * Remove os elementos que correspondem ao elemento de destino especificado
     * do binário árvore de pesquisa Lança uma ElementNotFoundException se o
     * destino sepcificado o elemento não foi encontrado na árvore de pesquisa
     * binária.
     * @param targetElement
     * @throws ed_fp_10_ex1.ElementDoesntExistException
     */
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementDoesntExistException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Remove o nó com o menor valor da árvore de pesquisa binária e retorna uma
     * referência ao seu elemento. Lança uma EmptyBinarySearchTreeException se a
     * árvore de pesquisa binária estiver vazia.
     * @throws EmptyCollectionException
     */
    @Override
    public T removeMin() throws EmptyCollectionException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Remove o nó com o valor mais alto da árvore de pesquisa binária e retorna
     * uma referência ao seu elemento. Lança uma EmptyBinarySearchTreeException
     * se a árvore de pesquisa binária estiver vazia.
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeMax() throws EmptyCollectionException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna o elemento com o menor valor na árvore de pesquisa binária. isto
     * não remove o nó da árvore de pesquisa binária. Lança um
     * EmptyBinarySearchTreeException se a árvore de pesquisa binária estiver
     * vazia
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T findMin() throws EmptyCollectionException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retorna o elemento com o valor mais alto na árvore de pesquisa binária. isto
     * não remove o nó da árvore de pesquisa binária. Lança um
     * EmptyBinarySearchTreeException se a árvore de pesquisa binária estiver vazia.
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T findMax() throws EmptyCollectionException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
