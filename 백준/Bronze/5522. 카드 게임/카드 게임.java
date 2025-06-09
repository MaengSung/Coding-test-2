import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int res = 0;
        for(int i = 0; i < 5; i++){
            res += scanner.nextInt();
        }

        System.out.println(res);
    }
}