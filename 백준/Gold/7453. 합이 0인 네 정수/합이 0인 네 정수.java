import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][4];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[] ab = new long[n*n];
        long[] cd = new long[n*n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ab[i*n+j] = arr[i][0] + arr[j][1];
                cd[i*n+j] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long cnt = 0;
        int left = 0, right = n*n-1;
        while(left < n*n && right > -1){
            long abv = ab[left], cdv = cd[right];
            long sum = abv+cdv;

            if(sum == 0){
                long lCnt = 0, rCnt = 0;
                while(left < n*n && ab[left] == abv){
                    lCnt++;
                    left++;
                }
                while(right > -1 && cd[right] == cdv){
                    rCnt++;
                    right--;
                }
                cnt+= lCnt * rCnt;
            }
            else if(sum < 0){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(cnt);
    }
}