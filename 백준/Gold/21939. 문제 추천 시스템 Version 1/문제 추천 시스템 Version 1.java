import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<Integer,TreeMap<Integer,Integer>> map = new TreeMap<>();
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            addQuest(map, level, number);
        }

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            String type = st.nextToken();
            switch (type) {
                case "add":
                    int number = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    addQuest(map, level, number);
                    break;
                case "recommend":
                    int request = Integer.parseInt(st.nextToken());
                    if(map.isEmpty()) break;
                    if(request == 1){
                        TreeMap<Integer,Integer> levelMap = map.get(map.lastKey());
                        sb.append(levelMap.lastKey()).append("\n");
                    }
                    else{
                        TreeMap<Integer,Integer> levelMap = map.get(map.firstKey());
                        sb.append(levelMap.firstKey()).append("\n");
                    }
                    break;
                case "solved":
                    int solvedNumber = Integer.parseInt(st.nextToken());
                    if(map.isEmpty()) break;
                    for(int key : map.keySet()){
                        TreeMap<Integer,Integer> levelMap = map.get(key);
                        if(levelMap.containsKey(solvedNumber)){
                            levelMap.put(solvedNumber, levelMap.get(solvedNumber) - 1);
                            if(levelMap.get(solvedNumber) == 0){
                                levelMap.remove(solvedNumber);
                            }
                            if(map.get(key).isEmpty()) map.remove(key);
                            break;
                        }
                    }
                    break;
            }

        }
        System.out.println(sb);

    }

    private static void addQuest(TreeMap<Integer, TreeMap<Integer,Integer>> map, int level, int number) {
        if(!map.containsKey(level)){
            map.put(level, new TreeMap<>());
            map.get(level).put(number, 1);
        }
        else{
            TreeMap<Integer,Integer> levelMap = map.get(level);
            levelMap.put(number, levelMap.getOrDefault(number, 0) + 1);
        }
    }
}