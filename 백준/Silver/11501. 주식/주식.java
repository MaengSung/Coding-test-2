import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0, max = arr[n-1];
            for(int i = n-2; i >= 0; i--) {
                if(arr[i] < max){
                    total += max - arr[i];
                }
                else{
                    max = arr[i];
                }
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}