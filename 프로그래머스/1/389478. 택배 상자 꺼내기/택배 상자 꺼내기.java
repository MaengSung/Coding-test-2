import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int checkIdx = -1;
        
        int idx = 1;
        boolean reverse = false;
        for(int i = 1; i <= n; i++){
            
            if(i == num){
                checkIdx = idx;
            }
            
            if(checkIdx != -1 && idx == checkIdx) answer++;
            
            if(i % w == 0) {
                reverse = !reverse;
                continue;
            }
            if(reverse) idx--;
            if(!reverse) idx++;
        }
        
        return answer;
    }
}