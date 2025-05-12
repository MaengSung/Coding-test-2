import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) students[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int i = a-1; i < b; i++){
                sum+=students[i];
            }

            double res = (double) Math.round((double) sum / (b-a+1) * 100) / 100;
            sb.append(String.format("%.2f",res)).append("\n");
        }
        System.out.println(sb);
    }
}