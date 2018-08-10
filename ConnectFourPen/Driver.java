import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Node game = new Node(new Board(), true);
        game.generate(6);
        game.minimax(6);
        while(game.children.size() > 0) {
            System.out.println(game.board);
            keyboard.nextLine();
            game.generate(7);
            game.minimax(7);
            game = game.makeBestMove();
        }
        System.out.println(game.board);
        System.out.println("Score is " + game.score);

            
    }
}