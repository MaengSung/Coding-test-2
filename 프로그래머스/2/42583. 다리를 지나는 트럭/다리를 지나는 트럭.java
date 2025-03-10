import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bw = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) q.offer(0);
        
        for(int truck : truck_weights){
            while(true){
                bw -= q.poll();

                if(bw + truck <= weight){
                    q.offer(truck);
                    time++;
                    bw += truck;
                    break;
                }
                else{
                    q.offer(0);
                    time++;
                }
            }
        }
        
        return time + bridge_length;
    }
}