import java.util.*;
import java.io.*;

public class Main{
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int n = h + 2;
            int m = w + 2;
            int cnt = 0;

            char[][] map = new char[n][m];
            boolean[][] visited = new boolean[n][m];
            boolean[] keys = new boolean[26];
            List<int[]>[] blockedByDoors = new List[26];
            Queue<int[]> move = new LinkedList<>();

            for(int i = 0; i < n; i++) Arrays.fill(map[i],'.');
            for(int i = 0; i < 26; i++) blockedByDoors[i] = new ArrayList<>();

            for(int i = 0; i < h; i++){
                String line = br.readLine();
                for(int j = 0; j < w; j++){
                    map[i+1][j+1] = line.charAt(j);
                }
            }

            String keysToString = br.readLine();
            if(!keysToString.equals("0"))
                for(char c : keysToString.toCharArray()) keys[c - 'a'] = true;

            move.add(new int[]{0,0});
            visited[0][0] = true;
            while(!move.isEmpty()){
                int[] cur = move.poll();
                int x = cur[0], y = cur[1];

                for(int[] dir : dirs){
                    int cx = x + dir[0], cy = y + dir[1];

                    if(cx < 0 || cx > n-1 || cy < 0 || cy > m-1) continue;
                    if(visited[cx][cy]) continue;
                    if(map[cx][cy] == '*') continue;

                    char loc = map[cx][cy];
                    visited[cx][cy] = true;
                    if(loc == '.'){
                        move.add(new int[]{cx,cy});
                    }
                    else if(loc == '$'){
                        move.add(new int[]{cx,cy});
                        cnt++;
                    }
                    else if(Character.isUpperCase(loc)){
                        int pos = loc - 'A';
                        if(keys[pos]){
                            move.add(new int[]{cx,cy});
                        }
                        else{
                            blockedByDoors[pos].add(new int[]{cx,cy});
                        }
                    }
                    else if(Character.isLowerCase(loc)){
                        int pos = loc - 'a';
                        keys[pos] = true;
                        move.add(new int[]{cx,cy});

                        for(int[] door: blockedByDoors[pos]){
                            move.add(new int[]{door[0],door[1]});
                        }

                        blockedByDoors[pos].clear();
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}