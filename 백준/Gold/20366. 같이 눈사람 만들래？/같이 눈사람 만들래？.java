import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static final int INF = 1000000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int min = INF;
        for(int i1 = 0; i1 < n; i1++){
            for(int i2 = i1+3; i2 < n; i2++){
                int j1 = i1 + 1, j2 = i2 - 1;

                while (j1 < j2) {
                    min = Math.min(min, Math.abs(arr[i1] + arr[i2] - arr[j1] - arr[j2]));
                    if(arr[i1] + arr[i2] <= arr[j1] + arr[j2]) j2--;
                    else j1++;
                }
            }
        }
        System.out.println(min);
    }
}