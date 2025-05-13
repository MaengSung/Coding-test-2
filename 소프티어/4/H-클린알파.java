import java.io.*;
import java.util.*;

public class H-클린알파 {
    private final static long D = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long p = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] time = new long[n];

        long remain = 1;
        for(int i = n-1; i >=0; i--){
            time[i] = remain % D;
            remain = remain % D * p;
        }

        long[] virus = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            virus[i] = Long.parseLong(st.nextToken());
        }

        long res = 0;
        for(int i = 0; i < n; i++){
            long a = virus[i] % D;
            long b = a * time[i] % D;

            res = (res+b) % D;
        }

        System.out.println(res);
    }
}
