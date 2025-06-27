package game2048logic;

import game2048rendering.Side;
import static game2048logic.MatrixUtils.rotateLeft;
import static game2048logic.MatrixUtils.rotateRight;

/**
 * @author  Josh Hug
 */
public class GameLogic {
    /**
     * Modifies the board to simulate tilting the entire board to
     * the given side.
     *
     * @param board the current state of the board
     * @param side  the direction to tilt
     */
    private static void merge(int[] origin){
        int length = origin.length;
        boolean[] merged = new boolean[length];
        for(int i = length-2;i>=0;i--){
            if(origin[i]>0) {
                int j = i + 1;
                while (j < length && origin[j] == 0) {
                    j++;
                }
                int temp = origin[j-1];
                origin[j-1] = origin[i];
                origin[i] = temp;
                if(j < length && origin[j]==origin[j-1] && !merged[j-1] && !merged[j]){
                    origin[j] *=2;
                    origin[j-1] = 0;
                    merged[j] = true;
                }
            }
        }
        return;
    }

    public static void tilt(int[][] board, Side side) {
        // fill this in
        int length = board[0].length;
        int[] temp = new int[length];
        if (side == Side.NORTH) {
            // Don't you dare try to write all of your
            // code in this method. You will want to write
            // helper methods. And those helper methods should
            // have helper methods.
            for(int col = 0 ; col < length ;col++){
                for(int row = length-1; row >=0; row--){
                    temp[length-1-row] = board[row][col];
                }
                merge(temp);
                for(int row = length-1; row>=0; row--){
                    board[row][col] = temp[length-1-row];
                }
            }
            return;
        } else if (side == Side.EAST) {
            for(int row = 0 ; row < length ;row++){
                for(int col = 0; col < length; col++){
                    temp[col] = board[row][col];
                }
                merge(temp);
                for(int col = 0; col < length; col++){
                    board[row][col] = temp[col];
                }
            }
            return;
        } else if (side == Side.WEST) {
            for(int row = 0 ; row < length ;row++){
                for(int col = length-1; col >=0; col--){
                    temp[length-1-col] = board[row][col];
                }
                merge(temp);
                for(int col = length-1; col>=0; col--){
                    board[row][col] = temp[length-1-col];
                }
            }

            return;
        } else { // SOUTH
            for(int col = 0 ; col < length ;col++){
                for(int row = 0; row < length; row++){
                    temp[row] = board[row][col];
                }
                merge(temp);
                for(int row = 0; row < length; row++){
                    board[row][col] = temp[row];
                }
            }
            return;
        }
    }
}
