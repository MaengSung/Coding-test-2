import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = -sc.nextInt();
        int[] floor  = new int[f];
        Arrays.fill(floor, -1);


        Queue<Integer> q = new LinkedList<>();
        q.offer(s-1);
        floor[s-1] = 0;
        while (!q.isEmpty()) {
            int loc = q.poll();

            for(int button : new int[]{u,d}){
                int cLoc = loc + button;
                if(cLoc < 0 || cLoc >= f) continue;
                if(floor[cLoc] != -1) continue;
                floor[cLoc] = floor[loc] + 1;
                q.offer(cLoc);
            }
        }

        if(floor[g-1] != -1) System.out.println(floor[g-1]);
        else System.out.println("use the stairs");
    }
}