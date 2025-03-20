import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[1000];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 5;

        for (int i = 3; i < n; i++) {
            arr[i] = (arr[i-1] + arr[i-2] * 2) % 10007;
        }

        System.out.println(arr[n-1]);
    }
}