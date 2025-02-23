import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t  = sc.nextInt();
        List<String> arr = new ArrayList<String>();
        while(t-->0) arr.add(sc.next());

        boolean[] d = new boolean[arr.get(0).length()];

        for(int i=0; i<arr.size(); i++){
            for(int j=i+1; j<arr.size(); j++){
                for(int k = 0; k < arr.get(i).length(); k++){
                    if(arr.get(i).charAt(k) != arr.get(j).charAt(k)) d[k] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<arr.get(0).length(); i++) {
            if(!d[i]) sb.append(arr.get(0).charAt(i));
            else sb.append("?");
        }

        System.out.println(sb);

    }
}