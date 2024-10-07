import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            if (map.containsKey(num)) map.put(num, map.get(num)+1);
            else map.put(num, 1);
        }
        
        if (nums.length/2<=map.size()) return nums.length/2;
        else return map.size();
    }
}