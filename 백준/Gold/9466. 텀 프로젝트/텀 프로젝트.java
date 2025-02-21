import java.util.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;
    static int[] arr;
    static int[] state;
    static int n;

    public static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x; // 현재 방문 중인 학생 표시
            cur = arr[cur];

            // 이번 방문에서 사이클 발견 (같은 방문 번호를 다시 만난 경우)
            if (state[cur] == x) {
                // 사이클 내 모든 학생을 CYCLE_IN으로 표시
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 이미 처리된 학생을 만난 경우
            else if (state[cur] != NOT_VISITED) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            arr = new int[n + 1];
            state = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) {
                    run(i);
                }
            }

            // 사이클에 속하지 않은 학생 수 계산
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != CYCLE_IN) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}
