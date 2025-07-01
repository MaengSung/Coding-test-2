import java.io.*;
import java.util.*;

public class Main {
    static  class Node implements Comparable<Node>{
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost,o.cost);
        }

        int to;
        int cnt;
        long cost;

        public Node(int to,int cnt, long cost) {
            this.to = to;
            this.cnt = cnt;
            this.cost = cost;
        }

    }
    static List<Node>[] arr = new List[10002];
    static long[][] dist;
    static int n,m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v,0,cost));
            arr[v].add(new Node(u,0,cost));
        }
        dist = new long[n+1][k+1];
        for(int i = 1; i <= n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dijkstra();

        long min = Arrays.stream(dist[n]).min().getAsLong();
        System.out.println(min);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.to][now.cnt] < now.cost) continue;

            for(Node next : arr[now.to]){
                if(dist[next.to][now.cnt] > now.cost + next.cost){
                    dist[next.to][now.cnt] = now.cost + next.cost;
                    pq.offer(new Node(next.to, now.cnt, dist[next.to][now.cnt]));
                }

                if((now.cnt < k) && dist[next.to][now.cnt + 1] > now.cost){
                    dist[next.to][now.cnt + 1] = now.cost;
                    pq.offer(new Node(next.to,now.cnt + 1, now.cost));
                }
            }
        }
    }
}