import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] arr = new int[3];
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : dartResult.toCharArray()){
            if(c == '*'){
                if(idx < 2){
                    arr[0] *= 2;
                }
                else{
                    arr[idx-1] *= 2;
                    arr[idx-2] *= 2;
                }
                continue;
            }
            if(c=='#'){
                arr[idx-1] *= -1;
                continue;
            }

            if(!Character.isDigit(c)){
                int cur = Integer.parseInt(sb.toString());
                if(c=='S') arr[idx] = cur;
                if(c=='D') arr[idx] = cur * cur;
                if(c=='T') arr[idx] = cur * cur * cur;
                sb = new StringBuilder();
                idx++;
            }
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        return Arrays.stream(arr).sum();
    }
}