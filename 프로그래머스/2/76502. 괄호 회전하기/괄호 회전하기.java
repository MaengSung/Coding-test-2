import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(determine(s)) answer++;
            s = cycleStr(s);
        }
        
        return answer;
    }
    
    private boolean determine(String s){
        
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[' || c =='(' || c== '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char cc = stack.pop();
                if(cc == '[' && c == ']') continue;
                if(cc == '(' && c == ')') continue;
                if(cc == '{' && c == '}') continue;
                else return false;
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
    
    private String cycleStr(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(1,s.length())).append(s.substring(0,1));
        return sb.toString();
    }
}