import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        Stack<Integer>[] machine = new Stack[board[0].length];
        for (int i = 0; i < machine.length; i++) machine[i] = new Stack<>();

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                machine[j].add(board[i][j]);
            }
        }

        int cnt = 0;
        for (int move : moves) {
            if (machine[move - 1].isEmpty()) continue;

            int doll = machine[move - 1].pop();
            if (!basket.isEmpty() && basket.peek() == doll) {
                cnt += 2;
                basket.pop();
            } else {
                basket.add(doll);
            }
        }
        return cnt;
    }
}
