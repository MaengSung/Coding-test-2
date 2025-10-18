import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 전역 변수 선언부는 변경 없음
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int n, m;
    private static boolean[][] visited;
    private static char[][] map;
    private static Queue<int[]> moves;
    private static List<int[]>[] doors; // List의 배열
    private static boolean[] keys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); 
            int w = Integer.parseInt(st.nextToken()); 

            n = h + 2;
            m = w + 2;
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = '.'; 
                }
            }

            // 2. 원래 맵을 새 맵의 중앙에 복사
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i + 1][j + 1] = line.charAt(j);
                }
            }
            
            // 3. 변수들 초기화
            keys = new boolean[26];
            doors = new List[26];
            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }
            
            String inputKeys = br.readLine();
            if (!inputKeys.equals("0")) {
                for (char key : inputKeys.toCharArray()) {
                    keys[key - 'a'] = true;
                }
            }
            
            // 4. BFS 시작점 설정 (무조건 (0,0)에서 시작)
            moves = new LinkedList<>();
            visited = new boolean[n][m];
            moves.add(new int[]{0, 0});
            visited[0][0] = true;

            int cnt = bfsFind();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    // bfsFind 메소드는 이전 버전 그대로 완벽하므로 변경 없음
    private static int bfsFind() {
        int cnt = 0;
        while (!moves.isEmpty()) {
            int[] move = moves.poll();
            int x = move[0];
            int y = move[1];

            // 현재 위치가 문서인 경우 (패딩 방식으로 인해 시작점에서도 체크 필요)
            if (map[x][y] == '$') {
                cnt++;
                map[x][y] = '.'; // 문서를 주웠으면 빈 공간으로 변경
            }

            for (int[] dir : dirs) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if (cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if (visited[cx][cy]) continue;
                if (map[cx][cy] == '*') continue;

                char pos = map[cx][cy];
                visited[cx][cy] = true;

                if (pos == '.') {
                    moves.add(new int[]{cx, cy});
                } else if (pos == '$') {
                    // 이 부분은 위에서 poll() 직후에 처리하는 것으로 변경하여
                    // 중복 계산을 방지할 수 있지만, 여기 있어도 로직은 맞습니다.
                    // 단, cnt를 여기서 세면 시작점의 문서를 놓치므로 poll 직후가 더 좋습니다.
                    moves.add(new int[]{cx, cy});
                } else if (Character.isUpperCase(pos)) {
                    if (keys[pos - 'A']) {
                        moves.add(new int[]{cx, cy});
                    } else {
                        doors[pos - 'A'].add(new int[]{cx, cy});
                    }
                } else if (Character.isLowerCase(pos)) {
                    keys[pos - 'a'] = true;
                    moves.add(new int[]{cx, cy});
                    map[cx][cy] = '.'; // 열쇠를 주웠으면 빈 공간으로 변경

                    for (int[] door : doors[pos - 'a']) {
                        moves.add(new int[]{door[0], door[1]});
                    }
                    doors[pos - 'a'].clear();
                }
            }
        }
        return cnt;
    }
}