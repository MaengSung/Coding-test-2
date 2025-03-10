import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : arr) q.offer(i);
        
        int before = -1;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(before == cur) continue;
            before = cur;
            list.add(cur);
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}