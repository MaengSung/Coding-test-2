import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {

        List<String> hints = new ArrayList<>();
        List<String> quests =new ArrayList<>();

        for(String str : expressions){
            if(str.contains("X")) quests.add(str);
            else hints.add(str);
        }

        String[] result = new String[quests.size()];
        Map<Integer,Integer> expressionMap = new HashMap<>();
        for(int i =2; i < 10; i++){
            expressionMap.put(i,0);
        }

        int maxDigitInHint = 0;
        int minBaseDigitInHint = 0;
        for(String hint : hints){
            String[] parts = hint.split(" ");
            int digit = Math.max(getDigit(parts[0]),getDigit(parts[2]));
            digit = Math.max(digit, getDigit(parts[4]));
            maxDigitInHint = Math.max(maxDigitInHint,digit);
        }
        minBaseDigitInHint = maxDigitInHint + 1;

        for(String ex : hints){
            String[] parts = ex.split(" ");
            String op = parts[1];
            for(int base = minBaseDigitInHint; base <= 9; base++){
                check(parts,op,base,expressionMap);
            }
        }

        int maxDigitInQuest = 0;
        int minBaseDigitInQuest = 0;
        for(String quest : quests){
            String[] parts = quest.split(" ");
            int digit = Math.max(getDigit(parts[0]),getDigit(parts[2]));
            digit = Math.max(digit, getDigit(parts[4]));
            maxDigitInQuest = Math.max(maxDigitInQuest,digit);
        }
        minBaseDigitInQuest = maxDigitInQuest + 1;

        for(int i = 0; i < quests.size(); i++){
            String ex = quests.get(i);
            String[] parts = ex.split(" ");
            String op = parts[1];

            Set<String> resultSet = new HashSet<>();

            for(int base = minBaseDigitInQuest; base <= 9; base++){
                if(expressionMap.get(base) == hints.size()) checkSet(parts,op,base,resultSet);
            }

            if(resultSet.size() != 1){
                result[i] = parts[0] + " " + op + " " + parts[2] + " = ?";
            }
            else{
                Iterator<String> iterator = resultSet.iterator();
                if (iterator.hasNext()){
                    String value = iterator.next();
                    result[i] = parts[0] + " " + op + " " + parts[2] + " = "+value;
                }
            }
        }

        return result;
    }

    private void checkSet(String[] parts, String op, int base, Set<String> resultSet) {
        if(!isValidNumber(parts[0],base) || !isValidNumber(parts[2],base)) return;

        int num1 = Integer.parseInt(parts[0], base);
        int num2 = Integer.parseInt(parts[2], base);
        int res = op.equals("+") ? num1 + num2 : num1 - num2;

        String ans = Integer.toString(res,base);
        resultSet.add(ans);
    }

    private int getDigit(String number){
        int digit = 0;
        for(char c : number.toCharArray()){
            if(Character.isDigit(c)){
                digit = Math.max(digit, Character.getNumericValue(c));
            }
        }
        return digit;
    }

    private void check(String[] parts, String op, int base, Map<Integer,Integer> expressionMap){
        if(!isValidNumber(parts[0],base) || !isValidNumber(parts[2],base) || !isValidNumber(parts[4],base)) return;

        int num1 = Integer.parseInt(parts[0], base);
        int num2 = Integer.parseInt(parts[2], base);

        int res = op.equals("+") ? num1 + num2 : num1 - num2;

        String ans = Integer.toString(res,base);

        if(ans.equals(parts[4])) expressionMap.merge(base,1, Integer::sum);
    }

    private boolean isValidNumber(String number, int base) {
        for(char c : number.toCharArray()){
            int digit = Character.getNumericValue(c);
            if(digit < 0 || digit >= base) return false;
        }
        return true;
    }
}