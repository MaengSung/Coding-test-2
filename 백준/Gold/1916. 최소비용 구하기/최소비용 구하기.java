import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,p));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start,graph,dist);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int start, List<Node>[] graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;
        boolean[] visited = new boolean[dist.length];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if(visited[cur]) continue;
            visited[cur] = true;

            for(Node next : graph[cur]) {
                if(dist[next.to] > dist[cur] + next.time) {
                    dist[next.to] = dist[cur] + next.time;
                    pq.add(new Node(next.to,dist[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int time;

        Node(int to, int time){
            this.to = to;
            this.time = time;
        }

        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}