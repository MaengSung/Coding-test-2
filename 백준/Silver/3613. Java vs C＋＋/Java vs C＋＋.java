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
                int type = cur - 'A';
                //비정상
                //대문자인 경우
                if(type >= 0 && type <= 25){
                    System.out.println("Error!");
                    return;
                }
                //앞 뒤가 _ 인 경우
                if((i == 0 || i == input.length() -1) && type == 30) {
                    System.out.println("Error!");
                    return;
                }
                //연속적으로 _인 경우
                if(snake && type == 30){
                    System.out.println("Error!");
                    return;
                }
                //정상
                //_인 경우
                if(type == 30){
                    snake = true;
                    continue;
                }

                if(!snake) sb.append(cur);
                if(snake){
                    sb.append(String.valueOf(cur).toUpperCase());
                    snake = false;
                }
            }
        }
        if(!C){
            for(int i = 0; i < input.length(); i++){
                char cur = input.charAt(i);
                int type = cur - 'A';

                //비정상
                //_가 들어간 경우
                if(cur == '_'){
                    System.out.println("Error!");
                    return;
                }
                //대문자가 맨 앞에 온 경우
                if(type >= 0 && type <= 25){
                    if(i == 0) {
                        System.out.println("Error!");
                        return;
                    }
                    //정상적인 대문자인 경우
                    else{
                        sb.append("_").append(String.valueOf(cur).toLowerCase());
                    }
                }

                //정상적인 소문자인 경우
                if(type >= 32 && type <= 57) sb.append(cur);
            }
        }
        System.out.println(sb);
    }
}