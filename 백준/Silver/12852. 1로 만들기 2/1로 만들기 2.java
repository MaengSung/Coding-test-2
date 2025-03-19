import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1]; 
        String[] strArr = new String[n + 1]; 

        arr[1] = 0;
        strArr[1] = "1";

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1; 
            strArr[i] = i + " " + strArr[i - 1];

            if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
                arr[i] = arr[i / 2] + 1;
                strArr[i] = i + " " + strArr[i / 2];
            }

            if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
                arr[i] = arr[i / 3] + 1;
                strArr[i] = i + " " + strArr[i / 3];
            }
        }

        System.out.println(arr[n]); 
        System.out.println(strArr[n]);
    }
}
