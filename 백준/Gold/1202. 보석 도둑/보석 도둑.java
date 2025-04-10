import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Jewel[] jewels = new Jewel[n];
        int[] bags = new int[k];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            jewels[i] = new Jewel(m,v);
        }
        Arrays.sort(jewels);
        
        for(int i = 0; i < k; i++) bags[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bags);
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0, j = 0; i < k; i++){
            while(j < n && bags[i] >= jewels[j].weight){
                pq.offer(jewels[j++].value);
            }
            
            if(!pq.isEmpty()) ans += pq.poll();
        }
        
        System.out.println(ans);
    }
    
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;
        
        Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        
        @Override
        public int compareTo(Jewel o){
            if(this.weight == o.weight) return o.value - this.value;
            return this.weight - o.weight;
        }
    }
}