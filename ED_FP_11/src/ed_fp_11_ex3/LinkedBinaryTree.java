package ed_fp_11_ex3;

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Cria uma árvore binária vazia.
     */
    public LinkedBinaryTree() {
        this.count = 0;
        this.root = null;
    }

    /**
     * Cria uma árvore binária com o elemento especificado como sua raiz.
     * @param element o elemento que se tornará a raiz do novo binário árvore
     */
    public LinkedBinaryTree(T element) {
        this.count = 1;
        this.root = new BinaryTreeNode<>(element);
    }

    /**
     * Retorna a referencia do root
     * @return a referencia do root
     * @throws EmptyCollectionException colecao vazia
     */
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A arvore esta vazia");
        }

        return this.root.element;
    }

    /**
     * Retorna true se a arvore binaria estiver vazia,falso caso contrario
     * @return true se a arvore binaria estiver vazia
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Retorna o numero de elementos da arvore binaria
     * @return numero de elementos da arvore
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Retorna true se a arvore binaria conter um elemento que corresponde ao
     * elemento especificado
     * @param t elemento a ser procurado na arvore
     * @return true se contiver o elemento
     */
    @Override
    public boolean contains(T t) {
        return (this.findAgain(t, this.root) != null);
    }

    /**
     * Retorna uma referência ao elemento de destino especificado se ele for
     * encontrado em esta árvore binária. Lança um ElementDoesntExistException se
     * o destino especificado o elemento não foi encontrado na árvore binária.
     * @param targetElement o elemento que está sendo procurado nesta árvore
     * @return uma referência ao destino especificado
     * @throws ed_fp_11_ex3.ElementDoesntExistException
     */
    @Override
    public T find(T targetElement) throws ElementDoesntExistException {
        BinaryTreeNode<T> current = findAgain(targetElement, this.root);

        if (current == null) {
            throw new ElementDoesntExistException("binary tree");
        }

        return (current.element);
    }

    /**
     * Retorna uma referência ao elemento de destino especificado se ele for
     * encontrado em esta árvore binária.
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
     * Executa uma passagem inorder nesta árvore binária chamando um Método
     * inorder sobrecarregado e recursivo que começa com a raiz.
     * @return um iterador em ordem sobre essa árvore binária
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
     * Executa um percurso de pré-order nessa árvore binária ao chamar um método
     * de solicitação recursiva sobrecarregado, que começa com a raiz.
     * @return iterador
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
     * Executa uma passagem de postorder nesta árvore binária ao chamar um
     * método de classificação póstorder e recursivo que começa na raiz.
     * @return iterador
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
     * Executa uma passagem de levelorder nesta árvore binária ao chamar um
     * método de classificação levelorder e recursivo que começa na raiz.
     * @return iterador
     */
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
     * @param tempList 
     * @throws ed_fp_11_ex3.EmptyCollectionException 
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
