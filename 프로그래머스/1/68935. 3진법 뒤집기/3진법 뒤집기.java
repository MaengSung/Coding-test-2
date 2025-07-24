class Solution {
    public int solution(int n) {
        String t = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder();
        for(int i = t.length()-1; i>=0; i--){
            sb.append(t.charAt(i));
        }
        
        return Integer.parseInt(String.valueOf(Long.parseLong(sb.toString())),3);
    }
}