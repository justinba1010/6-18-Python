
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GUI2 extends Applet implements MouseListener{
    private Image display;//Frame
    private Graphics drawingArea;//Canvas
    private int height;
    private int width;
    private boolean mouse;
    private int xpos;
    private int ypos;
    private Node tictactoe;
    private static Color X = Color.blue;
    private static Color O = Color.red;
    private static Color B = Color.black;
    private boolean start;
    
    public void init() {
        mouse = false;
        addMouseListener(this);
        display = createImage(getSize().width, getSize().height);
        drawingArea = display.getGraphics();
        tictactoe = new Node(new Board(), true);
        tictactoe.generate(9);
        tictactoe.minimax(9);
        start = false;
    }
  
  
  
    public void paint(Graphics g) {
       g.drawImage(display, 0, 0, null);
    }//paint
    
    public void mousePressed(MouseEvent e)
   {
   }
   public void mouseReleased(MouseEvent e)
   {
    }
    public void mouseEntered(MouseEvent me)
    {
    
    }
    public void mouseClicked(MouseEvent me)
    {
         if(tictactoe.board.isOver()){
             tictactoe = new Node(new Board(), true);
             tictactoe.generate(9);
             tictactoe.minimax(9);
             start = false;
             
         }
         if(start) tictactoe = tictactoe.makeBestMove();
         start = true;
         for(int i = 0; i < 3; i++) {
             for(int j = 0; j < 3; j++) {
                 Color ourcolor = Color.white;
                 switch(tictactoe.board.board[i][j]) {
                     case 'X':
                        ourcolor = X;
                        break;
                     case 'O':
                        ourcolor = O;
                        break;
                     case ' ':
                        ourcolor = B;
                        break;
                     default:
                        break;
                 }
                 drawingArea.setColor(ourcolor);
                 drawingArea.fillRect(j*100+10, i*100+10, 80,80);
                 repaint();
                }
            }
   }
   public void mouseExited(MouseEvent e)
   {
     mouse = false;
   }
  
}
  
  