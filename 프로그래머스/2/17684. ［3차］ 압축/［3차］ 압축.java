import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int index = 27;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));
            while (i + 1 < msg.length() && dict.containsKey(sb.toString() + msg.charAt(i + 1))) {
                i++;
                sb.append(msg.charAt(i));
            }

            list.add(dict.get(sb.toString()));

            if (i + 1 < msg.length()) {
                dict.put(sb.toString() + msg.charAt(i + 1), index++);
            }

            sb.setLength(0);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
