class Solution {
    public long solution(int r1, int r2) {
        long count = 0;

        for (int x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            long minY = 0;

            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            }

            count += (maxY - minY + 1); // 해당 x에 대해 가능한 y의 수
        }

        return count * 4; // 전체 4사분면 반영
    }
}
