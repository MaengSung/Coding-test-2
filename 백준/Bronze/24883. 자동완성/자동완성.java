import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if(input.equals("n") || input.equals("N")) {
            System.out.println("Naver D2");
        }
        else{
            System.out.println("Naver Whale");
        }
    }
}