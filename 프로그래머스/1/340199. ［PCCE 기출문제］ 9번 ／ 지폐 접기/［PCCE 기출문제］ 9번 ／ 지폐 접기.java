import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        
        int wMin = Arrays.stream(wallet).min().getAsInt();
        int wMax = Arrays.stream(wallet).max().getAsInt();
        
        int bMin = Arrays.stream(bill).min().getAsInt();
        int bMax = Arrays.stream(bill).max().getAsInt();
        
        while(bMin > wMin || bMax > wMax){
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }
            else bill[1] = bill[1] / 2;
            
            bMin = Arrays.stream(bill).min().getAsInt();
            bMax = Arrays.stream(bill).max().getAsInt();
            
            answer++;
        }
        
        return answer;
    }
}