import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String op = st.nextToken();
                if(op.equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else{
                    if(map.isEmpty()) continue;
                    int type = Integer.parseInt(st.nextToken());
                    int removedNum;
                    if(type == 1){
                        removedNum = map.lastKey();
                    }
                    else{
                        removedNum = map.firstKey();
                    }
                    if(map.put(removedNum,map.get(removedNum)-1) == 1){
                        map.remove(removedNum);
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}