import java.util.Scanner;
public class MonteCarloFlush {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int nonflushes = 0;
    int draws = 0;
    while(true) {
      //keyboard.nextLine();
      Deck ourDeck = new Deck();
      Card prev = ourDeck.deal();
      Card next = ourDeck.deal();
      int i = 0;
      for(i = 0; i < 3; i++) {
        if(prev.getSuit() == next.getSuit()) {
          //We are good we can still get a flush
          prev = next;
          next = ourDeck.deal();
        } else {
          break;
        }
      }
      if(i != 3) nonflushes++;
      draws++;
      System.out.println(nonflushes*1.0/draws);
    }
  }
}
