import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
            list.add(priorities[i]);
        }
        Collections.sort(list);
        
        int idx =list.size()-1;
        int cnt =1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int loc = cur[0];
            int priority = cur[1];
            
            if(priority == list.get(idx)){
                if(loc == location){
                    return cnt;
                }
                idx--;
                cnt++;
                continue;
            }
            
            q.offer(new int[]{loc,priority});
        }
        
        return -1;
    }
}