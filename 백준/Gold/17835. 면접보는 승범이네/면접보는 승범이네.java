import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static class Node implements Comparable<Node>{
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist,o.dist);
        }
        int to;
        long dist;
        public Node(int to, long dist){
            this.to = to;
            this.dist = dist;
        }
    }

    static int n,m, place;
    static List<Node>[] load;
    static long[] distances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        place = Integer.parseInt(st.nextToken());

        load = new List[n+1];
        for(int i = 1; i <= n; i++) load[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long dist = Long.parseLong(st.nextToken());

            load[v].add(new Node(u, dist));
        }

        distances = new long[n+1];
        Arrays.fill(distances, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < place; i++) {
            int p = Integer.parseInt(st.nextToken());
            pq.offer(new Node(p, 0));
            distances[p] = 0;
        }



        dijkstra(pq);
        long[] res = findCity();

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    private static void dijkstra(PriorityQueue<Node> pq) {
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int now = cur.to;
            long dist = cur.dist;

            if(distances[now] < dist) continue;

            for(Node node : load[now]){
                if(distances[node.to] != 0 && distances[node.to] > distances[now] + node.dist){
                    distances[node.to] = distances[now] + node.dist;
                    pq.offer(new Node(node.to, distances[node.to]));
                }
            }
        }
    }

    private static long[] findCity() {
        long[] res = new long[2];
        for(int i = n; i > 0; i--){
            if(res[1] <= distances[i]){
                res[1] = distances[i];
                res[0] = i;
            }
        }

        return res;
    }
}