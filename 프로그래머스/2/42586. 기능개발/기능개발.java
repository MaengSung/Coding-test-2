import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i < progresses.length; i++){
            int count = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            q.offer(count);
        }
        
        int cnt = 1;
        int before = (int) Math.ceil((double) (100 - progresses[0]) / speeds[0]);
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(cur > before){
                list.add(cnt);
                cnt = 1;
                before = cur;
                continue;
            }
            
            cnt++;
        }
        
        list.add(cnt);
        
        int[] ans = new int[list.size()];
        
        for(int i = 0 ; i < ans.length; i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}