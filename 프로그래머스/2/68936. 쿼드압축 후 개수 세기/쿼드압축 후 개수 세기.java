class Solution {
    private int[][] map;
    private int one = 0;
    private int zero = 0;
    public int[] solution(int[][] arr) {
        map = arr;
        recur(0,0,arr.length -1, arr[0].length - 1);
        return new int[]{zero,one};
    }

    private void recur(int x1, int y1, int x2, int y2){
        if(check(x1,y1,x2,y2)){
            if(map[x1][y1] == 1) one++;
            else zero++;
            return;
        }

        recur(x1,y1,(x2+x1)/2,(y2+y1)/2);
        recur((x2+x1)/2+1,y1,x2,(y2+y1)/2);
        recur(x1,(y2+y1)/2+1,(x2+x1)/2,y2);
        recur((x2+x1)/2+1,(y2+y1)/2+1,x2,y2);
    }

    private boolean check(int x1, int y1, int x2, int y2){
        int base = map[x1][y1];
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(map[i][j] != base) return false;
            }
        }
        return true;
    }
}