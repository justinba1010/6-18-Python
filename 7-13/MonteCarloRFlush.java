import java.util.Scanner;
public class MonteCarloRFlush {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int rf = 0;
    int draws = 0;
    boolean cont = false;
    while(true) {
      //keyboard.nextLine();
      boolean Ace = false;
      boolean King = false;
      boolean Queen = false;
      boolean Jack = false;
      boolean Ten = false;
      cont = false;
      Deck ourDeck = new Deck();
      Card[] hand = new Card[5];
      for(int i = 0; i < 5; i++) {
        hand[i] = ourDeck.deal();
        //Check value
        if(hand[i].getValue() == Card.Values.ACE) Ace = true;
        if(hand[i].getValue() == Card.Values.KING) King = true;
        if(hand[i].getValue() == Card.Values.QUEEN) Queen = true;
        if(hand[i].getValue() == Card.Values.JACK) Jack = true;
        if(hand[i].getValue() == Card.Values.TEN) Ten = true;
        //Check suits match
        if(i > 0) {
          if(hand[i].getSuit() != hand[i-1].getSuit()) {
            cont = true;
            break;
          }
        }
      }
      draws++;
      if(cont) {
        continue;
      }
      if(Ace && King && Queen && Jack && Ten) rf++;
      System.out.println(rf*100.0/draws+ "%");
    }
  }
}
