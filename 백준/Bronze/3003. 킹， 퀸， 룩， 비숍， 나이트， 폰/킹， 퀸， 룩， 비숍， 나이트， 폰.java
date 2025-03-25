import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            switch (i){
                case 0:
                    sb.append(1 - arr[i]);
                    break;
                case 1:
                    sb.append(1 - arr[i]);
                    break;
                case 2:
                    sb.append(2 - arr[i]);
                    break;
                case 3:
                    sb.append(2 - arr[i]);
                    break;
                case 4:
                    sb.append(2 - arr[i]);
                    break;
                case 5:
                    sb.append(8 - arr[i]);
                    break;
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}