import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for(int i = sy; i < ey; i++){
                for(int j = sx; j < ex; j++){
                    if(map[i][j]!=1) map[i][j] = 1;
                }
            }
        }

        System.out.println(getRemainGroup());
    }

    private static String getRemainGroup() {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    cnt++;
                    list.add(remainBfs(i,j));
                }
            }
        }

        Collections.sort(list);
        sb.append(cnt).append("\n");
        for(int count : list) sb.append(count).append(" ");
        return sb.toString();
    }

    private static int remainBfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        int cnt = 1;
        map[i][j] = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int[] dir : dirs){
                int cx = cur[0] + dir[0],cy = cur[1] + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(map[cx][cy] != 0) continue;

                map[cx][cy] = -1;
                cnt++;
                q.offer(new int[]{cx,cy});
            }
        }

        return cnt;
    }
}