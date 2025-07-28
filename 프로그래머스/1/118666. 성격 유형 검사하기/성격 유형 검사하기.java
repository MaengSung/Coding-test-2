import java.util.Arrays;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[][] points = new int[4][2];

        for(int i = 0; i < survey.length; i++){
            String s = survey[i];
            int p = 4 - choices[i];
            if(p == 0) continue;

            if(s.charAt(0) == 'R'){
                if(p > 0){
                    points[0][0] += Math.abs(p);
                }
                if(p < 0){
                    points[0][1] += Math.abs(p);
                }
            }
            if(s.charAt(0) == 'T'){
                if(p > 0){
                    points[0][1] += Math.abs(p);
                }
                if(p < 0){
                    points[0][0] += Math.abs(p);
                }
            }

            if(s.charAt(0) == 'C'){
                if(p > 0){
                    points[1][0] += Math.abs(p);
                }
                if(p < 0){
                    points[1][1] += Math.abs(p);
                }
            }
            if(s.charAt(0) == 'F'){
                if(p > 0){
                    points[1][1] += Math.abs(p);
                }
                if(p < 0){
                    points[1][0] += Math.abs(p);
                }
            }

            if(s.charAt(0) == 'J'){
                if(p > 0){
                    points[2][0] += Math.abs(p);
                }
                if(p < 0){
                    points[2][1] += Math.abs(p);
                }
            }
            if(s.charAt(0) == 'M'){
                if(p > 0){
                    points[2][1] += Math.abs(p);
                }
                if(p < 0){
                    points[2][0] += Math.abs(p);
                }
            }

            if(s.charAt(0) == 'A'){
                if(p > 0){
                    points[3][0] += Math.abs(p);
                }
                if(p < 0){
                    points[3][1] += Math.abs(p);
                }
            }

            if(s.charAt(0) == 'N'){
                if(p > 0){
                    points[3][1] += Math.abs(p);
                }
                if(p < 0){
                    points[3][0] += Math.abs(p);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(points[0][0] >= points[0][1]) sb.append('R');
        else sb.append('T');

        if(points[1][0] >= points[1][1]) sb.append('C');
        else sb.append('F');

        if(points[2][0] >= points[2][1]) sb.append('J');
        else sb.append('M');

        if(points[3][0] >= points[3][1]) sb.append('A');
        else sb.append('N');

        return sb.toString();
    }
}