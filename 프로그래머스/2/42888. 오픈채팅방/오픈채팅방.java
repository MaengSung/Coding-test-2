import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> chat = new HashMap<>();
        Queue<Msg> q = new LinkedList<>();
        
        for(String rec : record){
            String[] m = rec.split(" ");
            
            if(m[0].equals("Enter")){
                chat.put(m[1],m[2]);
                q.offer(new Msg(m[1],"님이 들어왔습니다."));
            }
            
            if(m[0].equals("Leave")){
                q.offer(new Msg(m[1],"님이 나갔습니다."));
            }
            
            if(m[0].equals("Change")){
                chat.put(m[1],m[2]);
            }
        }
        
        String[] res = new String[q.size()];
        for(int i = 0; i < res.length; i++){
            Msg m = q.poll();
            res[i] = chat.get(m.userId) + m.command;
        }
        return res;
    }
    
    class Msg{
        String userId;
        String command;
        
        Msg(String userId, String command){
            this.userId = userId;
            this.command = command;
        }
    }
}