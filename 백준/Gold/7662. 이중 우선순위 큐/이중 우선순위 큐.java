import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static Map<Integer,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test = 0; test < t; test++) {

            map = new HashMap<>();

            Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> min = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();

                if(op.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    max.add(num);
                    min.add(num);
                    map.put(num,map.getOrDefault(num,0)+1);
                }
                else{
                    int type = Integer.parseInt(st.nextToken());

                    if(map.isEmpty()) continue;

                    if(type == 1) delete(max);
                    if(type == -1) delete(min);
                }

            }
            if(map.isEmpty()) sb.append("EMPTY").append("\n");
            else{
                int res = delete(max);
                sb.append(res).append(" ");
                if(!map.isEmpty()) res = delete(min);
                sb.append(res).append("\n");

            }
        }
        System.out.println(sb);
    }

    private static int delete(Queue<Integer> q) {
        int res = 0;
        while(true){
            res = q.poll();

            int cnt = map.getOrDefault(res,0);
            if(cnt == 0) continue;

            if(cnt == 1) map.remove(res);
            if(cnt > 1) map.put(res,cnt - 1);
            break;
        }
        return res;
    }
}