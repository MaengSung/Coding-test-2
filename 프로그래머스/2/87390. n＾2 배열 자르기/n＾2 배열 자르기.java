class Solution {
    public int[] solution(int n, long left, long right) {
        int cnt = (int) (right - left) + 1;
        int[] res = new int[cnt];
        for(int i = 0; i < cnt; i++){
            long x = (left+i) / n ;
            long y = (left+i) % n ;
            res[i] = (int) Math.max(x,y) + 1;
        }
        return res;
    }
}