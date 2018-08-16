import java.util.Random;

class Deck {
  private int size;
  private Card[] deck;
  private Random rand;

  public Deck() {
    this.size = 0;
    this.rand = new Random();
    this.resetDeck();
  }

  public void resetDeck() {
    this.deck = new Card[52];
    this.size = 0;
    //Generating Deck
    for(Card.Values value : Card.Values.values()) {
      for(Card.Suits suit : Card.Suits.values()) {
        addCard(suit, value);
      }//for counting suits
    }//for counting values
    //Done generating deck
    //Shuffle the deck now
    this.shuffle();
  }//resetDeck

  private void addCard(Card.Suits suit, Card.Values value) {
    Card newCard = new Card(suit, value);
    if(this.size >= this.deck.length) {
      //Deck is full
      System.out.println("The deck is full. This is an error.");
      return;
    }//if
    //Deck is not full
    this.deck[this.size] = newCard;
    this.size++;
  }//addCard

  public Card deal() {
    if(this.size <= 0){
      System.out.print("The deck is empty. This is an error");
      return null;
    }
    //Deck is not empty
    this.size--;
    //System.out.println(this.deck[this.size]);
    return this.deck[this.size];
  }//deal

  private void shuffle() {
    //O(n) time complexity
    if(size < 2) return;
    for(int i = 0; i < this.size; i++) {
      int randomnumber = this.rand.nextInt(this.size);
      this.swap(i, randomnumber);
    }//for
  }//shuffle

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void swap(int i, int j) {
    Card iCard = this.deck[i];
    Card jCard = this.deck[j];
    this.deck[i] = jCard;
    this.deck[j] = iCard;
  }
}//Deck
