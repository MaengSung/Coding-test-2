class Solution {
    public int solution(int[] a, int[] b) {
        int res = 0;
        for(int i = 0; i < a.length; i++){
            res += a[i] * b[i];
        }
        return res;
    }
}