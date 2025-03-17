class Solution {
    private int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        recur(0,0,k,dungeons,visited);
        
        return max;
    }
    
    private void recur(int r, int cnt, int k, int[][] dungeons, boolean[] visited){
        max = Math.max(max, cnt);
        
        for(int i = 0 ; i < dungeons.length; i++){
            if(visited[i]) continue;
            if(k < dungeons[i][0]) continue;
            
            visited[i] = true;
            recur(r+1,cnt+1,k - dungeons[i][1], dungeons, visited);
            visited[i] = false;
        }
    }


}