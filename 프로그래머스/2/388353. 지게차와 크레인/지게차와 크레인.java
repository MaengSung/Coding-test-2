import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        char[][] house = changeArr(storage);

        for(String request : requests) {
            char req = request.charAt(0);

            switch (request.length()){
                case 1:
                    removeForCar(req,house);
                    break;
                case 2:
                    remveForCrain(req,house);
            }
        }
        
        return countBlock(house);

    }

    private int countBlock(char[][] house) {
        int cnt = 0;
        for(char[] arr : house) {
            for(char c : arr) {
                if(c != '*') cnt++;
            }
        }
        return cnt;
    }

    private void remveForCrain(char req, char[][] house) {
        for(int i = 0; i<house.length; i++){
            for(int j = 0; j<house[0].length; j++){
                if(house[i][j] == req) house[i][j] = '*';
            }
        }
    }

    private void removeForCar(char req, char[][] house) {
        List<int[]> removedList = new ArrayList<>();
        
        boolean[][] visited = new boolean[house.length][house[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir : dirs) {
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];
                
                if(cx < 0 || cx >= house.length || cy < 0 || cy >= house[0].length) continue;
                if(visited[cx][cy]) continue;
                
                visited[cx][cy] = true;
                if(house[cx][cy] == req) removedList.add(new int[]{cx, cy});
                if(house[cx][cy] == '*') q.offer(new int[]{cx, cy});
            }
        }
        
        for(int[] removed : removedList) house[removed[0]][removed[1]] = '*';
    }

    private char[][] changeArr(String[] storage){
        char[][] house = new char[storage.length+2][storage[0].length()+2];

        for(char[] h : house) Arrays.fill(h,'*');

        for(int i = 1; i <= storage.length; i++){
            for(int j = 1; j <= storage[0].length(); j++){
                house[i][j] = storage[i-1].charAt(j-1);
            }
        }

        return house;
    }
}