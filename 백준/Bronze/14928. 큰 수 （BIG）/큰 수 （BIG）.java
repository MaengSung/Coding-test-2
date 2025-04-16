import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int cnt = 0;
        for(int i = 0; i < n.length(); i++){
            cnt *= 10;
            cnt += n.charAt(i) - '0';
            cnt %= 20000303;
        }
        System.out.println(cnt);
    }
}