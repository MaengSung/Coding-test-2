import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] sound = br.readLine().split(" ");

            List<String> removeList = new ArrayList<>();
            String next = br.readLine();
            while(!next.equals("what does the fox say?")){
                String[] split = next.split(" ");
                removeList.add(split[2]);
                next = br.readLine();
            }

            for(String str : sound){
                if(!removeList.contains(str)){
                    sb.append(str).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}