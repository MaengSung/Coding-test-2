import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    final static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] map;
    static int[][] testMap;
    static List<int[]> virus = new LinkedList<>();
    static int n,m;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(map[i][j] == 2) virus.add(new int[]{i,j});
            }
        }

        architect(0,0);
        System.out.println(max);
    }

    private static void architect(int start, int wallCount) {
        if(wallCount == 3){
            testMap = copyMap();

            for(int[] point : virus){
                bfs(point);
            }

            max = Math.max(max, getSafeSize());
            return;
        }

        for(int i = start; i < n*m; i++){
            int x = i / m;
            int y = i % m;

            if(map[x][y] == 0){
                map[x][y] = 1;
                architect(i+1, wallCount+1);
                map[x][y] = 0;
            }
        }

    }

    private static int getSafeSize() {
        int size = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(testMap[i][j] == 0) size++;
            }
        }
        return size;
    }

    private static int[][] copyMap() {
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }

    private static void bfs(int[] point) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{point[0], point[1]});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir : dirs){
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(testMap[cx][cy] != 0) continue;

                testMap[cx][cy] = 2;
                q.add(new int[]{cx, cy});
            }
        }

    }

}