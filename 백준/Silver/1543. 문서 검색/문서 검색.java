import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;

        String input = br.readLine();
        String finder = br.readLine();

        for(int i = 0; i < input.length();){
            if(input.startsWith(finder, i)) {
                res++;
                i+=finder.length();
                continue;
            }
            i++;
        }

        System.out.println(res);
    }
}