import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> arr = changeArr(s);
        int[] res = new int[arr.size()];
        List<Integer> prev = new ArrayList<>();
        for(int i = 0; i < res.length; i++){
            List<Integer> cur = arr.get(i);
            for(int c : cur){
                if(!prev.contains(c)){
                    res[i] = c;
                    prev.add(c);
                    break;
                }

            }
        }
        return res;
    }

    private List<List<Integer>> changeArr(String str){
        str = str.substring(2,str.length()-2);
        String[] sArr = str.split("},\\{");

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < sArr.length; i++){
            String next = sArr[i];
            String[] strArr = next.split(",");
            List<Integer> list = new ArrayList<>();
            for(String s : strArr){
                list.add(Integer.parseInt(s));
            }
            res.add(list);
        }

        res.sort(Comparator.comparing(List::size));

        return res;
    }
}