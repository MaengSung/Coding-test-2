import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int SIZE = 100005;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        bfs(n,m);
    }

    private static void bfs(int n, int m) {
        int[] map = new int[SIZE];
        int[] preMap = new int[SIZE];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        map[n] = 1;
        preMap[n] = n;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int newLoc : new int[]{cur + 1, cur -1, cur *2}){

                if(newLoc < 0 || newLoc >= SIZE) continue;
                if(map[newLoc] != 0) continue;

                map[newLoc] = map[cur] + 1;
                preMap[newLoc] = cur;
                q.offer(newLoc);
            }
        }
        System.out.println(map[m] - 1);



        List<Integer> list = new ArrayList<>();
        q.offer(m);
        while(!q.isEmpty()) {
            int cur = q.poll();
            list.add(cur);

            if(n == cur) break;
            q.offer(preMap[cur]);
        }

        for(int i = list.size()-1; i >=0; i--) System.out.print(list.get(i)+ " ");
    }
}