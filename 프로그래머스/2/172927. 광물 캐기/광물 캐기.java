import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    String[] mine;
    public int solution(int[] picks, String[] minerals) {
        mine = minerals;
        dfs(0,0, picks.clone());
        return min;
    }

    private void dfs(int idx, int hp, int[] picks){
        if(idx >= mine.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)){
            min = Math.min(min, hp);
            return;
        }

        for(int i = 0; i < 3; i++){
            int[] nextPicks = picks.clone();
            int nextIdx = idx;
            int nextHp = hp;
            if(picks[i] != 0){
                switch(i){
                    case 0:
                        nextPicks[0]--;
                        if(mine.length - nextIdx < 5){
                            nextHp += mine.length - nextIdx;
                            nextIdx = mine.length;
                        }
                        else{
                            nextHp += 5;
                            nextIdx += 5;
                        }
                        break;
                    case 1:
                        nextPicks[1]--;
                        for(int j = 0; j < 5; j++){
                            if(nextIdx >= mine.length) break;
                            if(mine[nextIdx].equals("diamond")) nextHp+=5;
                            if(mine[nextIdx].equals("stone") || mine[nextIdx].equals("iron")) nextHp++;
                            nextIdx++;
                        }
                        break;
                    case 2:
                        nextPicks[2]--;
                        for(int j = 0; j < 5; j++){
                            if(nextIdx >= mine.length) break;
                            if(mine[nextIdx].equals("diamond")) nextHp+=25;
                            if(mine[nextIdx].equals("iron")) nextHp+=5;
                            if(mine[nextIdx].equals("stone")) nextHp++;
                            nextIdx++;
                        }
                        break;
                }
            }
            else continue;
            dfs(nextIdx, nextHp, nextPicks);
        }
    }
}