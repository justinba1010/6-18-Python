import java.util.Random;

public class Arrays {
    public static void main(String[] args) {
        int[] ourArray = new int[50];
        Random rand = new Random();
        printArray(ourArray);
        fillArray(ourArray, rand);
        //bubbleswap(ourArray);
        System.out.println("Sorting array in n^2 time.");
        printArray(ourArray);
    }
    
    public static void fillArray(int[] ourArray, Random rand) {
        for(int i = 0; i < ourArray.length; i++) {
            ourArray[i] = rand.nextInt();
        }
    }//fillArray
    
    public static void printArray(int[] ourArray) {
        for(int i = 0; i < ourArray.length; i++) {
            System.out.println(ourArray[i]);
        }
    }//printArray
    
    public static void bubbleSwap(int[] ourArray) {
        
    }
}