class Solution {
    public int solution(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            if(determine(i)) res+=i;
            else res-=i;
        }
        return res;
    }
    
    private boolean determine(int n){
        int cnt = 0;
        for(int i = 1; i*i <= n; i++){
            if(n%i==0){
                if(i*i == n) cnt++;
                else cnt+=2;
            }
        }
        return cnt % 2 == 0 ? true:false;
    }
}