import java.util.ArrayList;
import java.util.List;

class Solution {
    long max = 0;
    char[] op = {'+','-','*'};
    boolean[] visited = new boolean[3];
    char[] perm = new char[3];
    List<Long> nList = new ArrayList<>();
    List<Character> oList = new ArrayList<>();
    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                oList.add(c);
                nList.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }
        nList.add(Long.parseLong(sb.toString()));

        recursive(0);

        return max;
    }

    private void recursive(int depth) {
        if(depth == 3){
            sol();
            return;
        }

        for(int i = 0; i < op.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            perm[depth] = op[i];
            recursive(depth+1);
            visited[i] = false;
        }
    }

    private void sol() {
        List<Character> oper = new ArrayList<>(oList);
        List<Long> num = new ArrayList<>(nList);

        for(char op : perm){
            for(int i = 0; i < oper.size(); i++){
                if(op == oper.get(i)){
                    long n1 = num.get(i);
                    long n2 = num.get(i+1);
                    long res = cal(op,n1,n2);

                    num.remove(i+1);
                    num.remove(i);
                    oper.remove(i);

                    num.add(i,res);
                    i--;
                }
            }
        }
        max = Math.max(max, Math.abs(num.get(0)));
    }

    private long cal(char op, long n1, long n2){
        switch(op){
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1 * n2;
        }
        return 0;
    }
}