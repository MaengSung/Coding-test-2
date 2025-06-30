import java.io.IOException;
import java.util.*;

public class Main {
    static class Edge {
        int to, id, cost;

        Edge(int to, int id, int cost) {
            this.to = to;
            this.id = id;
            this.cost = cost;
        }
    }

    static List<Edge>[] graph = new List[502];
    static List<Edge>[] reverseGraph = new List[502];
    static boolean[] isRemovedEdge = new boolean[10002];
    static int[] distance = new int[502];

    static int n, m, start, end;
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) break;

            for (int i = 0; i < n; i++) {
                if (graph[i] == null) graph[i] = new ArrayList<>();
                if (reverseGraph[i] == null) reverseGraph[i] = new ArrayList<>();
                graph[i].clear();
                reverseGraph[i].clear();
            }

            Arrays.fill(isRemovedEdge, 0, m, false);
            Arrays.fill(distance, 0, n, INF);

            start = sc.nextInt();
            end = sc.nextInt();

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int cost = sc.nextInt();

                graph[u].add(new Edge(v, i, cost));
                reverseGraph[v].add(new Edge(u, i, cost)); // reverse edge
            }

            solve();
            trace();
            solve();

            sb.append(distance[end] == INF ? -1 : distance[end]).append("\n");
        }

        System.out.print(sb);
    }

    static void solve() {
        Arrays.fill(distance, 0, n, INF);
        distance[start] = 0;
        pq.clear();
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curNode = cur[1];

            if (distance[curNode] < curCost) continue;

            for (Edge e : graph[curNode]) {
                if (isRemovedEdge[e.id]) continue;

                int nextCost = curCost + e.cost;
                if (distance[e.to] <= nextCost) continue;

                distance[e.to] = nextCost;
                pq.offer(new int[]{nextCost, e.to});
            }
        }
    }

    static void trace() {
        queue.clear();
        queue.offer(end);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Edge e : reverseGraph[cur]) {
                if (isRemovedEdge[e.id]) continue;

                int prev = e.to;
                int expected = distance[cur] - e.cost;

                if (distance[prev] != expected) continue;

                isRemovedEdge[e.id] = true;
                queue.offer(prev);
            }
        }
    }
}
