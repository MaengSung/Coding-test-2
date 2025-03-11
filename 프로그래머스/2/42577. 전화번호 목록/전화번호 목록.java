import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 전화번호를 정렬 (사전순 정렬)
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) { // 바로 다음 번호와 비교
                return false;
            }
        }
        
        return true;
    }
}
