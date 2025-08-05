import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (check(p))
            return p;
        else
            return dfs(p);
    }

    private boolean check(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            stack.push(c);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') count--;
            if (c == ')') count++;

            if(count < 0) return false;
        }
        return count == 0;
    }

    private String dfs(String p) {
        if(p.isEmpty()) return p;

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i<p.length(); i++) {
            char c = p.charAt(i);
            if(c == '(') cnt++;
            if(c == ')') cnt--;
            if(cnt == 0) {
                u.append(p, 0, i + 1);
                v.append(p, i + 1, p.length());
                break;
            }
        }
        if(check(u.toString())) return u.toString() + dfs(v.toString());
        else{
            StringBuilder sb = new StringBuilder();
            sb.append('(').append(dfs(v.toString())).append(')');
            u.deleteCharAt(0);
            u.deleteCharAt(u.length()-1);
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == ')') u.replace(i,i+1, "(");
                else if(u.charAt(i) == '(') u.replace(i,i+1, ")");
            }
            System.out.println(u.toString());
            return sb.toString() + u.toString();
        }
    }
}