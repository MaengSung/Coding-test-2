import java.util.*;
import java.io.*;

public class Main{
    static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n,m;
    static int[][] map;
    static int[][][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m][2];

        for(int i = 0; i < n; i++){
            String arr = br.readLine();
            for(int j = 0; j < m; j++){
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
                switch(arr.charAt(j)){
                    case '0':
                        map[i][j] = 0;
                        break;
                    case '1':
                        map[i][j] = 1;
                        break;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        dist[0][0][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];

            if(x == n -1 && y == m-1) return dist[x][y][broken];

            for(int[] d : dirs){
                int cx = x + d[0];
                int cy = y + d[1];

                if(cx < 0 || cy < 0 || cx >= n || cy >= m) continue;

                if(map[cx][cy] == 0 && dist[cx][cy][broken] == -1){
                    dist[cx][cy][broken] = dist[x][y][broken] + 1;
                    q.offer(new int[]{cx,cy,broken});
                }

                if(map[cx][cy] == 1 && broken == 0 && dist[cx][cy][1] == -1){
                    dist[cx][cy][1] = dist[x][y][broken] + 1;
                    q.offer(new int[]{cx,cy,1});
                }
            }
        }
        return -1;
    }
}