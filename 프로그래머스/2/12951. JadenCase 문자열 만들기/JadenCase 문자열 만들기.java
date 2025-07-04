import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean first = true;
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(' ');
                first = true;
            }
            else{
                if(first){
                    sb.append(String.valueOf(c).toUpperCase());
                    first = false;
                }
                else{
                    sb.append(String.valueOf(c).toLowerCase());
                }
            }
        }
        
        return sb.toString();
    }
}