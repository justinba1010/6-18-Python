
/**
 * Write a description of class Array here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;
public class Array
{
    // instance variables - replace the example below with your own
    public int[][] Array2D;
    public char[][] Array2DChar;
    public double[][] Array2DDouble;
    public int[][][] Array3D;
    
    public Array() {
        this.Array2D = new int[5][5];
        this.Array2DChar = new char[5][5];
        this.Array2DDouble = new double[5][5];
        this.Array3D = new int[3][3][3];
        Random r = new Random();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                char c = (char)(r.nextInt(26) + 'a');
                int x = r.nextInt(100) - 50;
                double d = r.nextDouble();
                this.Array2D[i][j] = x;
                this.Array2DChar[i][j] = c;
                this.Array2DDouble[i][j] = d;
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    this.Array3D[i][j][k] = r.nextInt(100) - 50;
                }
            }
        }
    }
}
