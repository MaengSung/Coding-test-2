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

       int[][] triangle = new int[n][n];

       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j <= i; j++) {
               triangle[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       int[][] dp = new int[n][n];
       dp[0][0] = triangle[0][0];

       for (int i = 0; i < n-1; i++) {
           for (int j = 0; j <= i; j++) {
               dp[i+1][j] = Math.max(dp[i+1][j], triangle[i+1][j] + dp[i][j]);
               dp[i+1][j+1] = Math.max(dp[i+1][j+1], triangle[i+1][j+1] + dp[i][j]);
           }
       }

        System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
    }
}