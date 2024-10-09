import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] citate = new Integer[citations.length];
        for (int i=0; i<citations.length; i++){
            citate[i] = citations[i];
        }
        Arrays.sort(citate, Comparator.reverseOrder());
        
        for (int i=0; i<citate.length; i++){
            if (citate[i]<=i) return i;
        }
        
        return citate.length;
    }
}