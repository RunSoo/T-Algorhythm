import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            nums[i] = ""+numbers[i];
        }
        
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String num1, String num2){
                return (num2+""+num1).compareTo((num1+""+num2));
            }
        });
        
        if (nums[0].equals("0")) return "0";
        
        for (int i=0; i<nums.length; i++){
            answer+=nums[i];
        }
        
        return answer;
    }
}