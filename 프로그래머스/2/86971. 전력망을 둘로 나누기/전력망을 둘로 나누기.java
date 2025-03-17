import java.util.*;

class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            list.get(v1).add(Integer.valueOf(v2));
            list.get(v2).add(Integer.valueOf(v1));
        }
        
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));
            
            min = Math.min(min,bfs(n,v1));
            
            list.get(v1).add(Integer.valueOf(v2));
            list.get(v2).add(Integer.valueOf(v1));
        }
        
        return min;
    }
    
    private int bfs(int n, int start){
        int[] visited = new int[n+1];
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = 1;
            
            for(int i = 0; i < list.get(cur).size(); i++){
                int v1 = list.get(cur).get(i);
                if(visited[v1] != 0) continue;
                q.offer(v1);
                cnt++;
            }
        }
        
        return Math.abs(cnt - (n-cnt));
    }
}