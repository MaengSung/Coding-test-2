import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[n-1]);
    }
}