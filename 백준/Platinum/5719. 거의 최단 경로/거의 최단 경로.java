import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static List<Edge>[] arr = new List[502];
    static List<Edge>[] revArr = new List[502];
    static boolean[] visited = new boolean[10002];
    static int[] distance = new int[502];
    static int n,m,start, end;
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    static Queue<Integer> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n == 0 && m == 0) break;

            for(int i = 0; i < n; i++){
                if(arr[i] == null) arr[i] = new ArrayList<>();
                if(revArr[i] == null) revArr[i] = new ArrayList<>();
                arr[i].clear();
                revArr[i].clear();
            }

            Arrays.fill(visited, 0, m, false);
            Arrays.fill(distance, 0, n, INF);

            start = sc.nextInt();
            end = sc.nextInt();

            for(int i = 0; i < m; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int p = sc.nextInt();

                arr[u].add(new Edge(v,i,p));
                revArr[v].add(new Edge(u,i,p));
            }

            solve();
            trace();
            solve();

            sb.append(distance[end] == INF ? -1 : distance[end]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void trace() {
        q.clear();
        q.offer(end);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Edge e : revArr[cur]){
                if(visited[e.id]) continue;

                int prev = e.to;
                int d = distance[cur] - e.cost;

                if(d != distance[prev]) continue;

                visited[e.id] = true;
                q.offer(prev);
            }
        }
    }

    private static void solve() {
        Arrays.fill(distance, 0, n, INF);
        distance[start] = 0;
        pq.clear();
        pq.offer(new int[]{0,start});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0];
            int current = cur[1];

            if(distance[current] < cost) continue;

            for(Edge e : arr[current]){
                if(visited[e.id]) continue;
                int nextCost = cost + e.cost;
                if(distance[e.to] <= nextCost) continue;

                distance[e.to] = nextCost;
                pq.offer(new int[]{nextCost, e.to});
            }
        }
    }

    static class Edge{
        int to;
        int id;
        int cost;

        public Edge(int to, int id, int cost) {
            this.to = to;
            this.id = id;
            this.cost = cost;
        }
    }
}