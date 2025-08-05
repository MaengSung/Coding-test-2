import java.util.LinkedList;
import java.util.Queue;

class Solution {
    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] solution(String[][] places) {
        int[] res = new int[5];
        for(int k = 0; k < places.length; k++){
            String[] place = places[k];
            boolean check = true;
            for(int i = 0; i < 5 && check; i++){
                if(!place[i].contains("P")) continue;
                for(int j = 0; j < 5; j++){
                    if(place[i].charAt(j) != 'P') continue;
                    if(bfs(place,i,j)){
                        check = false;
                        break;
                    }
                }
            }
            if(check) res[k] = 1;
            if(!check) res[k] = 0;
        }

        return res;
    }
    private boolean bfs(String[] place, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cnt = cur[2];

            if(cnt >= 2) continue;

            for(int[] dir : dirs){
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];

                if(cx < 0 || cx >= 5 || cy < 0 || cy >= 5) continue;
                if(visited[cx][cy]) continue;
                if(place[cx].charAt(cy) == 'X') continue;

                if (place[cx].charAt(cy) == 'P') {
                    return true;
                }
                visited[cx][cy] = true;
                q.offer(new int[]{cx, cy, cur[2] + 1});
            }
        }
        return false;
    }

}