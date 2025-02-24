import java.io.*;
import java.util.*;

public class Main{
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        isLand(n, map, visited);
        
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], -1);
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0) {
                    q.offer(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir : dirs){
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];
                if(oob(cx,cy,n) || map[cur[0]][cur[1]] == map[cx][cy]) continue;
                if(map[cx][cy] != 0){
                    min = Math.min(min, dist[cx][cy] + dist[cur[0]][cur[1]]);
                }
                else {map[cx][cy] = map[cur[0]][cur[1]];
                dist[cx][cy] = dist[cur[0]][cur[1]]+1;
                q.offer(new int[]{cx,cy});}
            }
        }
        System.out.println(min);
    }

    
    private static void isLand(int n, int[][] map, boolean[][] visited){
        int land = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0 || visited[i][j]) continue;
                
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i,j});
                visited[i][j] = true;
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    map[cur[0]][cur[1]] = land;
                    for(int[] dir : dirs){
                        int cx = cur[0] + dir[0];
                        int cy = cur[1] + dir[1];
                        if(oob(cx,cy,n) || visited[cx][cy] || map[cx][cy] == 0) continue;
                        
                        visited[cx][cy] = true;
                        q.offer(new int[]{cx,cy});
                    }
                }
                land++;
            }
        }
    }
    
    private static boolean oob(int x, int y, int n){
        if(x < 0 || x >= n || y < 0 || y >= n) return true;
        return false;
    }
}