import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        System.out.println((int) (n* 0.78) + " " + (int)(n - n * 0.2 * 0.22));
    }
}