import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Long n = sc.nextLong();
        Long m = sc.nextLong();

        System.out.println(Math.abs(n-m));
    }
}