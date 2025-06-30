import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int w : works) pq.offer(w);
        
        for(int i = 0; i < n; i++){
            int next = pq.poll();
            if(next <= 0) break;
            next--;
            pq.offer(next);
        }
        
        long answer = 0L;
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += (long) Math.pow(num,2);
        }
        
        return answer;
    }
}