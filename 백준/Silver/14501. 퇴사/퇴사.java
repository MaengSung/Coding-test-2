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

        int[] t = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        if(t[n-1] <= 1) dp[n-1] = p[n-1];
        for (int i = n-2; i >= 0; i--) {
            for(int j = i + t[i]; j <= n; j++) {
                dp[i] = Math.max(dp[i], p[i] + dp[j]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}