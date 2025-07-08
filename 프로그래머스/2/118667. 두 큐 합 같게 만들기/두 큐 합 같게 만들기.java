import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer((long) queue1[i]);
            q1Sum+=queue1[i];
        }
        for(int i = 0; i < queue2.length; i++) {
            q2.offer((long) queue2[i]);
            q2Sum+=queue2[i];
        }
        
        long total = q1Sum+q2Sum;
        if(total %2 == 1) return -1;
        
        int answer = 0;
        int limit = Math.max(queue1.length,queue2.length) * 3;
        while(answer <= limit * 3){
            if(q1Sum == q2Sum) break;
            
            else if(q1Sum > q2Sum){
                long num = q1.poll();
                q1Sum -= num;
                q2.offer(num);
                q2Sum += num;
            }
            
            else if(q2Sum > q1Sum){
                long num = q2.poll();
                q2Sum -= num;
                q1.offer(num);
                q1Sum += num;
            }
            answer++;
        }
        
        return answer > limit ? -1 : answer;
    }
}