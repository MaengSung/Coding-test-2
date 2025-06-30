import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        StringTokenizer st;
        for(String operation : operations){
            st = new StringTokenizer(operation);

            String order = st.nextToken();
                if(order.equals("I")) {
                    int addNum = Integer.parseInt(st.nextToken());
                    minQ.offer(addNum);
                    maxQ.offer(addNum);
                }
                if(order.equals("D")){
                    if(minQ.size() == 0 && maxQ.size() == 0) continue;
                    if(minQ.size() == 1 && maxQ.size() == 1){
                        minQ.poll();
                        maxQ.poll();
                    }
                    else{
                        String nextOrder = st.nextToken();
                        if(nextOrder.equals("1")){
                            int removeNum = maxQ.poll();
                            minQ.remove(removeNum);
                            continue;
                        }
                        if(nextOrder.equals("-1")){
                            int removeNum = minQ.poll();
                            maxQ.remove(removeNum);
                        }
                    }
                }
        }


        if(maxQ.size() == 0 && minQ.size() == 0) return new int[]{0,0};
        return new int[]{maxQ.poll(),minQ.poll()};

    }
}