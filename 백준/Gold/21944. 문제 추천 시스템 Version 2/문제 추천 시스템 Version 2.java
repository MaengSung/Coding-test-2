import java.io.*;
import java.util.*;

public class Main {
    static class Problem {
        int level;
        int group;

        Problem(int level, int group) {
            this.level = level;
            this.group = group;
        }
    }

    static Map<Integer, Problem> probLevel = new HashMap<>();
    static TreeMap<Integer, TreeSet<Integer>> probByL = new TreeMap<>();
    static Map<Integer, TreeMap<Integer, TreeSet<Integer>>> probByGL = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 초기 문제 등록
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            addProblem(P, L, G);
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                TreeMap<Integer, TreeSet<Integer>> levelMap = probByGL.get(G);
                if (levelMap == null) {
                    sb.append("-1\n");
                    continue;
                }

                if (x == 1) {
                    for (int level : levelMap.descendingKeySet()) {
                        TreeSet<Integer> probs = levelMap.get(level);
                        if (!probs.isEmpty()) {
                            sb.append(probs.last()).append("\n");
                            break;
                        }
                    }
                } else {
                    for (int level : levelMap.keySet()) {
                        TreeSet<Integer> probs = levelMap.get(level);
                        if (!probs.isEmpty()) {
                            sb.append(probs.first()).append("\n");
                            break;
                        }
                    }
                }
            }

            else if (cmd.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    for (int level : probByL.descendingKeySet()) {
                        TreeSet<Integer> probs = probByL.get(level);
                        if (!probs.isEmpty()) {
                            sb.append(probs.last()).append("\n");
                            break;
                        }
                    }
                } else {
                    for (int level : probByL.keySet()) {
                        TreeSet<Integer> probs = probByL.get(level);
                        if (!probs.isEmpty()) {
                            sb.append(probs.first()).append("\n");
                            break;
                        }
                    }
                }
            }

            else if (cmd.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    Integer level = probByL.ceilingKey(L);
                    if (level == null) {
                        sb.append("-1\n");
                    } else {
                        TreeSet<Integer> probs = probByL.get(level);
                        sb.append(probs.first()).append("\n");
                    }
                } else {
                    Integer level = probByL.floorKey(L - 1);
                    if (level == null) {
                        sb.append("-1\n");
                    } else {
                        TreeSet<Integer> probs = probByL.get(level);
                        sb.append(probs.last()).append("\n");
                    }
                }
            }

            else if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                addProblem(P, L, G);
            }

            else if (cmd.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                removeProblem(P);
            }
        }

        System.out.print(sb);
    }

    static void addProblem(int P, int L, int G) {
        probLevel.put(P, new Problem(L, G));

        probByL.computeIfAbsent(L, k -> new TreeSet<>()).add(P);

        probByGL.computeIfAbsent(G, k -> new TreeMap<>());
        probByGL.get(G).computeIfAbsent(L, k -> new TreeSet<>()).add(P);
    }

    static void removeProblem(int P) {
        Problem prob = probLevel.get(P);
        int L = prob.level;
        int G = prob.group;

        probByL.get(L).remove(P);
        if (probByL.get(L).isEmpty()) probByL.remove(L);

        probByGL.get(G).get(L).remove(P);
        if (probByGL.get(G).get(L).isEmpty()) probByGL.get(G).remove(L);
        if (probByGL.get(G).isEmpty()) probByGL.remove(G);

        probLevel.remove(P);
    }
}
