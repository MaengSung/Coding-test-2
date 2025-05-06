import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Long> list = new ArrayList<>();

        for(int i = 0; i < n; i++) list.add(sc.nextLong());

        Collections.sort(list);

        long max = 0;
        for(Long l : list){
            if(l * n > max) max = l * n;
            n--;
        }

        System.out.println(max);
    }
}