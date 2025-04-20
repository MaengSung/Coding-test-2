import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }
            if(Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }
        }

        System.out.println(sb);
    }
}