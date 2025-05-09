import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int[][] truck = new int[t][3];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            truck[i][0] = x;
            truck[i][1] = y;
            truck[i][2] = cnt;
        }

        Arrays.sort(truck, (o1,o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });


        int[] limitCnt = new int[n+1];
        Arrays.fill(limitCnt, limit);
        limitCnt[0] = 0;
        int res = 0;
        for(int[] tk : truck){
            boolean next = true;
            int push = tk[2];
            for(int i = tk[0]; i < tk[1]; i++){
                if(limitCnt[i] <= 0){
                    next = false;
                    break;
                }
                push = Math.min(push, limitCnt[i]);
            }
            if(!next) continue;

            for(int i = tk[0]; i < tk[1]; i++) limitCnt[i] -= push;

            res+=push;
        }

        System.out.println(res);
    }

}