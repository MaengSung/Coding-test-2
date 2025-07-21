import java.util.*;

class Solution {
    Map<String,Integer> dict = new HashMap<>();
    
    public int solution(String s) {
        init();
        
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) res.append(c);
            else{
                sb.append(c);
                if(dict.containsKey(sb.toString())){
                    res.append(dict.get(sb.toString()));
                    sb = new StringBuilder();
                }
            }
        }
        
        return Integer.parseInt(res.toString());
    }
    
    private void init(){
        dict.put("zero",0);
        dict.put("one",1);
        dict.put("two",2);
        dict.put("three",3);
        dict.put("four",4);
        dict.put("five",5);
        dict.put("six",6);
        dict.put("seven",7);
        dict.put("eight",8);
        dict.put("nine",9);
    }

}