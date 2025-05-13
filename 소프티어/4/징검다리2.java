import java.io.*;
import java.util.*;

public class 징검다리2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        int[] lCnt = new int[n];
        int[] rCnt = new int[n];

        for(int i = 0; i < n; i++){
            if(lList.isEmpty() || lList.get(lList.size()-1) < arr[i]){
                lList.add(arr[i]);
            }
            else if(lList.get(lList.size()-1) > arr[i]){
                int idx = Collections.binarySearch(lList,arr[i]);
                if(idx < 0){
                    idx = -idx -1;
                }
                lList.set(idx,arr[i]);
            }
            lCnt[i] = lList.size();

            int rIdx = n - 1 - i;
            if(rList.isEmpty() || rList.get(rList.size()-1) < arr[rIdx]){
                rList.add(arr[rIdx]);
            }
            else if(rList.get(rList.size()-1) > arr[rIdx]){
                int idx = Collections.binarySearch(rList,arr[rIdx]);
                if(idx < 0){
                    idx = -idx - 1;
                }
                rList.set(idx,arr[rIdx]);
            }
            rCnt[rIdx] = rList.size();
        }

        int res = 0;
        if(lList.size() == 1 || rList.size() == 1){
            res = Math.max(lList.size(), rList.size());
            System.out.println(res);
            return;
        }

        for(int i = 0; i < n; i++){
            if(lCnt[i] != 1 && rCnt[i] != 1){
                res = Math.max(res, lCnt[i] + rCnt[i]);
            }
        }

        if(res != 0) res--;
        System.out.println(res);
    }
}