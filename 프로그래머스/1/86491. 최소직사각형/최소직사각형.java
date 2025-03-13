import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int max1 = 0;
        int max2 = 0;
        
        for(int[] size : sizes){
            if(size[0] >= size[1]){
                max1 = Math.max(max1,size[0]);
                max2 = Math.max(max2,size[1]);
            }
            else{
                max1 = Math.max(max1,size[1]);
                max2 = Math.max(max2,size[0]);
            }
        }
        
        
        
        return max1 * max2;
    }
}