import java.util.Scanner;

public class Main{
    static String input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        input = sc.next();
        visited = new boolean[input.length()];
        
        recur(0,input.length() - 1);
        
        System.out.println(sb);
    }
    
    private static void recur(int left, int right){
        if(left > right) return;
        
        int idx = left;
        
        for(int i = left; i <= right; i++){
            if(input.charAt(idx) > input.charAt(i)){
                idx = i;
            }
        }
        
        visited[idx] = true;
        
        for(int i = 0; i < visited.length; i++){
            if(visited[i]) sb.append(input.charAt(i));
        }
        sb.append("\n");
        
        recur(idx+1,right);
        recur(left,idx-1);
    }
}