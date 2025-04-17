import java.io.*;
import java.util.Scanner;

public class Main{
    private final static String[] DIC = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int res = 0;

        for(int i = 0; i < input.length();){
            boolean find = false;
            for(String str : DIC){
                if(input.startsWith(str, i)){
                    i+=str.length();
                    find = true;
                    break;
                }
            }
            res++;
            if(!find) i++;
        }
        System.out.println(res);
    }
}