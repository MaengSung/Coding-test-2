import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Flower[] flowers = new Flower[n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            
            flowers[i] = new Flower(changeDate(m1,d1), changeDate(m2,d2));
        }
        
        Arrays.sort(flowers);
        
        int idx=0, max=0, res=0;
        int start = changeDate(3,1);
        int end = changeDate(12,1);
        while(start < end){
            boolean find = false;
            for(int i = idx; i < n; i++){
                if(flowers[i].startDay > start) break;
                
                if(flowers[i].endDay > max){
                    max = flowers[i].endDay;
                    find = true;
                    idx = i + 1;
                }
            }
            if(find){
                start = max;
                res++;
            }
            else break;
        }
        
        if(max < end) System.out.println(0);
        else System.out.println(res);
    }
    
    private static int changeDate(int m, int d){
        return m*100 + d;
    }
    
    static class Flower implements Comparable<Flower>{
        int startDay;
        int endDay;
        
        public Flower(int startDay, int endDay){
            this.startDay = startDay;
            this.endDay = endDay;
        }
        
        @Override
        public int compareTo(Flower o){
            if(this.startDay == o.startDay) return o.endDay - this.endDay;
            return this.startDay - o.startDay;
        }
    }
}