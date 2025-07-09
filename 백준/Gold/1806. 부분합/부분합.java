import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long s = sc.nextLong();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int st = 0, en = 0;
        long cnt = 0;
        long min = Long.MAX_VALUE;
        while(en < n) {
            cnt+=arr[en];
            while(cnt >= s && st <= en) {
                if(en - st + 1 < min) {
                    min = en - st + 1;
                }
                cnt -= arr[st];
                st++;
            }
            en++;
        }
        System.out.println(min == Long.MAX_VALUE ? 0 : min);
    }
}