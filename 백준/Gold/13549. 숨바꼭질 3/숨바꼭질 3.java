import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int MX = 200000;
        int[] dist = new int[MX];
        Arrays.fill(dist, -1);
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(n);
        dist[n] = 0;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            if (2 * cur < MX && dist[2 * cur] == -1) {
                dist[2 * cur] = dist[cur];
                dq.offerFirst(2 * cur);
            }
            
            for (int nxt : new int[]{cur - 1, cur + 1}) {
                if (nxt < 0 || nxt >= MX || dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                dq.offerLast(nxt);
            }
        }
        
        System.out.println(dist[k]);
    }
}
