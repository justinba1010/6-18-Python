class LinkedStack {
  private Node head;

  private class Node{
    protected int value;
    protected Node next;//This is called a pointer, we use it to point to another object

    public Node(int value) {
      this.value = value;
      this.next = null;//Null tells the computer there is nothing
    }//Node constructor
  }//Node

  public LinkedStack() {
    this.head = null;
  }//LinkedStack

  public void push(int value) {
    if(this.head == null) {
      //This means the stack is empty
      this.head = new Node(value);//This puts the head of the stack as a new node with a value
      return;
    }//if
    Node newNode = new Node(value);
    //This lets us POINT to the old head
    newNode.next = this.head;
    //Now that our old head is attached to newNode(the new head), we can make it the head
    this.head = newNode;
  }//push

  public int pop() {
    if(this.isEmpty()) {
      System.out.println("The stack is empty.");
      return 0;
    }//if empty
    int value = this.head.value;//We want the value before we throw the old top of the stack out
    this.head = this.head.next; //We move the head to the next node in the stack
    return value;
  }//pop

  public boolean isEmpty() {
    return this.head == null;
  }//isEmpty

}//LinkedStack