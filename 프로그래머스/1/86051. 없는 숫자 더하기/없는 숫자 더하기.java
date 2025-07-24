import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) set.add(i);
        for(int num : numbers){
            set.remove(num);
        }
        int res = 0;
        for(int num : set){
            res += num;
        }
        return res;
    }
}