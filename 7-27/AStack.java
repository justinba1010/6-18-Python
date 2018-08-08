public class AStack {
    private int[]   stack;
    private int     size;
    private static final int DEFAULT_SIZE = 10;
    
    public AStack() {
        this.stack = new int[DEFAULT_SIZE];
        this.size = 0;
    }
    
    public void push(int value) {
        if(this.size == this.stack.length) {
            System.out.println("Stack is full.");
            return;
        }
        
        this.stack[this.size] = value;
        this.size++;
    }
    
    public int pop() {
        if(this.size == 0) {
            System.out.println("Stack is empty.");
            return 0;
        }
        this.size--;
        return this.stack[this.size];
    }
}   