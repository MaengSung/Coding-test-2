import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(max);
    }

    private static void game(int count) {
        if(count == 5){
            findMax();
            return;
        }

        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = board[i].clone();
        }

        for(int i = 0; i < 4; i++){
            move(i);
            game(count + 1);
            for(int j = 0; j < n; j++){
                board[j] = copy[j].clone();
            }
        }
    }

    private static void move(int dir) {
        switch (dir) {
            case 0:
                up();
                break;
            case 1:
                down();
                break;
            case 2:
                left();
                break;
            case 3:
                right();
                break;
        }
    }

    private static void findMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(board[i][j], max);
            }
        }
    }

    static void right() {
        for (int i = 0; i < n; i++) {
            int index = n-1;
            int block = 0;
            for(int j = n-1; j >= 0; j--) {
                if(board[i][j] != 0){
                    if(board[i][j] == block){
                        board[i][index + 1] = block * 2;
                        board[i][j] = 0;
                        block = 0;
                    }
                    else{
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index--;
                    }
                }
            }
        }

    }
    static void left() {
        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for(int j = 0; j < n; j++) {
                if(board[i][j] != 0){
                    if(board[i][j] == block){
                        board[i][index - 1] = block * 2;
                        board[i][j] = 0;
                        block = 0;
                    }
                    else{
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }
    static void down() {
        for (int i = 0; i < n; i++) {
            int index = n-1;
            int block = 0;
            for (int j = n-1; j >= 0; j--) {
                if(board[j][i] != 0){
                    if(board[j][i] == block){
                        board[index + 1][i] = block * 2;
                        board[j][i] = 0;
                        block = 0;
                    }
                    else{
                        block = board[j][i];
                        board[j][i] = 0;
                        board[index][i] = block;
                        index--;
                    }
                }
            }
        }
    }
    static void up() {
        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if(board[j][i] != 0){
                    if(board[j][i] == block){
                        board[index - 1][i] = block * 2;
                        board[j][i] = 0;
                        block = 0;
                    }
                    else{
                        block = board[j][i];
                        board[j][i] = 0;
                        board[index][i] = block;
                        index++;
                    }
                }
            }
        }
    }
}