class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int w = 1; w <= yellow; w++){
            if(yellow % w == 0){
                int l = yellow / w;
                if((w+2) * 2 + 2 * l == brown){
                    answer = new int[]{Math.max(w+2,l+2),Math.min(w+2,l+2)};
                    break;
                }
            }
        }
        
        
        return answer;
    }
}