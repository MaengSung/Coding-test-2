import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] count = new int[d+1];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int kind = 0;
        for(int i = 0; i < k; i++){
            if(count[arr[i]]++ == 0)
                kind++;
        }

        int max = kind;
        if(count[c] == 0) max++;
        for(int i = 1; i < n; i++){
            if(--count[arr[i-1]] == 0) kind--;
            if(count[arr[(i + k -1) % n]]++ == 0) kind++;

            int temp = kind;
            if(count[c] == 0) temp++;
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}