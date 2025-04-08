import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        Queue<int[]> qq = new LinkedList<>();
        recur(0,n,1,new int[5], qq);

        while(!qq.isEmpty()) {
            int[] cur = qq.poll();
            boolean next = true;
            
            for(int i = 0; i < q.length; i++) {
                int cnt = 0;
                for(int num : cur){
                    for(int j = 0; j < 5; j++){
                        if(num == q[i][j]) cnt++;
                    }
                }
                if(cnt != ans[i]) {
                    next = false;
                    break;
                }
            }
            
            if(next) answer++;
        }


        return answer;
    }

    private void recur(int r, int n, int start, int[] cur, Queue<int[]> q) {
        if(r == 5){
            q.offer(Arrays.copyOf(cur,cur.length));
            return;
        }

        for(int i = start; i <= n; i++){
                cur[r] = i;
                recur(r+1, n, i+1, cur, q);
            }
        }
    }
