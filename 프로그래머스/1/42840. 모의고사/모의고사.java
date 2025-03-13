import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns ={
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] match = new int[3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < answers.length; j++){
                if(patterns[i][j%patterns[i].length] == answers[j]) match[i]++;
            }
        }
        
        int max = Math.max(match[0],Math.max(match[1],match[2]));
        
        return IntStream.range(0,3)
            .filter(i -> match[i] >= max)
            .map(i -> i+1)
            .toArray();
    }
}