import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (o1,o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        
        int cnt = 0;
        for(String str : bans){
            long num = 0;
            for(int i = str.length()-1; i >= 0; i--){
                num += (str.charAt(i) - '`') * Math.pow(26, str.length() - i -1);
            }
            if(num <= n+cnt) cnt++;
        }
        n+=cnt;
        
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            long add = n % 26;
            n /= 26;
            char c = '`';
            c += (char) add;
            if(sb.length() != 0 && sb.charAt(sb.length()-1) == 'z') c--;
            sb.append(c == '`' ? 'z' : c);
        }
        
        return sb.reverse().toString();
    }
}