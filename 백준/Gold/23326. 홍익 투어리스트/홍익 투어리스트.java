import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        TreeMap<Integer,Integer> good = new TreeMap<>();
        TreeMap<Integer,Integer> bad = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            if(st.nextToken().equals("1")) good.put(i,1);
            else bad.put(i,1);
        }

        int loc = 0;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());

            switch(op){
                case 1:
                    int idx = Integer.parseInt(st.nextToken())-1;
                    if(good.containsKey(idx)) {
                        good.remove(idx);
                        bad.put(idx,1);
                    }
                    else if(bad.containsKey(idx)) {
                        bad.remove(idx);
                        good.put(idx,1);
                    }
                    break;
                case 2:
                    int moveCnt = Integer.parseInt(st.nextToken());
                    loc = move(loc, n, moveCnt);
                    break;
                case 3:
                    if(good.isEmpty()) sb.append(-1).append("\n");
                    else{
                        if(good.containsKey(loc)) {
                            sb.append(0).append("\n");
                            break;
                        }
                        int min = Integer.MAX_VALUE;
                        if(good.lowerKey(loc) != null){
                            min = Math.min(good.firstKey() + (n - loc), min);
                        }
                        if(good.higherKey(loc) != null){
                            min = Math.min(good.higherKey(loc) - loc, min);
                        }
                        sb.append(min).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }

    private static int move(int loc, int total, int moveCnt) {
        loc += moveCnt;
        if(loc >= total) loc = loc % total;
        return loc;
    }
}