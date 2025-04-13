import java.util.*;
import java.io.*;

public class Main{
    static class Problem{
        int level;
        int group;

        Problem(int level, int group){
            this.level = level;
            this.group = group;
        }
    }

    private static Map<Integer, Problem> prob = new HashMap<>();
    private static TreeMap<Integer, TreeSet<Integer>> probByL = new TreeMap<>();
    private static Map<Integer, TreeMap<Integer, TreeSet<Integer>>> probByGL = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            addProblem(P,L,G);
        }

        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("recommend")){
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                TreeMap<Integer,TreeSet<Integer>> levelMap = probByGL.get(g);

                if(x == 1) {
                    TreeSet<Integer> problems = levelMap.get(levelMap.lastKey());
                    int problem = problems.last();
                    sb.append(problem).append("\n");
                }
                else if(x == -1) {
                    TreeSet<Integer> problems = levelMap.get(levelMap.firstKey());
                    int problem = problems.first();
                    sb.append(problem).append("\n");
                }
            }

            else if(op.equals("recommend2")){
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    TreeSet<Integer> problems = probByL.get(probByL.lastKey());
                    int problem = problems.last();
                    sb.append(problem).append("\n");
                }
                if(x == -1) {
                    TreeSet<Integer> problems = probByL.get(probByL.firstKey());
                    int problem = problems.first();
                    sb.append(problem).append("\n");
                }
            }

            else if(op.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                if(x == 1){
                    Integer level = probByL.ceilingKey(l);
                    if(level == null) {
                        sb.append("-1").append("\n");
                    }
                    else{
                        int problem = probByL.get(level).first();
                        sb.append(problem).append("\n");
                    }
                }
                if(x == -1) {
                    Integer level = probByL.floorKey(l-1);
                    if(level == null) {
                        sb.append("-1").append("\n");
                    }
                    else{
                        int problem = probByL.get(level).last();
                        sb.append(problem).append("\n");
                    }
                }
            }

            else if(op.equals("add")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                addProblem(p,l,g);
            }

            else if(op.equals("solved")){
                int p = Integer.parseInt(st.nextToken());
                solveProblem(p);
            }
        }

        System.out.println(sb);
    }

    private static void solveProblem(int p){
        Problem problem = prob.get(p);

        int l = problem.level;
        int g = problem.group;

        probByL.get(l).remove(p);
        if(probByL.get(l).isEmpty()) probByL.remove(l);

        probByGL.get(g).get(l).remove(p);
        if(probByGL.get(g).get(l).isEmpty()) probByGL.get(g).remove(l);
        if(probByGL.get(g).isEmpty()) probByGL.remove(g);

        prob.remove(p);
    }

    private static void addProblem(int P, int L, int G){
        prob.put(P,new Problem(L,G));

        probByL.computeIfAbsent(L, k -> new TreeSet<>()).add(P);

        probByGL.computeIfAbsent(G, k -> new TreeMap<>());
        probByGL.get(G).computeIfAbsent(L, k -> new TreeSet<>()).add(P);
    }
}