import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int[] pointers = new int[n];
        TreeSet<Student> school = new TreeSet<>();
        for(int i = 0; i < n; i++) school.add(new Student(i,arr[i][0]));
        long min = Long.MAX_VALUE;
        while(true){
            Student minStudent = school.first();
            school.remove(minStudent);
            min = Math.min(min,school.last().sp - minStudent.sp);
            if(++pointers[minStudent.cls] == m) break;
            school.add(new Student(minStudent.cls, arr[minStudent.cls][pointers[minStudent.cls]]));
        }
        System.out.println(min);
    }

    static class Student implements Comparable<Student>{
        int cls;
        int sp;

        Student(int cls, int sp){
            this.cls = cls;
            this.sp = sp;
        }

        @Override
        public int compareTo(Student o) {
            if(this.sp == o.sp) return this.cls - o.cls;
            return this.sp - o.sp;
        }
    }
}