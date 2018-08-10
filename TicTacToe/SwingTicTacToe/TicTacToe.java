import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    private JPanel penPanel;
    private ourButton[][] board;
    
    private class ourButton extends JButton implements ActionListener{
        int value;
        ImageIcon X,O;
        public ourButton() {
            value = 0;
            X = new ImageIcon(this.getClass().getResource("X.png"));
            O = new ImageIcon(this.getClass().getResource("O.png"));
            this.addActionListener(this);
        }
        public void actionPerformed(ActionEvent e){
            value++;
            value %= 3;
            switch(value) {
                case 0:
                    setIcon(null);
                    break;
                case 1:
                    setIcon(X);
                    break;
                case 2:
                    setIcon(O);
                    break;
                }
                
        }           
    }
    
    
    public TicTacToe() {
        super("Pen Tic Tac Toe 2 Player");
        board = new ourButton[3][3];
        penPanel = new JPanel();
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Set our layout
        penPanel.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = new ourButton();
                penPanel.add(board[i][j]);
            }
        }
        add(penPanel);
        //setVisible(true);
        
    }
    public static void main(String[] args) {
        TicTacToe[] games = new TicTacToe[10];
        int i = 0;
        while(true) {
            games[i] = new TicTacToe();
            i++;
            if(i == 9) break;
            
        }
    }
}
