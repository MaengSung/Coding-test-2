import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer,int[]> key = new HashMap<>();
        init(key);

        StringBuilder sb = new StringBuilder();
        int[] left = {3,0};
        int[] right = {3,2};
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left = key.get(num);
            }
            if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                right = key.get(num);
            }
            if(num == 2 || num == 5 || num == 8 || num == 0){
                int[] loc = key.get(num);
                int leftDist = Math.abs(left[0] - loc[0]) + Math.abs(left[1] - loc[1]);
                int rightDist =Math.abs(right[0] - loc[0]) + Math.abs(right[1] - loc[1]);
                if(leftDist == rightDist){
                    if(hand.equals("left")){
                        sb.append("L");
                        left = loc;
                    }
                    else{
                        sb.append("R");
                        right = loc;
                    }
                }
                if(leftDist > rightDist){
                    sb.append("R");
                    right = loc;
                }
                if(leftDist < rightDist){
                    sb.append("L");
                    left = loc;
                }
            }
        }
        
        return sb.toString();
    }

    private void init(Map<Integer,int[]> key){
        key.put(1,new int[]{0,0});
        key.put(2,new int[]{0,1});
        key.put(3,new int[]{0,2});
        key.put(4,new int[]{1,0});
        key.put(5,new int[]{1,1});
        key.put(6,new int[]{1,2});
        key.put(7,new int[]{2,0});
        key.put(8,new int[]{2,1});
        key.put(9,new int[]{2,2});
        key.put(0,new int[]{3,1});
    }
}