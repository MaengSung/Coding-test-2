import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        List<Node>[] graph = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        // 반드시 거쳐야 할 두 정점
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[] distFromStart = dijkstra(1, graph, nodeCount);
        int[] distFromU = dijkstra(u, graph, nodeCount);
        int[] distFromV = dijkstra(v, graph, nodeCount);

        // 두 경로 중 최소값 계산 (경로가 불가능하면 INF 유지됨)
        int route1 = safeAdd(distFromStart[u], distFromU[v], distFromV[nodeCount]);
        int route2 = safeAdd(distFromStart[v], distFromV[u], distFromU[nodeCount]);

        int result = Math.min(route1, route2);
        System.out.println(result == INF ? -1 : result);
    }

    // 다익스트라 알고리즘
    private static int[] dijkstra(int start, List<Node>[] graph, int nodeCount) {
        int[] dist = new int[nodeCount + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.to;

            if (dist[curNode] < current.weight) continue;

            for (Node next : graph[curNode]) {
                if (dist[next.to] > dist[curNode] + next.weight) {
                    dist[next.to] = dist[curNode] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    // 안전한 거리 합산 (도달 불가한 노드가 있으면 INF 반환)
    private static int safeAdd(int... values) {
        int sum = 0;
        for (int val : values) {
            if (val == INF) return INF;
            sum += val;
        }
        return sum;
    }

    // 노드 클래스 (다익스트라에서 사용)
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
