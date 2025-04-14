import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeMap<Integer,Integer> students = new TreeMap<>();
        TreeSet<Team> teams = new TreeSet<>();
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            students.put(h,c);
        }
        
        for(int h : students.descendingKeySet()){
            if(teams.isEmpty()){
                teams.add(new Team(h,1));
                continue;
            }
            
            Team nearestTeam = teams.lower(new Team(h,students.get(h)));
            if(nearestTeam == null){
                teams.add(new Team(h,1));
                continue;
            }
            nearestTeam.studentCnt++;
        }
        
        System.out.println(teams.size());
    }
    
    static class Team implements Comparable<Team> {
        int maxHeight;
        int studentCnt;
        
        Team(int maxHeight, int studentCnt){
            this.maxHeight = maxHeight;
            this.studentCnt = studentCnt;
        }
        
        @Override
        public int compareTo(Team t){
            if(this.studentCnt == t.studentCnt) return this.maxHeight - t.maxHeight;
            return this.studentCnt - t.studentCnt;
        }
    }
}