import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < prices.length; i++){
            int cnt = 0;
            for(int j = i+1; j < prices.length; j++){
                cnt++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            q.offer(cnt);
        }
        
        int[] res = new int[q.size()];
        
        for(int i = 0; i < prices.length; i++){
            res[i] = q.poll();
        }
        
        return res;
    }
}