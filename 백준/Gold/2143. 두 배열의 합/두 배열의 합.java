import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;
        long[] aArr = new long[aSize];
        long[] bArr = new long[bSize];

        int idx = 0;
        for(int i = 0; i < n; i++){
            int av = 0;
            for(int j = i; j < n; j++){
                av += a[j];
                aArr[idx++] = av;
            }
        }
        Arrays.sort(aArr);

        idx = 0;
        for(int i = 0; i < m; i++){
            int bv = 0;
            for(int j = i; j < m; j++){
                bv += b[j];
                bArr[idx++] = bv;
            }
        }
        Arrays.sort(bArr);

        long cnt = 0;
        int left = 0, right = bSize - 1;
        while(left < aSize && right > -1){
            long av = aArr[left], bv = bArr[right];
            long sum = av + bv;

            if(sum == t){
                int lCnt = 0, rCnt = 0;
                while(left < aSize && av == aArr[left]){
                    left++;
                    lCnt++;
                }
                while(right > -1 && bv == bArr[right]){
                    right--;
                    rCnt++;
                }
                cnt += (long) lCnt * rCnt;
            }
            else if(sum < t){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(cnt);
    }
}