import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    final static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[b][a];

        for(int i = 0; i < b; i++){
            String Input = br.readLine();
            for(int j = 0; j < a; j++){
                if(Input.charAt(j) == '1') map[i][j] = 1;
                if(Input.charAt(j) == '0') map[i][j] = 0;
            }
        }

        int[][] breakWallMap = new int[b][a];
        for(int i = 0; i < b; i++) Arrays.fill(breakWallMap[i],1000);
        breakWallMap[0][0] = 0;

        djBfs(map,breakWallMap);
        
        System.out.println(breakWallMap[b-1][a-1]);
    }

    private static void djBfs(int[][] map, int[][] breakWallMap) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int breakWall = cur.breakWall;

            if(x == map.length-1 && y == map[0].length-1) break;

            for(int[] dir : dirs){
                int cx = x + dir[0];
                int cy = y + dir[1];
                int cBreakWall = breakWall;

                if(cx < 0 || cx >= map.length || cy < 0 || cy >= map[0].length) continue;
                if(map[cx][cy] == 1) cBreakWall++;
                if(breakWallMap[cx][cy] <= cBreakWall) continue;

                breakWallMap[cx][cy] = cBreakWall;
                pq.add(new Node(cx,cy,cBreakWall));
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int breakWall;

        Node(int x, int y, int breakWall) {
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }

        @Override
        public int compareTo(Node o) {
            return breakWall - o.breakWall;
        }
    }
}