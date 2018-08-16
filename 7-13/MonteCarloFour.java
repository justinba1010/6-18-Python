import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
public class MonteCarloFour {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int fours = 0;
    int draws = 0;
    while(true) {
      //keyboard.nextLine();
      Deck ourDeck = new Deck();
      Card[] hand = new Card[5];
      for(int i = 0; i < 5; i++) {
        hand[i] = ourDeck.deal();
      }
      Hashtable<Card.Values, Integer> dict = new Hashtable<Card.Values, Integer>();
      for(int i = 0; i < 5; i++) {
        if(dict.get(hand[i].getValue()) == null) {
          //Not in our dictionary
          dict.put(hand[i].getValue(), 1);
        } else {
          int count = dict.get(hand[i].getValue());
          dict.put(hand[i].getValue(), count + 1);
        }
      }
      for(int i : dict.values()) {
        if(i == 4) {
          fours++;
        }
      }

      draws++;
      System.out.println((fours*100.0/draws) + "%");
    }
  }
}
