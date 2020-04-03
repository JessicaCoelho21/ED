package ed_fp_10_ex1;

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Creates a binary tree woth the specified element as its root
     * @param element the element that will become the root of the new binary tree
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<> (element);
    }

    /**
     * Returns a reference to the root element
     * @return a reference to the root
     */
    @Override
    public T getRoot() {
        return (T)this.root;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise
     * @return true if this binary tree is empty
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /**
     * Returns the number os elements in this binary tree
     * @return the integer number of elements in this tree
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Retorna true se a arvore binaria conter um elemento que corresponde ao elemento especificado
     * @param targetElement
     * @return 
     */
    @Override
    public boolean contains(T targetElement) {
        return (this.findAgain(targetElement, this.root) != null);
    }

    /**
     * Returns a reference to the specified target element if it is found in this
     * binary tree. Throws a NoSuchElementException if the specified target element
     * is not found in the binary tree
     * @param targetElement the element being sought in this tree
     * @returna reference to the specified target
     * @throws ElementDoesntExistException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementDoesntExistException{
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        
        if (current == null) {
            throw new ElementDoesntExistException("Binary Tree");
        }
        
        return (current.element);
    }
    
    /**
     * Returns a reference to the specified target element if it is found in this
     * binary tree
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     * @return 
     */
    public BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next){
        if (next == null) {
            return null;
        }
        
        if (next.element.equals(targetElement)) {
            return next;
        }
        
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        
        if(temp == null){
            temp = findAgain(targetElement, next.right);
        }
        
        return temp;
    }

    @Override
    public Iterator<T> interatorInOrder() {
        //Ter array em lista ligada não importa, desde que tenhamos um método para que a lista não se ordene
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inorder(this.root, tempList);
        
        return tempList.iterator();
    }
    
    /**
     * Performs a recursive inorder traversal.
     * @param node the node to be used as the root
     * for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList){
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    /**
     * Executa um percurso de pré-order nessa árvore binária ao chamar um método
     * de solicitação recursiva sobrecarregado, que começa com a raiz.
     *
     * @return iterador
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preorder(root, templist);

        return templist.iterator();
    }
    
    /**
     * Executa um percurso preorder recursivo
     *
     * @param node
     * @param tempList lista temporaria
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preorder(node.left, tempList);
            preorder(node.right, tempList);
        }
    }

    /**
     * Executa uma passagem de postorder nesta árvore binária ao chamar um
     * método de classificação póstorder e recursivo que começa na raiz.
     *
     * @return iterador
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postorder(root, templist);

        return templist.iterator();
    }

     /**
     * Executa uma passagem de post-order recursiva.
     *
     * @param node no
     * @param tempList lista temporaria
     */
    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            preorder(node.left, tempList);
            preorder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }
    
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        
        try {
            levelorder(this.root, tempList);
        } catch (EmptyCollectionException ex) {
            System.out.println("Empty Collection");
        }

        return tempList.iterator();
    }
    
    /**
     * Executa uma passagem de levelorder recursiva
     * @param node no
     * @param tempList lista temporaria
     * @throws ed_fp_10_ex1.EmptyCollectionException
     */
    protected void levelorder(BinaryTreeNode<T> node, UnorderedListADT<T> tempList) throws EmptyCollectionException {
        LinkedQueue<BinaryTreeNode<T>> queue = new LinkedQueue();
        
        if (node != null) {
            queue.enqueue(node);
            
            while (!queue.isEmpty()) {
                BinaryTreeNode<T> tempNode = queue.dequeue();
                tempList.addToRear(tempNode.element);
                
                if (tempNode.numChildren() > 0) {
                    if (tempNode.left != null) {
                        queue.enqueue(tempNode.left);
                    }
                    
                    if (tempNode.right != null) {
                        queue.enqueue(tempNode.right);
                    }
                }
            }
        }
    }
}
