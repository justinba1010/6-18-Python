import java.util.ArrayList;

public class Board {
    public final static char X = 'X';
    public final static char O = 'O';
    public final static char B = ' ';
    
    public char[][] board;
    public int score;
    
    public Board() {
        this.board = new char[3][3];
        this.score = 0;
        int i = 0;
        while(i < 3) {
            for(int j = 0; j < 3; j++) {
                this.board[i][j] = B;
            }
            i++;
        }
    }//Board
    
    public boolean isLegalMove(int row, int column) {
        //Check if its in the board
        if(row >= 3 || row < 0 || column >= 3 || column < 0) return false;
        if(isOver()) return false;
        return this.board[row][column] == B;
    }//isLegal Move
    
    public boolean makeMove(char player, int row, int column) {
        if(player != O && player != X) return false;
        if(isLegalMove(row, column)) {
           this.board[row][column] = player;
           return true;
        }
        return false;
    }//makeMove
    
    public boolean isOver() {
        if(this.score != 0) return true;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.board[i][j] == B) return false;
            }
        }
        return true;
    }//isover
    
    public void update() {
        for(int i = 0; i < 3; i++) {
            //Horizontals
            if(this.board[i][0] != B && this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2]) {
                this.score = (this.board[i][0] == X) ? 10 : -10;
                return;
            }
            //Verticals
            if(this.board[0][i] != B && this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i]) {
                this.score = (this.board[0][i] == X) ? 10 : -10;
                return;
            }
        }
        //Diagonals
        if(this.board[0][0] != B && this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            this.score = (this.board[0][0] == X) ? 10 : -10;
            return;
        }
        if(this.board[2][0] != B && this.board[2][0] == this.board[1][1] && this.board[1][1] == this.board[0][2]) {
            this.score = (this.board[2][0] == X) ? 10 : -10;
            return;
        }
    }//update
    
    public String toString() {
        String s = "";
        for(int i = 0; i < 3; i++) {
            for(int j= 0; j < 3; j++) {
                s += this.board[i][j];
                if(j != 2) s += "|";
            }
            if(i != 2) s += "\n";
        }
        return s;
    }
    
    public Board copy() {
        Board newBoard = new Board();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                newBoard.board[i][j] = this.board[i][j];
            }
        }
        return newBoard;
    }
    
    public ArrayList<Board> genLegalMoves(boolean turn) {
        ArrayList<Board> moves = new ArrayList<Board>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.isLegalMove(i,j)) {
                    char player = (turn) ? X : O;
                    Board newBoard = this.copy();
                    newBoard.makeMove(player, i, j);
                    newBoard.update();
                    moves.add(newBoard);
                }
            }
        }
        return moves;
    }
                
}
