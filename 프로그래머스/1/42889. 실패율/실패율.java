import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failUserCnts = new int[N+2];
        int[] totalUserCnts = new int[N+1];
        Map<Integer,Double> map = new HashMap<>();

        for(int stage : stages){
            failUserCnts[stage]++;
        }

        totalUserCnts[N] = failUserCnts[N] + failUserCnts[N+1];
        for(int i = N-1; i > 0; i--){
            totalUserCnts[i] = totalUserCnts[i+1] + failUserCnts[i];
        }

        for(int i = 1; i <= N; i++){
            if(failUserCnts[i] == 0 || totalUserCnts[i] == 0){
                map.put(i,0.0);
            }
            else{
                map.put(i, (double) failUserCnts[i] / totalUserCnts[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(i->i).toArray();
    }
}