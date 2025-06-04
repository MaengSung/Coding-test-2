import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        List<Node>[] lines = new List[N+1];
        for(int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            lines[start].add(new Node(end,time));
        }

        for(int i = 1; i <= N; i++){
            dicjkstra(i,lines,dist[i]);
        }
        
        int max = 0;
        for(int i = 1; i <= N; i++){
            int go = dist[i][X];
            int back = dist[X][i];
            
            max = Math.max(max,go+back);
        }
        System.out.println(max);
    }

    private static void dicjkstra(int start, List<Node>[] lines, int[] dist) {
           PriorityQueue<Node> pq = new PriorityQueue<>();
           pq.add(new Node(start,0));
           boolean[] visited = new boolean[dist.length];

           Arrays.fill(dist,Integer.MAX_VALUE);
           dist[start] = 0;

           while(!pq.isEmpty()){
               Node curNode = pq.poll();
               int cur = curNode.to;

               if(visited[cur]) continue;
               visited[cur] = true;

               for(Node node : lines[cur]){
                   if(dist[node.to] > dist[cur] + node.time){
                       dist[node.to] = dist[cur] + node.time;
                       pq.add(new Node(node.to,dist[node.to]));
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