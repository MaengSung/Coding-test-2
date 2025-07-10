import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, remove = 0, max = 0;
        while(right < n){
            if(arr[right] % 2 != 0) remove++;
            while(remove > k && left < right){
                if(arr[left] % 2 != 0) remove--;
                left++;
            }
            max = Math.max(max, right - left + 1 - remove);
            right++;
        }

        System.out.println(max);
    }
}