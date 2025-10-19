import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int n, m;
    private static boolean[][] visited;
    private static char[][] map;
    private static Queue<int[]> moves;
    private static List<int[]>[] doors;
    private static boolean[] keys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            n = h + 2;
            m = w + 2;

            map = new char[n][m];

            for(int i = 0; i < n; i++) Arrays.fill(map[i], '.');
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = line.charAt(j);
                }
            }

            doors = new List[26];
            for(int i = 0; i < 26; i++)doors[i] = new ArrayList<>();
            keys = new boolean[26];
            visited = new boolean[n][m];


            String inputKeys = br.readLine();
            if(!inputKeys.equals("0")){
                for(char key : inputKeys.toCharArray()){
                    keys[key - 'a'] = true;
                }
            }

            moves = new LinkedList<>();
            moves.add(new int[]{0,0});
            visited[0][0] = true;

            int cnt = bfsFind();

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfsFind(){
        int cnt = 0;
        while(!moves.isEmpty()){
            int[] move = moves.poll();
            int x = move[0], y = move[1];
            for(int[] dir: dirs){
                int cx = x + dir[0], cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(visited[cx][cy]) continue;
                if(map[cx][cy] == '*') continue;

                char pos = map[cx][cy];
                visited[cx][cy] = true;

                if(pos == '.'){
                    moves.add(new int[]{cx,cy});
                }
                else if(pos == '$'){
                    moves.add(new int[]{cx,cy});
                    cnt++;
                }
                else if(Character.isAlphabetic(pos)){
                    if(Character.isUpperCase(pos)){
                        if(keys[pos - 'A']) {
                            moves.add(new int[]{cx,cy});
                        }
                        else{
                            doors[pos-'A'].add(new int[]{cx,cy});
                        }
                    }
                    else if(Character.isLowerCase(pos)){
                        keys[pos - 'a'] = true;
                        moves.add(new int[]{cx, cy});

                        for (int[] door : doors[pos - 'a']) {
                            moves.add(new int[]{door[0], door[1]});
                        }
                        doors[pos - 'a'].clear();
                    }
                }
            }
        }
        return cnt;
    }
}