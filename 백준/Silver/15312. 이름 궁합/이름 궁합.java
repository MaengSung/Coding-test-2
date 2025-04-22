import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static int[] points = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String him = br.readLine();
        String her = br.readLine();

        List<Integer> first = new ArrayList<>();
        for(int i = 0; i < him.length(); i++) {
            char he = him.charAt(i);
            char she = her.charAt(i);

            first.add(points[he - 'A']);
            first.add(points[she - 'A']);
        }

        System.out.println(getPoint(first));
    }

    private static String getPoint(List<Integer> first) {
        List<Integer> list = new ArrayList<>(first);

        while(list.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for(int i = 0; i < list.size()-1; i++) {
                next.add((list.get(i) + list.get(i+1)) % 10);
            }
            list = new ArrayList<>(next);
        }

        return String.valueOf(list.get(0)) + list.get(1);
    }
}