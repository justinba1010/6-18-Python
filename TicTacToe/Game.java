import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Board tictactoe = new Board();
        boolean move = true; //true = X; false = O
        while(!tictactoe.isOver()) {
            System.out.println(tictactoe);
            int row = -1;
            int column = -1;
            System.out.println(((move) ? "X" : "O") + "'s move");
            if(!move) {
                while(!tictactoe.isLegalMove(row, column)){
                    System.out.println("Enter a row:\t ");
                    row = keyboard.nextInt();
                    System.out.println("Enter a column:\t ");
                    column = keyboard.nextInt();
                }
                tictactoe.makeMove((move) ? 'X' : 'O', row, column);
                tictactoe.update();
            } else {
                Node game = new Node(tictactoe, move);
                game.generate(9);
                game.minimax(9);
                tictactoe = game.children.get(0).board;
            }
            move = !move;
        }
        System.out.println("Game score was: " + tictactoe.score);
    }//main
}//Gam