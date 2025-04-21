import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<BigInteger> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        while(n-- >0){
            String input = br.readLine();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        list.add(new BigInteger(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }

            if (sb.length() > 0) {
                list.add(new BigInteger(sb.toString()));
            }
        }

        Collections.sort(list);
        for(BigInteger num : list){
            System.out.println(num);
        }
    }
}