class Solution {
    public int solution(int n) {
        int res = 0;
        for(int i = 2; i < n; i++){
            if(n%i == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}