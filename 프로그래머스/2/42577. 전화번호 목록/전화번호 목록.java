import java.util.*;
class Solution {
    
    public boolean solution(String[] phone_book) {
        Map<String, String> map = new HashMap<>();
        for (String str:phone_book){
            map.put(str, str);
        }
        
        for (String str: phone_book){
            for (int i=0; i<str.length(); i++){
                if (map.containsKey(str.substring(0, i))) return false;
            }
        }
        
        return true;
    }
}