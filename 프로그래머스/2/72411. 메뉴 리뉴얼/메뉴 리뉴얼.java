import java.util.*;
import java.util.Map.Entry;

class Solution {
    private Map<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for(int cur : course){
            map = new HashMap<>();
            int max = -1;
            for(String order : orders){
                StringBuilder sb = new StringBuilder();
                if(cur <= order.length()){
                    combi(cur,sb,0,0,order);
                }
            }

            for(Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }

            if(max > 1){
                for(Entry<String,Integer> entry : map.entrySet()){
                    if(entry.getValue() == max){
                        res.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(res);

        return res.toArray(new String[res.size()]);
    }

    private void combi(int n, StringBuilder sb, int idx, int cnt, String order){
        if(n == cnt){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        for(int i = idx; i < order.length(); i++){
            sb.append(order.charAt(i));
            combi(n,sb,i+1,cnt+1,order);
            sb.delete(cnt,cnt+1);
        }
    }
}