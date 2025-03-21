import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        long[] arr = new long[101];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }


        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int m = scanner.nextInt();
            sb.append(arr[m-1]).append("\n");
        }

        System.out.println(sb);
    }
}