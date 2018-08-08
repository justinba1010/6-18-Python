
public class ArrayStack extends ArrayStack {
  private int[] stack;
  private int size;
  private static int resizeFactor = 8;

  public ArrayStack() {
    //When we write:        ArrayStack anArrayStack = new ArrayStack();
    //It will really call   ArrayStack anArrayStack = new ArrayStack(64);
    //This is called a default constructor, and is an example of a function overload
    this(25);
  }//ArrayStackInt

  public ArrayStack(int size) {
    this.stack = new int[size];
  }//ArrayStackInt

  public void push(int item) {
    if(this.size >= this.stack.length) {
      this.resize();
      /*
      //For this class this is how we will throw errors
      System.out.println("Error, stack overflow");
      return;//This exits the method(function)*/
    }//if stack overflows
    this.stack[this.size] = item;
    this.size++;
  }//push

  public int pop() {
    if(size == 0) {
      System.out.println("Empty stack");
      return 0;
    }//if
    this.size--;
    return this.stack[this.size]; //This returns the spot we have made the new index at
  }//pop

  private void resize() {
    System.out.println("Resizing array...");
    int[] newStack = new int[this.stack.length+this.resizeFactor];//Makes a new array thats a little bigger
    for(int i = 0; i < this.stack.length; i++) {
      newStack[i] = this.stack[i];//Replace newStack with old stack
      //Remember arrays are STATIC, they have limited size, and it is a hard problem to resize them
    }//for i
    this.stack = newStack; //The old stack will be thrown away(garbage collected), and the new array will be put into its spot
  }//resize

  public boolean isEmpty() {
    //Returns true if our stack is empty
    return this.size == 0;
  }//isEmpty
}//ArrayStackInt