import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] res = new int[commands.length];
        
        int idx = 0;
        for(int[] com: commands){
            int[] arr = IntStream.range(com[0]-1,com[1])
                .map(i -> array[i])
                .toArray();
            
            Arrays.sort(arr);
            res[idx] = arr[com[2]-1];
            idx++;
        }
        
        return res;
    }
}