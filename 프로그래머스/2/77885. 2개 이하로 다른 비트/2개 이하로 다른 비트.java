class Solution {
    public long[] solution(long[] numbers) {
        long[] res = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if(num % 2 == 0){
                res[i] = num + 1;
            }
            else{
                long bit = 1;
                while((num & bit) != 0){
                    bit *= 2;
                }
                res[i] = num + bit - bit / 2;
            }
        }
        return res;
    }
}