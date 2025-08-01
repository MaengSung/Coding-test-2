class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = 200000000;
        while(min <= max){
            int mid = (min+max)/2;
            if(check(mid,stones,k)){
                min = mid + 1;
                answer = Math.max(answer, mid);
            }
            else{
                max = mid - 1;
            }
        }  
        return answer;
    }
    
    private boolean check(int friend, int[] stones, int k){
        int skip = 0;
        for(int stone : stones){
            if(stone < friend) skip++;
            else skip = 0;
            
            if(skip == k) return false;
        }
        return true;
    }
}