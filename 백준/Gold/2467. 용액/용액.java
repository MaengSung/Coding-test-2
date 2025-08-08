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
        for(int i = 0; i < n-1; i++){
            int left = i+1;
            int right = n-1;
            while(left <= right){
                int mid = (left + right)/2;
                long sum = Math.abs(arr[i] + arr[mid]);
                if(min > sum){
                    min = sum;
                    ml = i;
                    mr = mid;
                }

                if(arr[mid] >= -arr[i]){
                    right = mid -1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        System.out.println(arr[ml] + " " + arr[mr]);
    }
}