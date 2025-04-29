import java.util.*;
import java.io.*;

public class Main{
    private static StringBuilder res = new StringBuilder();
    private static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<String> tokens = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line," \t\n");
            while(st.hasMoreTokens()){
                tokens.add(st.nextToken());
            }
        }
        
        for(String token : tokens){
            if(token.equals("<hr>")){
                hr();
                continue;
            }
            if(token.equals("<br>")){
                br();
                continue;
            }
            if(cnt+token.length()+(cnt>0?1:0) > 80){
                br();
            }
            
            if(cnt > 0) res.append(" ");
            res.append(token);
            cnt += token.length() + (cnt>0?1:0);
        }
        br();
        System.out.println(res);
    }
    
    private static void br(){
        res.append("\n");
        cnt= 0;
    }
    
    private static void hr(){
        if(cnt > 0) br();
        res.append("--------------------------------------------------------------------------------").append("\n");
        cnt = 0;
    }
}