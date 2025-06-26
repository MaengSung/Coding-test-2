import java.util.*;

class Solution {
    List<Integer>[] children;
    int[] animal;
    int max = 0;
    public int solution(int[] info, int[][] edges) {
        animal = info;
        children = new ArrayList[info.length];

        for(int i = 0; i < info.length; i++) children[i] = new ArrayList<>();

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            children[a].add(b);
        }

        dfs(0,0,0,List.of(0));

        return max;
    }

    private void dfs(int idx, int sheep, int wolf, List<Integer> check) {
        if(animal[idx] == 0) sheep++;
        else wolf++;

        if(wolf >= sheep) return;

        max = Math.max(max, sheep);

        List<Integer> next = new ArrayList<>(check);
        next.remove(Integer.valueOf(idx));

        next.addAll(children[idx]);

        for(int n : next){
            dfs(n,sheep,wolf,next);
        }
    }
}