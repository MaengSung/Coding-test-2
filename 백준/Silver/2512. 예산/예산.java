import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int money = Integer.parseInt(st.nextToken());
            max = Math.max(max, money);
            arr[i] = money;
        }
        long budget = Long.parseLong(br.readLine());

        long res = 0;
        int left = 0, right = max;
        while(left <= right){
            int mid = (left + right)/2;
            int cnt = 0;
            for(int num : arr){
                cnt += Math.min(num, mid);
            }
            if(cnt == budget){
                res = mid;
                break;
            }
            if(cnt < budget){
                res = Math.max(res,mid);
                left = mid + 1;
            }
            if(cnt > budget){
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}