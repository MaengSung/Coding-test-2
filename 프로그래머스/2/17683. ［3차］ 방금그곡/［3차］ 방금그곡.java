import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        Map<String,String> musics = new LinkedHashMap<>();

        for(String musicinfo : musicinfos){
            String[] info = musicinfo.split(",");
            int time = takenTime(info[0],info[1]);

            String list = changeM(info[3]);
            if(time >=  list.length()){
                info[3] = list.repeat(time/list.length());
                if(time%list.length() != 0)
                    info[3] = info[3] + list.substring(0, time % list.length());
            }
            if(time < list.length())
                info[3] = list.substring(0,time);
            musics.put(info[2],info[3]);
        }

        int max = -1;
        String res = "(None)";
        m = changeM(m);
        for(Entry<String, String> music : musics.entrySet()){
            if(music.getValue().contains(m) && (music.getValue().length() > max)){
                res = music.getKey();
                max = music.getValue().length();
            }
        }

        return res;
    }
    
    private String changeM(String music){
        StringBuilder sb = new StringBuilder();
        for(char c : music.toCharArray()){
            if(c == '#'){
                String change = sb.substring(sb.length()-1).toLowerCase();
                sb.deleteCharAt(sb.length()-1);
                sb.append(change);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int takenTime(String start, String end){
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int s = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int e = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
        return e - s;
    }
}