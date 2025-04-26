import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        while(!(a == 0 && b == 0)){
            sb.append(a+b).append("\n");
            a = scanner.nextInt();
            b = scanner.nextInt();
        }
        System.out.println(sb);
    }
}