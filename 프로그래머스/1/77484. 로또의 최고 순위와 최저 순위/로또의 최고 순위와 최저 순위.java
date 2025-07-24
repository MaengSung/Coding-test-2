import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int base = 0;
        int zeroCnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : win_nums) list.add(num);
        for(int num : lottos){
            if(num == 0) {
                zeroCnt++;
                continue;
            }
            if(list.contains(num)) base++;
        }

        return new int[]{7-base-zeroCnt == 7 ? 6 : 7-base-zeroCnt, 7 - base == 7 ? 6 : 7-base};

    }
}