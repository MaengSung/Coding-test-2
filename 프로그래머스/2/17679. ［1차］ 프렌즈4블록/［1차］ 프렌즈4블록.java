import java.util.Stack;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        int res = 0;

        for(int i = 0; i < m; i++){
            map[i] = board[i].toCharArray();
        }

        while(true){
            int prev = res;
            res += checkMap(m, n, map);
            if(prev == res) break;
            downMap(map);
        }

        return res;
    }

    private void downMap(char[][] map) {
        for(int i = 0; i < map[0].length; i++){
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < map.length; j++){
                if(map[j][i] == '.') continue;
                stack.push(map[j][i]);
                map[j][i] = '.';
            }

            int idx = map.length - 1;
            while(!stack.isEmpty()){
                map[idx--][i] = stack.pop();
            }
        }
    }

    private static int checkMap(int m, int n, char[][] map) {
        boolean[][] visited = new boolean[m][n];
        int cnt = 0;
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                char block = map[i][j];
                if(block == '.') continue;
                if(block == map[i][j+1] && block == map[i+1][j] && block == map[i+1][j+1]){
                    visited[i][j] = true;
                    visited[i+1][j] = true;
                    visited[i+1][j+1] = true;
                    visited[i][j+1] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        return cnt;
    }
}