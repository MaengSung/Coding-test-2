import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, (o1,o2) -> {
            if(o1[0] == o2[0]) return Long.compare(o2[1], o1[1]);
            return Long.compare(o1[0], o2[0]);
        });

        long res = 0;
        long last = -1000000001;
        for(long[] arr1 : arr) {
            if(arr1[0] > last){
                res+= arr1[1] - arr1[0];
                last = arr1[1];
                continue;
            }

            if(arr1[1] <= last) continue;

            res += arr1[1] - last;
            last = arr1[1];
        }

        System.out.println(res);
    }
}