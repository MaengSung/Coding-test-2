import java.util.*;

public class Main{
    static final int M = 4000002;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = findDemical(n);
        int left = 0, right = 0, cur = 0, cnt = 0;
        while(right < list.size()){
            cur+=list.get(right++);
           while(cur >= n){
               if(cur == n) cnt++;
               cur -= list.get(left++);
           }
        }
        System.out.println(cnt);
    }

    private static List<Integer> findDemical(int n){
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[M];
        Arrays.fill(visited, true);
        visited[0] = false;
        visited[1] = false;
        for(int i = 2; i*i < M; i++){
            if(!visited[i]) continue;
            for(int j = i*i; j < M; j+=i){
                visited[j] = false;
            }
        }

        for(int i = 2; i <= n; i++){
            if(visited[i]) list.add(i);
        }
        return list;
    }
}