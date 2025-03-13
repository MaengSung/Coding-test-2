import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] res = new int[3];
        
        for(int i = 1; i <= answers.length; i++){
            
            //1번 수포자
            if(i % 5 == 0 && answers[i-1] == 5) res[0]++;
            else if(i % 5 == answers[i-1]) res[0]++;
            
            
            //2번 수포자
            if(i%2==1 && answers[i-1] == 2) res[1]++;
            else{
                switch(i%8){
                    case 2:
                        if(answers[i-1] == 1) res[1]++;
                        break;
                    case 4:
                        if(answers[i-1] == 3) res[1]++;
                        break;
                    case 6:
                        if(answers[i-1] == 4) res[1]++;
                        break;
                    case 0:
                        if(answers[i-1] == 5) res[1]++;
                        break;
                }
            }
            
            //3번 수포자
            switch (i % 10) {
                case 0,9:
                    if(answers[i-1] == 5) res[2]++;
                    break;
                case 1,2:
                    if(answers[i-1] == 3) res[2]++;
                    break;
                case 3,4:
                    if(answers[i-1] == 1) res[2]++;
                    break;
                case 5,6:
                    if(answers[i-1] == 2) res[2]++;
                    break;
                case 7,8:
                    if(answers[i-1] == 4) res[2]++;
                    break;
            }         
        }
        int max = Math.max(res[0],Math.max(res[1],res[2]));
        
        int[] result = IntStream.range(0,res.length).filter(i -> res[i] >= max).map(i -> i+1).toArray();
        
        return result;
    }
}