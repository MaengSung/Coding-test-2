import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] count = new int[100001];


        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int left = 0, right = 0, max = 0;
        while(right < n){
            count[arr[right]]++;
            while(count[arr[right]] > k){
                count[arr[left++]]--;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        System.out.println(max);
    }
}