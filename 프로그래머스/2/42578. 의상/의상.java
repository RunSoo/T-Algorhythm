import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++){
            if (map.containsKey(clothes[i][1])) map.put(clothes[i][1], map.get(clothes[i][1])+1);
            else map.put(clothes[i][1], 1);
        }
        Integer[] values = map.values().toArray(new Integer[0]);
        int answer = 1;
        for (Integer i: values){
            answer*=(i+1);
        }
        return answer-1;
    }
}