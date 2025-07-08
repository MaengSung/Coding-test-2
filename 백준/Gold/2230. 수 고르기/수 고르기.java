import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        while(right < arr.length){
            while(arr[right] - arr[left] >= m && left < right){
                min = Math.min(min, arr[right] - arr[left]);
                left++;
            }
            right++;
        }

        System.out.println(min);
    }
}