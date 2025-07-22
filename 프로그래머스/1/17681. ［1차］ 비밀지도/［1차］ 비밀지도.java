class Solution {
    static boolean[][] walls;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        walls = new boolean[n][n];
        
        changeMap(n,arr1);
        changeMap(n,arr2);
        
        StringBuilder sb;
        for(int i = 0; i < n; i++){
            sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(walls[i][j])sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private void changeMap(int n, int[] arr){
        for(int i = 0; i < n; i++){
            String width = Integer.toString(arr[i],2);
            while(width.length() < n){
                width = "0" + width;
            }
            for(int j = 0; j < n; j++){
                char c = width.charAt(j);
                if(c == '1') walls[i][j] = true;
            }
        }
    }
}