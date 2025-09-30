import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();

        Map<String, Integer> cnt = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(!cnt.containsKey(genres[i])){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i],map);
                cnt.put(genres[i],plays[i]);
            }
            else{
                music.get(genres[i]).put(i,plays[i]);
                cnt.put(genres[i], cnt.get(genres[i]) + plays[i]);
            }
        }

        List<String> order = new ArrayList<>(cnt.keySet());
        order.sort((s1, s2) -> cnt.get(s2) - cnt.get(s1));

        for(String genre : order){
            Map<Integer, Integer> map = music.get(genre);
            List<Integer> key = new ArrayList<>(map.keySet());
            key.sort(Comparator.comparing((Integer s) -> map.get(s)).reversed()
                    .thenComparing(s -> s));

            ans.add(key.get(0));
            if(key.size() > 1) ans.add(key.get(1));
        }


        return ans.stream().mapToInt(s -> s).toArray();
    }
}