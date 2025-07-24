class Solution {
    final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        for(int[] dir : dirs){
            int cx = h + dir[0];
            int cy = w + dir[1];
            
            if(cx < 0 || cx >= board.length || cy < 0 || cy >= board[0].length) continue;
            if(!board[cx][cy].equals(color)) continue;
            answer++;
        }
        
        return answer;
    }
}