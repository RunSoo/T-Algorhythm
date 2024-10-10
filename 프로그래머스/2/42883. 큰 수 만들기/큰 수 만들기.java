import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<number.length(); i++){
            char current = number.charAt(i);
            while (!stack.isEmpty() && k>0 && stack.peek()<current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }
        
        while (k>0) {
            stack.pop();
            k--;
        }
        
        for (char c: stack){
            answer+=c;
        }
        
        return answer;
    }
}