import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();

            int idx = 0;
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                head.append(file.charAt(idx));
                idx++;
            }
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                num.append(file.charAt(idx));
                idx++;
            }

            fileList.add(new File(file, head.toString(), Integer.parseInt(num.toString()), i));
        }

        Collections.sort(fileList);

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileList.get(i).origin;
        }
        return answer;
    }

    static class File implements Comparable<File> {
        String origin;
        String head;
        int num;
        int order;

        File(String origin, String head, int num, int order) {
            this.origin = origin;
            this.head = head;
            this.num = num;
            this.order = order;
        }

        @Override
        public int compareTo(File o) {
            int headCompare = this.head.compareToIgnoreCase(o.head);
            if (headCompare != 0) return headCompare;
            if (this.num != o.num) return this.num - o.num;
            return this.order - o.order; 
        }
    }
}
