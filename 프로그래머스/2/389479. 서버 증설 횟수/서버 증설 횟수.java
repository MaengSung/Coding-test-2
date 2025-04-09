import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> serverList = new ArrayList<>();

        for(int player : players){
            nextTime(serverList);
            
            if(player >= serverList.size() * m && player >= m){
                int count = player / m - serverList.size();
                for(int i = 0; i < count; i++) serverList.add(new Server(k));
                answer += count;
            }
        }

        return answer;
    }

    private void nextTime(List<Server> serverList){
        List<Server> removedServers = new ArrayList<>();
        for(Server server : serverList){
            if(!server.serviveServer()) removedServers.add(server);
        }

        for(Server server : removedServers){
            serverList.remove(server);
        }
    }

    class Server{
        int life;

        Server(int maxLife){
            this.life = maxLife;
        }

        boolean serviveServer(){
            life--;
            return life > 0 ? true : false;
        }
    }
}