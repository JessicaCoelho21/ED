package ed_fp_09_ex1;

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
        return (T) this.root;
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
     * Returns the number of elements in this binary tree
     * @return ihe integer number of elements in this tree
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns true if the binaru tree contains an element that matches the
     * specified element and false otherwise
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
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
        BinaryTreeNode<T> current = findAgain(targetElement, this.root);
        
        if (current == null) {
            throw new ElementDoesntExistException("Binary Tree");
        }
        
        return (current.element);
    }
    
    /**
     * Retorna uma referência ao elemento de destino especificado se ele for
     * encontrado em esta árvore binária.
     *
     * @param targetElement o elemento que está sendo procurado nesta árvore
     * @param next o elemento para começar a procurar
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }

        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inorder(this.root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }
    
    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preorder(this.root, templist);

        return templist.iterator();
    }
    
    /**
     * Executa um percurso preorder recursivo
     * @param node no
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
     * Performs a postorder traversal on this binary tree by calling an
     * overloaded, recursive postorder method that starts with the root
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postorder(this.root, templist);

        return templist.iterator();
    }

    /**
     * Executa uma passagem de post-order recursiva.
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
    
    /**
     * Performs a levelorder traversal on this binary tree, using a queue
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        try {
            levelorder(this.root, tempList);
        } catch (EmptyCollectionException ex) {
            System.out.println("Erro");
        }

        return tempList.iterator();
    }
    
    /**
     * Executa uma passagem de levelorder recursiva
     * @param node no
     * @param tempList lista temporaria
     * @throws ed_fp_09_ex1.EmptyCollectionException
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
