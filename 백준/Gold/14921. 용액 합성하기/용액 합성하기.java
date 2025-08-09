import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long sum = arr[left] + arr[right];
            if(sum == 0){
                min = 0L;
                break;
            }
            else{
                if(Math.abs(sum) < Math.abs(min)){
                    min = sum;
                }
                if(sum < 0) left++;
                else right--;
            }
        }

        System.out.println(min);
    }
}