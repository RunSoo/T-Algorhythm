import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String c : completion){
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        
        for (String p: participant){
            if (map.containsKey(p)){
                if (map.get(p)==1) map.remove(p);
                else map.put(p, map.get(p)-1);
            } else {
                return p;
            }
        }
        return "";
    }
}