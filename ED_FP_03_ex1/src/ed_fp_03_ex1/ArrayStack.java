package ed_fp_03_ex1;

public class ArrayStack<T> implements StackADT<T> {
    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;
    
    /**
     * Creates an empty stack using the default capacity
     */
    public ArrayStack(){
        top = 0;
        stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    /**
     * Creates an empty stack using the specified capacity
     * @param initialCapacity represents the specified capacity
     */
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }
    
    /**
     * Adds the specified element to the top of this stack, expanding the capacity of the stack array if necessary.
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (size() == this.stack.length) {
            expandCapacity();
        }
        
        this.stack[this.top] = element;
        this.top++;
    }
    
    /**
     * Método para aumentar o tamanho da stack
     */
    public void expandCapacity(){
        T[] stack2 = (T[]) (new Object[this.size() + 1]);

        for(int i = 0; i < this.size(); i++) {
            stack2[i] = this.stack[i];
        }
        
        this.stack = stack2;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it
     * Throws an EmptyCollectionException if the stack is empty.
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        
        this.top--;
        T result = this.stack[this.top];
        this.stack[this.top] = null;
        
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * Throws an EmptyCollectionException if the stack is empty
     * @return T element on top of stack
     * @throws EmptyCollectionException if a peek is attempted on empty stack
     */
    @Override
    public T peek() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
  
        return this.stack[this.top - 1];
    }

    /** 
     * Returns true if this stack contains no elements.
     * @return boolean whether or not this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    /** 
     * Returns the number of elements in this stack.
     * @return int number of elements in this stack
     */
    @Override
    public int size() {
        return this.top;
    }

    /** 
     * Returns a string representation of this stack.
     * @return String representation of this stack
     */
    @Override
    public String toString() {
        String str = "";
        
        for(int i = 0; i < this.top; i++){
            str = str + this.stack[i] + " ";
        }
        
        return str + "";     
    }
}
