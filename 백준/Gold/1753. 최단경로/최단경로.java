import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        Map<Integer,List<Node>> map = new HashMap<>();
        int[] dist = new int[V+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        for (int i = 1; i <= V; i++) map.put(i, new ArrayList<>());
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(v,w));
        }

        findNode(K,dist,map);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void findNode(int start, int[] dist, Map<Integer,List<Node>> map){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[map.size() + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node : map.get(cur)){
                if(dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}