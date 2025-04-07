import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[] oil;
    public int solution(int[][] land) {
        int answer = 0;
        oil = new int[land[0].length];

        boolean[][] visited = new boolean[land.length][land[0].length];

        for(int i = 0; i < land[0].length; i++){
            for(int j = 0; j < land.length; j++){
                if(!visited[j][i] && land[j][i] == 1){
                    bfs(j,i,visited,land);
                }
            }
        }

        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }

    private void bfs(int x, int y, boolean[][] visited, int[][] land){

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            set.add(cur[1]);
            for(int[] d : directions){
                int cx = cur[0] + d[0];
                int cy = cur[1] + d[1];
                if(cx < 0 || cx >= land.length || cy < 0 || cy >= land[0].length) continue;
                if(visited[cx][cy]) continue;
                if(land[cx][cy] != 1) continue;

                q.offer(new int[]{cx, cy});
                cnt++;
                visited[cx][cy] = true;
            }
        }

        for(int i : set) oil[i] += cnt;
    }
}