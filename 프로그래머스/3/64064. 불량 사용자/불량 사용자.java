import java.util.*;

public class Solution{
    String[] userIds;
    String[] bannedIds;
    Set<Set<String>> res = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        dfs(new HashSet<>(), 0);
        
        return res.size();
    }
    
    private void dfs(Set<String> set, int depth){
        if(depth == bannedIds.length){
            res.add(set);
            return;
        }
        
        for(String id : userIds){
            if(set.contains(id)) continue;
            if(check(id,bannedIds[depth])){
                set.add(id);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(id);
            }
        }
    }
    
    private boolean check(String id, String key){
        if(id.length() != key.length()) return false;
        for(int i = 0; i < id.length(); i++){
            if(key.charAt(i) == '*') continue;
            if(key.charAt(i) != id.charAt(i)) return false;
        }
        return true;
    }
}