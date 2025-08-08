import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    if (arr[left] == arr[right]) { 
                        // left~right 사이의 모든 조합 수
                        int len = right - left + 1;
                        cnt += (long) len * (len - 1) / 2;
                        break; 
                    }

                    // 같은 값이 몇 개 있는지 세기
                    int lCount = 1, rCount = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        lCount++;
                        left++;
                    }
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rCount++;
                        right--;
                    }

                    cnt += (long) lCount * rCount;
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(cnt);
    }
}
