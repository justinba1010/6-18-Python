import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JButton[][] board;
    private JPanel controlPanel;
    private Node AI;
    
    private void makeBoard() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                JButton place = new JButton(""+AI.board.board[i][j]);
                place.setBounds(j*100+10, i*100+10,80, 80);
                getContentPane().add(place);
            }
        }
        JButton reset = new JButton("Reset");
        reset.setActionCommand("reset");
        reset.addActionListener(new ButtonClickListener());
        add(reset);
    }
    
    private void resetAI() {
        AI = new Node(new Board(), true);
        AI.generate(9);
        AI.minimax(9);
    }
    
    public GUI() {
        prepareGUI();
    }
    private void prepareGUI() {
        setTitle("Pen TicTacToe AI");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        GUI theGame = new GUI();
        theGame.prepareGUI();
        theGame.resetAI();
        theGame.makeBoard();
        theGame.setVisible(true);
        theGame.getContentPane().setLayout(null);

    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch(command) {
                case "reset":
                    resetAI();
                    makeBoard();
                    break;
                default:
                    break;
            }
            
        }
    }
}
        