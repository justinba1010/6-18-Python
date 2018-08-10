import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeAI extends JFrame implements KeyListener {
    private JPanel penPanel;
    private ourButton[][] board;
    private JButton[] garbage;
    private Node AI;
    
    
    public TicTacToeAI() {
        super("Pen Tic Tac Toe AI");
        board = new ourButton[3][3];
        penPanel = new JPanel();
        AI = new Node(new Board(), true);
        AI.generate(9);
        AI.minimax(9);
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Set our layout
        penPanel.setLayout(new GridLayout(4,3));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = new ourButton();
                penPanel.add(board[i][j]);
            }
        }
        
        garbage = new JButton[3];
        for(int i = 0; i < 3; i++) {
            garbage[i] = new JButton();
            garbage[i].addKeyListener(this);
            penPanel.add(garbage[i]);
        }
        
        add(penPanel);
        addKeyListener(this);
        setVisible(true);
        setFocusable(true);


        
    }
    public static void main(String[] args) {
        new TicTacToeAI();
    }
    
    public void keyPressed(KeyEvent keyboard) {
        System.out.println("Button is pressed.");
        if(keyboard.getKeyCode() == KeyEvent.VK_SPACE) {
            if(AI.children.size() == 0 || AI.score != 0) {
                //Game is over
                AI = new Node(new Board(), true);
                AI.generate(9);
                AI.minimax(9);
                //Reset Game
            } else {
            AI = AI.makeBestMove(); }
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    char XO = AI.board.board[i][j];
                    int z = (XO == ' ') ? 0 : ((XO == 'X') ? 1 : -1);
                    board[i][j].update(z);
                }
            }

        }
    }
    public void keyReleased(KeyEvent keyboard) {
        System.out.println("Button is released.");
    }
    public void keyTyped(KeyEvent keyboard) {
        System.out.println("Button is typed.");
    }
    
    private class ourButton extends JButton {
        ImageIcon X,O;
        public ourButton() {
            X = new ImageIcon(this.getClass().getResource("X.png"));
            O = new ImageIcon(this.getClass().getResource("O.png"));
        }
        public void update(int spot){
            switch(spot) {
                case 1:
                    setIcon(X);
                    break;
                case -1:
                    setIcon(O);
                    break;
                default:
                    setIcon(null);
                    break;
            }
        }           
    }
}