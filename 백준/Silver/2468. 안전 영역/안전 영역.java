import java.io.*;
import java.util.*;

public class Main {
    static int n, maxCnt, maxLimit;
    static int[][] area;
    static boolean[][] vis;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void bfs(int x, int y, int limit) {
        Queue<int[]> q = new LinkedList<>();
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny] && area[nx][ny] > limit) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        area = new int[n][n];
        maxLimit = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxLimit = Math.max(area[i][j], maxLimit);
            }
        }
        
        maxCnt = 0;
        for (int limit = 0; limit <= maxLimit; limit++) {
            vis = new boolean[n][n];
            int cnt = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] > limit && !vis[i][j]) {
                        bfs(i, j, limit);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        
        System.out.println(maxCnt);
    }
}
