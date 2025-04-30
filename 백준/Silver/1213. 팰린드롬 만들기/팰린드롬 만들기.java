import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();

        for(char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if(checkNotChange(map)){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] arr = new char[input.length()];
        int left = 0;
        int right = arr.length - 1;
        for(char key : map.keySet()) {
            int halfCount = map.get(key) / 2;
            for(int i = 0; i < halfCount; i++) {
                arr[left++] = key;
                arr[right--] = key;
            }
            if(map.get(key) % 2 != 0){
                arr[arr.length/2] = key;
            }
        }

        StringBuilder res = new StringBuilder();
        for(char c : arr) {
            res.append(c);
        }
        System.out.println(res);
    }

    private static boolean checkNotChange(TreeMap<Character, Integer> map) {
        int notTwo = 0;
        for(int cnt : map.values()) {
            if(cnt%2 != 0){
                notTwo++;
                if(notTwo > 1){
                    return true;
                }
            }
        }
        return false;
    }
}