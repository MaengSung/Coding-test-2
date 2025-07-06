import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("LoveisKoreaUniversity");
            if(i != n-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}