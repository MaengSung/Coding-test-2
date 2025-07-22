class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder num = new StringBuilder();
        for(int i = 0; i < t*m; i++){
            num.append(Integer.toString(i,n).toUpperCase());
        }
        
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        while(cnt++ < t){
            res.append(num.toString().charAt(p-1));
            p += m;
        }
        
        return res.toString();
    }
}