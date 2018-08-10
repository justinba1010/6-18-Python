import java.util.ArrayList;
import java.util.Collections;

public class Node {
    public Board board;
    public ArrayList<Node> children;
    public int score;
    public boolean turn;

    public Node(Board board, boolean turn) {
        this.board = board;
        this.children = new ArrayList<Node>();
        this.board.update();
        this.score = this.board.score;
        this.turn = turn;
    }//Node

    public void sort(boolean turn) {
        //Bubble sort our children
        for(int i = 0; i < this.children.size() - 1; i++) {
            for(int j = i; j < this.children.size(); j++) {
                if(turn && this.children.get(i).score < this.children.get(j).score) {
                    Collections.swap(this.children, i, j);
                }
                else if(!turn && this.children.get(i).score > this.children.get(j).score) {
                    Collections.swap(this.children, i, j);
                }
            }
        }
    }

    public void generate(int n) {
        if(n == 0) return;
        for(Board board : this.board.genLegalMoves(this.turn)) {
            Node child = new Node(board, !this.turn);
            this.children.add(child);
        }
        //Sort our move
        for(Node child : this.children) {
            child.generate(n-1);
        }//for
        Collections.shuffle(this.children);
    }

    public void minimax(int n) {
        if(n == 0) return;
        for(Node child : this.children) {
            child.minimax(n-1);
        }
        this.sort(this.turn);
        if(this.children.size() > 0) {
            //We have children underneath
            //We already sorted our children by score
            this.score = this.children.get(0).score;
        }
    }

    public Node makeBestMove() {
        System.out.print(this.board);
        return this.children.get(0);
    }
}
