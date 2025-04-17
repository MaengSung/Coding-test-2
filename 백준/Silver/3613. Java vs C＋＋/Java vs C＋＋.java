import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for(char c : input.toCharArray()){
            int type = c - 'A';

            if (type == 30) continue;
            if (type >= 0 && type <= 25) continue;
            if (type >= 32 && type <= 57) continue;

            System.out.println("Error!");
            return;
        }
        StringBuilder sb = new StringBuilder();

        boolean C = input.contains("_");

        if(C){
            boolean snake = false;
            for(int i = 0; i < input.length(); i++){
                char cur = input.charAt(i);
                //비정상
                //대문자인 경우
                if(Character.isUpperCase(cur)){
                    System.out.println("Error!");
                    return;
                }
                //앞 뒤가 _ 인 경우, 연속적으로 _인 경우
                if(input.startsWith("_") || input.endsWith("_") || input.contains("__")) {
                    System.out.println("Error!");
                    return;
                }
                //정상
                //_인 경우
                if(cur == '_'){
                    snake = true;
                    continue;
                }
                if(!snake) sb.append(cur);
                if(snake){
                    sb.append(Character.toUpperCase(cur));
                    snake = false;
                }
            }
        }
        if(!C){
            for(int i = 0; i < input.length(); i++){
                char cur = input.charAt(i);
                //대문자가 맨 앞에 온 경우
                if(Character.isUpperCase(cur)){
                    if(i == 0) {
                        System.out.println("Error!");
                        return;
                    }
                    //정상적인 대문자인 경우
                    else{
                        sb.append("_").append(Character.toLowerCase(cur));
                    }
                }
                //정상적인 소문자인 경우
                if(Character.isLowerCase(cur)) sb.append(cur);
            }
        }
        System.out.println(sb);
    }
}