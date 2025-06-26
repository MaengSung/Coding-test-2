class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for(int i = 0; i < balls.length; i++){
            int ballX = balls[i][0];
            int ballY = balls[i][1];

            int min = Integer.MAX_VALUE;

            //위
            if(!(startX == ballX && startY <= ballY)){
                int w = Math.abs(ballX - startX);
                int h = 2 * n - ballY - startY;

                min = Math.min(min, w * w + h * h);
            }

            //아래
            if(!(startX == ballX && startY >= ballY)){
                int w = Math.abs(ballX - startX);
                int h = ballY + startY;

                min = Math.min(min, w * w + h * h);
            }

            //오른쪽
            if(!(startY == ballY && startX <= ballX)){
                int w = 2 * m - ballX - startX;
                int h = Math.abs(ballY - startY);
                
                min = Math.min(min, w * w + h * h);
            }
            
            //왼쪽
            if(!(startY == ballY && startX >= ballX)){
                int w = ballX + startX;
                int h = Math.abs(ballY - startY);
                
                min = Math.min(min, w * w + h * h);
            }
            
            answer[i] = min;
        }

        return answer;
    }
}