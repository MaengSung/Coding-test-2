import java.util.*;
import java.io.*;

public class Main{
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n,m,p;
    static int[] step, points;
    static int[][] map;
    static Queue<int[]>[] q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        step = new int[p+1];
        points = new int[p+1];
        q = new LinkedList[p+1];
        
        for(int i = 1; i <= p; i++) q[i] = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= p; i++){
            step[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char ch = str.charAt(j);
                if(ch == '.'){
                    map[i][j] = 0;
                }
                else if(ch == '#'){
                    map[i][j] = 1;
                }
                else{
                    int player = ch - '0';
                    map[i][j] = 1;
                    points[player]++;
                    q[player].offer(new int[]{i,j,0});
                }
            }
        }
        
        while(true){
            boolean isExtend = false;
            
            for(int i = 1; i <= p; i++){
                Queue<int[]> nextQ = new LinkedList<>();
                
                while(!q[i].isEmpty()){
                    int[] cur = q[i].poll();
                    
                    if(cur[2] >= step[i]){
                        nextQ.offer(new int[]{cur[0],cur[1],0});
                        continue;
                    }
                    
                    for(int[] dir : dirs){
                        int cx = cur[0] + dir[0];
                        int cy = cur[1] + dir[1];
                        
                        if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                        if(map[cx][cy] != 0) continue;
                        
                        map[cx][cy] = 1;
                        points[i]++;
                        q[i].offer(new int[]{cx,cy,cur[2]+1});
                        isExtend = true;
                    }
                }
                
                q[i] = nextQ;
            }
            
            if(!isExtend) break;
        }
        
        for(int i = 1; i <= p; i++) System.out.print(points[i]+" ");
    }
}