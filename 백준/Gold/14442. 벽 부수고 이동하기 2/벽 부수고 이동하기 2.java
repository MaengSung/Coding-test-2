import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static char[][] map;
    static int[][][] dist;
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m][k+1];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == n -1 && cur[1] == m - 1) {
                System.out.println(dist[cur[0]][cur[1]][cur[2]]);
                return;
            }

            for (int[] dir : dirs) {
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;

                int cw = cur[2];
                if(map[cx][cy] == '1') cw++;
                if(cw > k || dist[cx][cy][cw] != 0) continue;
                dist[cx][cy][cw] = dist[cur[0]][cur[1]][cur[2]] + 1;
                q.offer(new int[]{cx, cy, cw});
            }
        }

        System.out.println(-1);
    }
}