import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        int idx = -1;
        if (ext.equals("code"))
            idx = 0;
        if (ext.equals("date"))
            idx = 1;
        if (ext.equals("maximum"))
            idx = 2;
        if (ext.equals("remain"))
            idx = 3;
        for (int[] d : data) {
            if (d[idx] < val_ext) {
                list.add(d);
            }
        }

        int sortIdx = -1;
        if (sort_by.equals("code"))
            sortIdx = 0;
        if (sort_by.equals("date"))
            sortIdx = 1;
        if (sort_by.equals("maximum"))
            sortIdx = 2;
        if (sort_by.equals("remain"))
            sortIdx = 3;

        int finalSortIdx = sortIdx;
        list.sort(Comparator.comparingInt(o -> o[finalSortIdx]));
        
        return list.toArray(new int[list.size()][]);
    }
    
}