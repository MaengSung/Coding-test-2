import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            long a = sc.nextInt();
            long b = sc.nextInt();

            sb.append(a+b).append("\n");
        }

        System.out.println(sb);
    }
}