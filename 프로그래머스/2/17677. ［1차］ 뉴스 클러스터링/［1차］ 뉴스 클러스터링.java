import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String,Integer> map1 = makeMap(str1);
        Map<String,Integer> map2 = makeMap(str2);
        int union = getUnion(map1,map2);
        return union;
    }
    
    private Map<String,Integer> makeMap(String str){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 1; i++){
            String s = str.substring(i,i+2).toUpperCase();
            if(!s.matches("[A-Z]+")) continue;
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        return map;
    }
    
    private int getUnion(Map<String,Integer> map1, Map<String,Integer> map2){
        if(map1.isEmpty() && map2.isEmpty()) return 65536;
        Map<String, Integer> union = new HashMap<>();
        
        for(String key : map1.keySet()){
            union.put(key,map1.get(key));
        }
        
        int res1 = 0;
        for(String key : map2.keySet()){
            if(union.containsKey(key)){
                res1 += Math.min(union.get(key),map2.get(key));
                union.put(key,Math.max(union.get(key), map2.get(key)));
            }
            else{
                union.put(key,map2.get(key));
            }
        }
        
        int res2 = 0;
        for(int cnt : union.values()){
            res2 += cnt;
        }
        
        int res = (int) Math.floor(((double) res1 / res2) * 65536);
        return res;
    }
}