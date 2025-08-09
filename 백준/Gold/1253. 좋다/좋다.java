import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0; i < n; i++){
            int left = 0, right = n-1;
            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right] - arr[i];
                if(sum == 0){
                    cnt++;
                    break;
                }
                if(sum < 0){
                    left++;
                }
                if(sum > 0){
                    right--;
                }

            }
        }
        System.out.println(cnt);
    }
}