import java.util.*;

class Solution {
    private Set<Integer> comb = new HashSet<>();
    public int solution(String numbers) {
        
        int cnt = 0;
        boolean[] visited = new boolean[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++){
            recursion(numbers,new StringBuilder(),i, visited);    
        }
        
        for(int num : comb){
            if(isPrime(num)) cnt++;
        }
        
        
        return cnt;
    }
    
    private void recursion(String str, StringBuilder temp, int r, boolean[] visited){
        if(r==0){
            int num = Integer.parseInt(temp.toString());
            comb.add(num);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            if(!visited[i]){
                temp.append(str.charAt(i));
                visited[i] = true;
                recursion(str,temp,r-1,visited);
                visited[i] = false;
                temp.deleteCharAt(temp.length()-1);
            }
        }
        
    }
    
    private boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}