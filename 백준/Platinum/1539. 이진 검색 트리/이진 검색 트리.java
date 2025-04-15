import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long res = 0;


        int n = sc.nextInt();

        int[] len = new int[n];
        TreeSet<Integer> tree = new TreeSet<>();

        while(n-- > 0){
            int num = sc.nextInt();

            if(tree.higher(num) == null){
                if(tree.lower(num) == null){
                    len[num] = 1;
                }
                else{
                    len[num] = len[tree.lower(num)] + 1;
                }
            }
            else{
                if(tree.lower(num) == null){
                    len[num] = len[tree.higher(num)] + 1;
                }
                else{
                    len[num] =Math.max(len[tree.lower(num)], len[tree.higher(num)])+1;
                }
            }
            tree.add(num);
            res += len[num];
        }
        System.out.println(res);
    }
}