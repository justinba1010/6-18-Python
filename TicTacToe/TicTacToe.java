import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TicTacToe extends JFrame {
  private JPanel ourPanel = new JPanel();
  private OXButton[][] buttons = new OXButton[3][3];

  private class OXButton extends JButton implements ActionListener {
    ImageIcon X,O;
    int value;
    public OXButton(){
      X=new ImageIcon(this.getClass().getResource("X.png"));
      O=new ImageIcon(this.getClass().getResource("O.png"));
      this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
      value++;
      value%=3;
      switch(value){
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

  public static void main(String[] args) {
    new TicTacToe();
  }

  public TicTacToe() {
    super("TicTacToe");
    setSize(400,400);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    ourPanel.setLayout(new GridLayout(3,3));
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        buttons[i][j] = new OXButton();
        ourPanel.add(buttons[i][j]);
      }
    }
    add(ourPanel);
    setVisible(true);

  }
}
