import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());
       int[] arr = new int[n];

       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }

       int left = 0, right = 0 ;
       long cnt = 0;
       boolean[] visited = new boolean[100002];
       while(right < n){
          if(!visited[arr[right]]){
              visited[arr[right]] = true;
              cnt += right - left + 1;
              right++;
          }
          else{
              visited[arr[left]] = false;
              left++;
          }
       }
       System.out.println(cnt);
    }
}