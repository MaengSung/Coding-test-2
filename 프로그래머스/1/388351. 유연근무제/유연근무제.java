class Solution {
    public int solution(int[] schedules, int[][] timeLogs, int startDay) {
        int answer = 0;

        int staffCount = schedules.length;

        for(int i = 0; i < staffCount; i++){

            int limitTime = getLimitTime(schedules[i]);
            boolean check = true;
            for(int j = 0; j < 7; j++){
                int day = (startDay + j - 1) % 7;
                if(day < 5 && timeLogs[i][j] > limitTime){
                    check = false;
                    break;
                }
            }

            if(check) answer++;
        }

        return answer;
    }

    private int getLimitTime(int schedule) {

        int hour = (schedule / 100) * 100;
        int minute = (schedule % 100 )+ 10;

        int res = 0;
        if(minute / 60 > 0){
            res = hour + 100 + (minute % 60);
        }
        else{
            res = hour + minute;
        }

        return Math.min(res,2359);
    }
}