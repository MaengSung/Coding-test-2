class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;

        int startSec = parseToSec(h1,m1,s1);
        int endSec = parseToSec(h2,m2,s2);

        answer = countAlrams(endSec) - countAlrams(startSec);

        return answer += alramNow(startSec) ? 1 : 0;
    }

    private boolean alramNow(int sec) {
        return sec * 59 / 3600 ==0 || sec * 719 % 43200 == 0;
    }

    private int parseToSec(int h, int m, int s) {
        return h * 60 * 60 + m * 60 + s;
    }

    private int countAlrams(int sec) {
        int minuteAlrams = sec * 59 / 3600;
        int hourAlrams = sec * 719 / 43200;

        int duplicateAlrams = sec >= 43200 ? 2 : 1;

        return minuteAlrams + hourAlrams - duplicateAlrams;
    }
}