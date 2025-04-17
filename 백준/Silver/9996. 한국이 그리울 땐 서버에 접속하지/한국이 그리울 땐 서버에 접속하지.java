import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(),"*");

        String first = st.nextToken();
        String second = st.nextToken();

        while(n-- > 0){
            String input = br.readLine();

            if(input.startsWith(first) && input.substring(first.length()).endsWith(second)) 
                sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.println(sb.toString());
    }
}