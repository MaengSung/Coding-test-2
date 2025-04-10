import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Jewel[] jewels = new Jewel[n];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewels);

        for(int i = 0; i < k; i++) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0, j = 0; i < k; i++){
            while(j < n && (jewels[j].weight <= bags[i])){
                pq.offer(jewels[j++].value);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        System.out.println(answer);
    }

    private static class Jewel implements Comparable<Jewel>{
        int weight;
        int value;

        Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }


        @Override
        public int compareTo(Jewel o) {
            if(o.weight == this.weight) return this.value - o.value;
            return this.weight - o.weight;
        }
    }
}