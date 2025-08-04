class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int[] res = new int[queries.length];
        
        int next = 1;
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map[0].length; j++){
                map[i][j] = next++;
            }
        }
        
        int idx = 0;
        for(int[] query : queries){
            int min = Integer.MAX_VALUE;
            int prev = map[query[0]][query[1]];
            min = Math.min(min,prev);
            //우측으로 이동
            for(int i = query[1]; i< query[3]; i++){
                int cur = map[query[0]][i+1];
                map[query[0]][i + 1] = prev;
                prev = cur;
                min = Math.min(min,prev);
            }
            
            //아래로 이동
            for(int i = query[0]; i < query[2]; i++){
                int cur = map[i+1][query[3]];
                map[i+1][query[3]] = prev;
                prev = cur;
                min = Math.min(min,prev);
            }
            
            //왼쪽으로 이동
            for(int i = query[3]; i > query[1]; i--){
                int cur = map[query[2]][i-1];
                map[query[2]][i-1] = prev;
                prev = cur;
                min = Math.min(min,prev);
            }
            
            //위로 이동
            for(int i = query[2]; i > query[0]; i--){
                int cur = map[i-1][query[1]];
                map[i-1][query[1]] = prev;
                prev = cur;
                min = Math.min(min,prev);
            }
            
            res[idx++] = min;
        }
        
        return res;
    }
}