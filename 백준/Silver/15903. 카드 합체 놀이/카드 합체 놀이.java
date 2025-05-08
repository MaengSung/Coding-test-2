import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < m; i++){
            Arrays.sort(arr);

            long next = arr[0] + arr[1];
            arr[0] = next;
            arr[1] = next;
        }

        System.out.println(Arrays.stream(arr).sum());
    }
}