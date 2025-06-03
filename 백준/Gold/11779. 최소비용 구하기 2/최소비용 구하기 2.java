import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int[] preNode = new int[N+1];

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e,p));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start,graph,dist,preNode);
        System.out.println(dist[end]);

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int cnt = 0;
        while(preNode[end] != 0){
            stack.push(preNode[end]);
            cnt++;
            end = preNode[end];
        }
        System.out.println(cnt + 1);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static void dijkstra(int start, List<Node>[] graph, int[] dist, int[] preNode){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.to;

            if(dist[cur] < curNode.price) continue;

            for(Node next : graph[cur]){
                if(dist[next.to] > dist[cur] + next.price){
                    dist[next.to] = dist[cur] + next.price;
                    preNode[next.to] = cur;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int price;

        Node(int to, int price){
            this.to = to;
            this.price = price;
        }

        @Override
        public int compareTo(Node o){
            return price - o.price;
        }
    }
}