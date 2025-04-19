import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        TreeSet<Integer> tree = new TreeSet<>();
        
        while(n-- > 0){
            int next = sc.nextInt();
            tree.add(next);
        }
        
        System.out.println(tree.last() * tree.first());
    }
}