import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int cnt = 1;
        Map<String, Integer> closet = new HashMap<>();

        for(String[] cloth : clothes)
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
        
        
        for(String key : closet.keySet()){
            cnt *= (closet.get(key) + 1);
        }
        
        cnt--;
        
        return cnt;
    }

}