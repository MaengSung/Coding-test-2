import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n,m,k;
    static String[] map = new String[1002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine();
        }

        bfs();
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[n][m][k+1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0,1,1});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0],y = cur[1], pk = cur[2], sun=cur[3], time = cur[4];


            if(x == n-1 && y == m-1){

                System.out.println(time);

                return;
            }

            for (int[] dir : dirs) {
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];

                if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;

                if(map[cx].charAt(cy) == '0'){
                    int cSun = 1 - sun;
                    if(visited[cx][cy][pk]) continue;
                    visited[cx][cy][pk] = true;
                    q.offer(new int[]{cx,cy,pk,cSun,time+1});
                }

                else{
                    if(pk == k) continue;

                    if(sun == 1){
                        int cSun = 0;
                        if(visited[cx][cy][pk+1]) continue;
                        visited[cx][cy][pk+1] = true;
                        q.offer(new int[]{cx,cy,pk+1,cSun,time+1});
                    }
                    else{
                        int cSun = 1;
                        visited[x][y][pk] = true;
                        q.offer(new int[]{x,y,pk,cSun,time+1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

}