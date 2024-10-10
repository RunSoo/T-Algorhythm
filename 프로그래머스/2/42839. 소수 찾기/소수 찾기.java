import java.util.*;
class Solution {
    static Set<Integer> madeSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] numChar = numbers.toCharArray();
        boolean[] visited = new boolean[numChar.length];
        
        for (int i=0; i<numChar.length; i++){
            if (numChar[i]!='0') {
                visited[i]=true;
                makeNum(""+numChar[i], numChar, visited);
                visited[i] = false;
            } 
        }

        return madeSet.size();
    }
    
    public void makeNum (String num, char[] numChar, boolean[] visited) {
        int number = Integer.parseInt(num);
        if (isPrime(number)) madeSet.add(number);
        for (int i=0; i<numChar.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                makeNum(num+numChar[i], numChar, visited);
                visited[i]=false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num==1) return false;
        if (num==2) return true;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num%i==0) return false;
        }
        return true;
    }
}