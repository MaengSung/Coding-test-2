import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long cnt = 0;
        for(int i = 0; i < n-2; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    if(arr[left] == arr[right]){
                        int len = right - left + 1;
                        cnt += (long) len * (len - 1) / 2;
                        break;
                    }

                    int lCnt = 1, rCnt = 1;
                    while(left < right - 1 && arr[left] == arr[left+1]){
                        lCnt++;
                        left++;
                    }
                    while(right > left + 1 && arr[right] == arr[right - 1]){
                        rCnt++;
                        right--;
                    }

                    cnt += (long)lCnt * rCnt;
                    left++;
                    right--;
                }

                else if(sum < 0) left++;
                else right--;
            }
        }

        System.out.println(cnt);
    }
}