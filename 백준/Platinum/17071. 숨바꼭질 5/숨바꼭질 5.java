import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n == m){
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[500001][2];
        visited[n][0] = true;

        Queue<int[]> sujinMove = new LinkedList<>();
        sujinMove.add(new int[]{n,0});
        int time = 0;
        while(!sujinMove.isEmpty()){
            int size = sujinMove.size();
            for(int i = 0; i < size; i++){
                int[] current = sujinMove.poll();
                int curPos = current[0];
                int curTime = current[1];

                int nextTime = curTime + 1;
                int nextParity = nextTime % 2;

                int[] nextPos = {curPos + 1, curPos -1, curPos * 2};
                for(int pos : nextPos){
                    if(pos >= 0 && pos <= 500000 && !visited[pos][nextParity]){
                        visited[pos][nextParity] = true;
                        sujinMove.add(new int[]{pos, nextTime});
                    }
                }
            }
            time++;

            long sisterPos = m + (long) time * (time+1) / 2;

            if(sisterPos > 500000) break;

            if(visited[(int)sisterPos][time%2]){
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }
}