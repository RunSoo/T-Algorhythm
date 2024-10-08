import java.util.*;
class Solution {
    boolean solution(String s) {
        char[] cArr= s.toCharArray();
        // System.out.println(Arrays.toString(cArr));
        
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<cArr.length; i++){
            if (cArr[i]=='('){
                stack.push('(');
            } else {
                if (!stack.isEmpty()){
                    stack.pop();
                } else return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}