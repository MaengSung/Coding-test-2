import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[101][10];

        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;

        for(int i = 1; i < 101; i++){
            for(int j = 0; j < 10; j++){
                if(j - 1 < 0){
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }
                else if(j + 1 > 9){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        System.out.println(Arrays.stream(dp[n-1]).sum()%1000000000);
    }
}