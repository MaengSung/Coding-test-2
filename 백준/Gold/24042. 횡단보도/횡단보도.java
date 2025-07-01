import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        long time;

        public Node(int to, long time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }
    static int n,m;
    static List<Node>[] arr = new List[100001];
    static long[] dist = new long[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) arr[i] = new ArrayList<>();
        Arrays.fill(dist,1,n+1,Long.MAX_VALUE);
        dist[1] = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v,i));
            arr[v].add(new Node(u,i));
        }

        dijkstra();
        System.out.println(dist[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int now = cur.to;
            long time = cur.time;

            if(dist[now] < time) continue;

            for(Node n : arr[now]){
                int nextNode = n.to;
                long nextTime = n.time;
                if(nextTime >= time) nextTime ++;
                else{
                    nextTime =(long) Math.ceil(((double)time - nextTime)/ m) * m + nextTime + 1;
                }

                if(dist[nextNode] < nextTime) continue;
                dist[nextNode] = nextTime;
                pq.add(new Node(nextNode,dist[nextNode]));
            }
        }
    }
}