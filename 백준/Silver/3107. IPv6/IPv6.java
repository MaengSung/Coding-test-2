import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        if(input.contains("::")) input = input.replaceAll("::", ":group:");

        List<String> ips = new ArrayList<>();
        for(String ip : input.split(":")) {
            if(ip.isEmpty()) continue;
            StringBuilder ipBuilder = new StringBuilder(ip);
            while(ipBuilder.length() < 4){
                ipBuilder.insert(0, "0");
            }
            ips.add(ipBuilder.toString());
        }

        int length = 8 - ips.size() + 1;
        String[] res = new String[8];
        int idx = 0;
        for(String ip : ips){
            if(ip.equals("group")){
                while(length-- > 0){
                    res[idx++] = "0000";
                }
            }
            else res[idx++] = ip;
        }

        System.out.println(String.join(":",res));
    }
}