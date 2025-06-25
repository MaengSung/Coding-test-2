import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(o1,o2) -> {
            return o1[1] - o2[1];
        });
        
        int last = -1;
        int answer = 0;
        for(int[] target : targets){
            if(last == -1){
                last = target[1] - 1;
                answer++;
                continue;
            }
            
            if(last >= target[0] && last <= target[1]) continue;

            last = target[1] - 1;
            answer++;
        }
        
        return answer;
    }
}