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

        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        int max = -1;
        for(int i = 0; i < n+1; i++) {
            max = Math.max(max, dp[i]);

            int next = i + t[i];
            if(next < n+1){
                dp[next] = Math.max(dp[next], max + p[i]);
            }
        }

        System.out.println(max);
    }
}