import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int[] size = searchSize(input.length());

        int w = size[1];
        int h = size[0];

        char[][] map = new char[h][w];

        int idx = 0;
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                map[j][i] = input.charAt(idx++);
            }
        }


        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(map[i][j]);
            }
        }
    }

    private static int[] searchSize(int length) {
        int[] res = new int[2];

        int base = (int) Math.ceil(Math.sqrt(length));
        for(int r = 1; r <= base; r++) {
            if(length % r == 0) {
                int c = length / r;
                if(r <= c) {
                    res[0] = r;
                    res[1] = c;
                }
            }
        }
        return res;
    }
}