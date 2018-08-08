import java.util.Scanner;
public class GameSelf {
    public static void main(String[] args) {
        int score = 0;
        while(score == 0) {
            Scanner keyboard = new Scanner(System.in);
            Board tictactoe = new Board();
            boolean move = true; //true = X; false = O
            while(!tictactoe.isOver()) {
                System.out.println(tictactoe);
                int row = -1;
                int column = -1;
                System.out.println(((move) ? "X" : "O") + "'s move");
                if(!move) {
                    Node game = new Node(tictactoe, move);
                    game.generate(9);
                    game.minimax(9);
                    tictactoe = game.children.get(0).board;
                } else {
                    Node game = new Node(tictactoe, move);
                    game.generate(9);
                    game.minimax(9);
                    tictactoe = game.children.get(0).board;
                }
                move = !move;
            }
            score = tictactoe.score;
            System.out.println("Game score was: " + tictactoe.score);
            System.out.println(tictactoe);
        }//for
    }//main                 
}//Gam