public class LStack<T> {
    protected class Node {
        public T data;
        public Node next;
        public Node(T value) {
            this.data = value;
            this.next = null;
        }
    }
    
    public LStack() {
        this.head = null;
    }
    private Node head;
    
    public void push(T value) {
        Node pancake = new Node(value);
        pancake.next = this.head;
        this.head = pancake;
    }
    
    public T pop() {
        if(this.head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        T data = this.head.data;
        this.head = this.head.next;
        return data;
    }
}
