import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String input = br.readLine();
            sb.append(stack(input)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String stack(String input){
        if(input.length()%2 != 0) return "NO";

        int res = 0;
        for(char c : input.toCharArray()){
            if(c == '(') res++;
            else if(c == ')') res--;

            if(res < 0) return "NO";
        }
        return res == 0 ? "YES" : "NO";
    }
}