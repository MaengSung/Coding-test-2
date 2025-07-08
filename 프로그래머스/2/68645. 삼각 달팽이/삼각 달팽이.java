import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n+1][n+1];
        map[1][1] = 1;

        int limit = n * (n+1) / 2;
        int next = 2;

        int x = 1;
        int y = 1;
        int turn = 1;
        while (next <= limit) {
            switch (turn) {
                case 1:
                    if (x + 1 <= n && map[x + 1][y] == 0) {
                        map[x + 1][y] = next++;
                        x++;
                    } else {
                        turn = 2;
                    }
                    break;
                case 2:
                    if (y + 1 <= n && map[x][y + 1] == 0) {
                        map[x][y + 1] = next++;
                        y++;
                    } else {
                        turn = 3;
                    }
                    break;
                case 3:
                    if (map[x - 1][y - 1] == 0) {
                        map[x - 1][y - 1] = next++;
                        x--;
                        y--;
                    } else {
                        turn = 1;
                    }
                    break;
            }
        }

        int idx = 0;
        int[] res = new int[limit];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 0) break;
                res[idx++] = map[i][j];
            }
        }

        return res;
    }
}