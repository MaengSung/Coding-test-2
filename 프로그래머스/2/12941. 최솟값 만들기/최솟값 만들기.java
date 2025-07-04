import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int res = 0;
        for(int i = 0; i < A.length; i++){
            int a = A[i] * B[B.length - 1 - i];
            res+= a;
        }
        return res;
    }
}