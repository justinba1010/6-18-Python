import java.util.ArrayList;
public class Board {
    public int[][] board;
    public int score;
    
    public Board() {
        board = new int[6][7];
        score = 0;
    }
    
    private int getRow(int column) {
        int row = 0;
        while(row < 6 && board[row][column] != 0) {
            row++;
        }
        if(row == 6) return -1;
        return row;
    }
    
    public boolean isLegalMove(int column) {
        if(score != 0) return false;
        int row = getRow(column);
        if(row == -1) return false;
        return true;
    }
    
    public void update() {
    }
    
    public boolean makeMove(int column, int player) {
        if(score != 0) return false;
        if(!isLegalMove(column)) return false;
        int row = getRow(column);
        board[row][column] = player;
        if(checkWinner(row, column)) {
            score = player;
        }
        return true;
    }
    
      public boolean onBoard(int row, int column) {
    return row >= 0 && row < 6 && column >= 0 && column < 7;
  }

  private boolean checkWinner(int row, int column) {
    int[][][] vectors = {   {{1,0},   {-1,0}},
                            {{0,1},   {0,-1}},
                            {{1,1},   {-1,-1}},
                            {{-1,1},  {1,-1}}
                        };
    int maxInARow = 1;
    for(int[][] directions : vectors) {
      int inARow = 1;
      for(int[] oneDirection : directions) {
        int newRow = row + oneDirection[0];
        int newColumn = column + oneDirection[1];
        while(onBoard(newRow, newColumn) && board[newRow][newColumn] == board[row][column]) {
          inARow++;
          newRow += oneDirection[0];
          newColumn += oneDirection[1];
        }
      }//for oneDirection
      if(inARow > maxInARow) maxInARow = inARow;
    }//for directions
    return maxInARow >= 4;
  }
  
  public Board copy() {
      Board newBoard = new Board();
      for(int i = 0; i < 6; i++) {
          for(int j = 0; j < 7; j++) {
              newBoard.board[i][j] = board[i][j];
            }
      }
      newBoard.score = score;
      return newBoard;
    }
              
  
  public ArrayList<Board> genLegalMoves(boolean turn) {
      int player = (turn) ? 1 : -1;
      ArrayList<Board> allLegalMoves = new ArrayList<Board>();
      for(int i = 0; i < 7; i++) {
          if(isLegalMove(i)) {
              Board newBoard = copy();
              newBoard.makeMove(i, player);
              allLegalMoves.add(newBoard);
            }
        }
        return allLegalMoves;
    }
    public boolean isOver() {
        if(score != 0) return false;
        for(int column = 0; column < 7; column++) {
            if(board[5][column] == 0) return false;
        }
        return true;
    }
    
    public String toString() {
        String s = "\n";
        for(int i = 5; i >= 0; i--) {
            for(int j = 0; j < 7; j++) {
                s += (board[i][j] == 0 ? " " : (board[i][j] == 1 ? "X" : "O"));
                if(j != 6) s += "|";
            }
            s += "\n";
        }
        return s;
    }
}