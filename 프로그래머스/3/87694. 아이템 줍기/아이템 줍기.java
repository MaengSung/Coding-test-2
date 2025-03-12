import java.util.*;

class Solution {
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = makeMap(rectangle);
        
        return bfs(map,characterX * 2, characterY*2, itemX * 2, itemY *2);
    }
    
    private int bfs(int[][] map, int X, int Y, int itemX, int itemY){
        boolean[][] visited = new boolean[102][102];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{Y,X,0});
        visited[Y][X] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x==itemY && y==itemX ){
                return cnt/2;
            }
            
            for(int[] dir : dirs){
                int cx = x + dir[0];
                int cy = y + dir[1];
                
                if(cx < 0 || cx > 102 || cy < 0 || cy > 102) continue;
                if(visited[cx][cy] || map[cx][cy] != 2) continue;
                
                visited[cx][cy] = true;
                q.offer(new int[]{cx,cy,cnt+1});
            }
        }
        
        return -1;
    }
    
    private int[][] makeMap(int[][] rectangle){
        
        int[][] map = new int[102][102];
        
        for(int[] rec : rectangle){
            int ly = rec[0]*2;
            int lx = rec[1]*2;
            int hy = rec[2]*2;
            int hx = rec[3]*2;
            
            for(int i = lx; i <= hx; i++){
                for(int j = ly; j <= hy; j++){
                    if(map[i][j] == 1) continue;
                    map[i][j] = 1;
                    if(i == lx || i == hx || j == ly || j == hy)
                        map[i][j] = 2;
                }
            }
        }
        return map;
    }
}