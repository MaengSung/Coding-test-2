import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }

        long min = Long.MAX_VALUE;
        int ml = 0, mr = 0;
        int left = 0, right = n-1;
        while(left < right){
            long sum = arr[left] + arr[right];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }
            if(sum >= 0) right--;
            else left++;
        }
        System.out.println(arr[ml] + " " + arr[mr]);
    }
}