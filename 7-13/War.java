import java.util.Scanner;
class War {
    public static void main(String[] args) {
        int playerA_score = 26;
        int playerB_score = 26;
        Deck gameDeck = new Deck();
        Scanner keyboard = new Scanner(System.in);
        
        
        while(playerA_score > 0 && playerB_score > 0) {

            if(gameDeck.isEmpty()) {
                gameDeck.resetDeck();
                System.out.println("Deck is empty, shuffling");
            }//if
            Card playerA_card = gameDeck.deal();
            Card playerB_card = gameDeck.deal();
            
            System.out.println("Player A got a " + playerA_card.toString());
            System.out.println("Player B got a " + playerB_card.toString());
            
            
            if(playerA_card.getValue().ordinal() > playerB_card.getValue().ordinal()) {
                System.out.println("Player A won, his score is " + playerA_score);
                playerA_score++;
                playerB_score--;
            } else if(playerA_card.getValue().ordinal() < playerB_card.getValue().ordinal()) {
                System.out.println("Player B won, his score is " + playerB_score);
                playerA_score--;
                playerB_score++;
            } else {
                System.out.println("It's a tie.");
            }


        }
    }
}