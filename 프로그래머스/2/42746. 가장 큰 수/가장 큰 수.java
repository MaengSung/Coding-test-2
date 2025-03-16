import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(strArr,(x,y) -> (y+x).compareTo(x+y));
        
        if(strArr[0].equals("0")) return "0";
        
        return String.join("",strArr);
    }
}
