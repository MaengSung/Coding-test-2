import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] res = new long[3];
        long min = Long.MAX_VALUE;
        for(int i = 0; i < n-2; i++){
            int left = i+1, right = n-1;
            boolean find = false;
            while(left < right){
                long sum = arr[left] + arr[right] + arr[i];

                if(sum == 0){
                    res[0] = arr[i];
                    res[1] = arr[left];
                    res[2] = arr[right];
                    find = true;
                    break;
                }

                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    res[0] = arr[i];
                    res[1] = arr[left];
                    res[2] = arr[right];
                }

                if(sum < 0){
                    left++;
                }
                if(sum > 0){
                    right--;
                }
            }
            if(find) break;
        }
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}