public class StackDriver {
  public static void main(String[] args) {
    //We want an INSTANCE of an array stack
    //Basically we are making an OBJECT that is an ArrayStack
    ArrayStack anArrayStack = new ArrayStack();
    //Fill the array with the numbers 1...70
    for(int i = 1; i < 27; i++) {
      anArrayStack.push(i);
    }//for i
    //Read stack
    while(!anArrayStack.isEmpty()) {//This makes sure we stop when the stack is empty (no more pancakes)
      System.out.println("The item popped from the Array Stack:\t"+anArrayStack.pop());
      //This will first run pop() which returns the item at the top of the stack, like a stack of pancakes
    }//while stack is not empty

    //We want an INSTANCE of a linked stack
    LinkedStack aLinkedStack = new LinkedStack();
    //Fill the array with the numbers 1...70
    for(int i = 1; i < 50; i++) {
      aLinkedStack.push(i);
    }//for i
    //Read stack
    while(!aLinkedStack.isEmpty()) {//This makes sure we stop when the stack is empty (no more pancakes)
      System.out.println("The item popped from the Linked Stack:\t"+aLinkedStack.pop());
      //This will first run pop() which returns the item at the top of the stack, like a stack of pancakes
    }//while stack is not empty
  }//main
}//StackDriver