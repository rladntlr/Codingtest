import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer>[] lanes = new ArrayDeque[board.length];

        for(int i = 0; i < board.length; i++){
            lanes[i] = new ArrayDeque<>();
        }

        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] > 0){
                    lanes[j].push(board[i][j]);
                }
            }
        }
        Deque<Integer> bucket = new ArrayDeque<>();
        int ans = 0;
        for(int move : moves){
            if(!lanes[move - 1].isEmpty()){
                int doll = lanes[move - 1].pop();
                if(!bucket.isEmpty() && bucket.peek() == doll){
                    bucket.pop();
                    ans+=2;
                }
                else bucket.push(doll);
            }
        }
        return ans;
    }
}