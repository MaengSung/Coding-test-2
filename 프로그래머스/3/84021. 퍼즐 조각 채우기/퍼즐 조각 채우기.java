import java.util.*;

class Solution {
    private static List<List<Point>> t = new ArrayList<>();
    private static List<List<Point>> b = new ArrayList<>();
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int len = game_board.length;

        boolean[][] visited_b = new boolean[len][len];
        boolean[][] visited_t = new boolean[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(game_board[i][j] == 0) game_board[i][j] = 1;
                else game_board[i][j] = 0;
            }
        }

        for(int i = 0; i < len; i++){
            for(int j= 0; j < len; j++){
                if(!visited_t[i][j] && table[i][j] == 1){
                    bfs(i,j,table,visited_t,t);
                }

                if(!visited_b[i][j] && game_board[i][j] == 1){
                    bfs(i,j,game_board,visited_b,b);
                }
            }
        }

        answer = comparePuzzle(answer);

        return answer;
    }

    private int comparePuzzle(int answer){
        boolean[] visited = new boolean[b.size()];

        for(int i = 0; i < t.size(); i++){
            for(int j = 0; j < b.size(); j++){
                if(visited[j] || t.get(i).size() != b.get(j).size()) continue;
                if(matchPuzzle(t.get(i),b.get(j))) {
                    answer += b.get(j).size();
                    visited[j] = true;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean matchPuzzle(List<Point> table, List<Point> board){
        Collections.sort(board);

        for(int i = 0; i < 4; i++){
            Collections.sort(table);

            boolean check = true;

            int curX = table.get(0).x;
            int curY = table.get(0).y;
            for(int j = 0; j < table.size(); j++){
                table.get(j).x -= curX;
                table.get(j).y -= curY;
            }

            for(int j = 0; j < table.size(); j++){
                if(table.get(j).x != board.get(j).x || table.get(j).y != board.get(j).y){
                    check = false;
                    break;
                }
            }

            if(check) return true;
            else{
                for(int j = 0; j < table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        return false;
    }

    private void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> p){
        int len = board.length;
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        List<Point> subList = new ArrayList<>();
        subList.add(new Point(0,0));

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int[] dir : dirs){
                int cx = cur.x + dir[0];
                int cy = cur.y + dir[1];

                if(cx < 0 || cx >= len || cy < 0 || cy >= len)
                    continue;
                if(board[cx][cy] != 1 || visited[cx][cy])
                    continue;

                visited[cx][cy] = true;
                q.offer(new Point(cx,cy));
                subList.add(new Point(cx - x, cy - y));
            }
        }

        p.add(subList);
    }


    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p){
            int res = Integer.compare(this.x,p.x);
            if(res == 0) res = Integer.compare(this.y,p.y);
            return res;
        }

    }
}