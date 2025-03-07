import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n,m;
    static int[][] visited;
    static Map<Integer, List<int[]>[]> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList[n+1]);
            for(int j = 1; j <= n; j++) {
                map.get(i)[j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());

            map.get(x)[y].add(new int[]{lx, ly});
        }

        int cnt = 1;
        visited[1][1] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int[] arr : map.get(x)[y]) {
                if(visited[arr[0]][arr[1]] != 0) continue;
                visited[arr[0]][arr[1]] = 1;
//                System.out.println("x : " + arr[0] + " y : " + arr[1]);
                cnt++;
                for(int[] dir : dirs) {
                    int cx = arr[0] + dir[0];
                    int cy = arr[1] + dir[1];

                    if(cx < 1 || cx > n || cy < 1 || cy > n) continue;
                    if(visited[cx][cy] != 2) continue;

                    q.offer(new int[]{cx, cy});
                    break;
                }
            }

            for(int[] dir : dirs) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if(cx < 1 || cx > n || cy < 1 || cy > n) continue;
                if(visited[cx][cy] != 1) continue;

//                System.out.println("next x : " + cx + " next y : " + cy);
                visited[cx][cy] = 2;
                q.offer(new int[]{cx, cy});
            }
        }

        System.out.println(cnt);
    }
}