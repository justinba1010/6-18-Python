class Card {

  private Suits suit;
  private Values value;

  public static String[] SuitsPrint = {
    "♥",
    "♦",
    "♠",
    "♣"
  };
  public static String[] ValuesPrint = {
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "0",
    "J",
    "Q",
    "K",
    "A"
  };

  public static enum Suits {
    HEART,
    DIAMOND,
    SPADE,
    CLUB
  };
  public static enum Values {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
  };
  public Card(Suits suit, Values value) {
    this.suit = suit;
    this.value = value;
  }//Card

  public Values getValue() {
    return this.value;
  }//getValue

  public Suits getSuit() {
    return this.suit;
  }//getSuit

  public String toString() {
    return (ValuesPrint[this.value.ordinal()] + SuitsPrint[this.suit.ordinal()]);
  }//toString
}//Card
