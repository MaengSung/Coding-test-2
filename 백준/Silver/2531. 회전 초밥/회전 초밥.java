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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        while(left < n){
            if(n - left >= k){
                list.add(arr[right]);
                if(right - left + 1 == k){
                    Set<Integer> set = new HashSet<>(list);
                    int size = set.size();
                    if(!set.contains(c)) size++;
                    max= Math.max(max, size);
                    list.remove(0);
                    left++;
                }
                right++;
            }else {
                right = k - n + left - 1;
                list.add(arr[right]);
                if(n - left + right + 1 == k){
                    Set<Integer> set = new HashSet<>(list);
                    int size = set.size();
                    if(!set.contains(c)) size++;
                    max= Math.max(max, size);
                    list.remove(0);
                    left++;
                }
            }
            if(max == k + 1) break;
        }
        System.out.println(max);
    }
}