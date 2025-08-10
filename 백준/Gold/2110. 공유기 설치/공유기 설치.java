import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int len = 1, en = 1_000_000_000;
        while(len < en){
            int nextLen = (len + en + 1) / 2;
            if(solve(arr,nextLen,n,c)) len = nextLen;
            else en = nextLen-1;
        }
        System.out.println(len);
    }

    private static boolean solve(int[] arr, int len, int n, int c){
        int idx = 0, cnt = 0;
        while(idx != n){
            int target = arr[idx] + len;
            idx = binarySearch(arr,target,idx,n);
            cnt++;
        }
        return cnt >= c;
    }

    private static int binarySearch(int[] arr, int target, int start, int end){
        int st = start, en = end;
        while(st < en){
            int mid = (st + en)/2;
            if(arr[mid] < target) st = mid + 1;
            else en = mid;
        }
        return st;
    }
}