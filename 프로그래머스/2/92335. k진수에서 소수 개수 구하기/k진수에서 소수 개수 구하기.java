import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNum = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < kNum.length(); i++){
            char c = kNum.charAt(i);
            if(c == '0'){
                if(sb.toString().equals("")) continue;
                else {
                    long num = Long.parseLong(sb.toString());
                    sb = new StringBuilder();
                    if(check(num)) answer++;
                }
            }
            else{
                sb.append(c);
                if(i == kNum.length()-1 && check(Long.parseLong(sb.toString()))) answer++;
            }
        }
        return answer;
    }

    private boolean check(long n){
        if(n < 2) return false;
        if(n == 2) return true;

        double last = Math.sqrt(n);
        last = Math.ceil(last);
        for(int i = 2; i <= last; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}