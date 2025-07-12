import java.util.*;
import java.io.*;

public class Main{
    static final int M = 1000002;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] boards = new int[M];
        int minValue = M;
        int maxValue = -M;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            boards[left]++;
            boards[right]--;

            minValue = Math.min(minValue, left);
            maxValue = Math.max(maxValue, right);
        }
        for(int i = minValue+1; i <= maxValue; i++){
            boards[i] += boards[i-1];
        }

        int left = minValue, right = minValue, a = 0, b= 0, sum = 0;
        while(right <= maxValue){
            if(sum < k){
                sum+=boards[right++];
            }
            else if(sum == k){
                a = left;
                b = right;
                break;
            }
            else{
                sum -= boards[left++];
            }
        }

        if(a == minValue) a= 0;
        
        System.out.println(a+ " " + b);
    }
}