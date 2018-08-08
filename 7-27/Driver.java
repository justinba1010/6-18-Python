public class Driver {
    public static void main(String[] args) {
        long epoch = System.currentTimeMillis();
        AStack arrayStack = new AStack();
        
        LStack<Board> linkedStack = new LStack<Board>();
        for(int i = 0; i < 100000; i++) {
            linkedStack.push(new Board());
        }
        for(int i = 0; i < 100000; i++) {
            linkedStack.pop();
        }
        long epoch2 = System.currentTimeMillis();
        
        System.out.println("Done in " + (epoch2-epoch) + " milliseconds.");
    }
}