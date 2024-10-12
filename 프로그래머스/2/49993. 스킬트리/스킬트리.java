import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char c : skill.toCharArray()) {
            map.put(c, 1+idx++);
        }
        int cnt = 0;
        outer: for (int s = 0; s<skill_trees.length; s++) {
            String curSkill = skill_trees[s];
            int skillCnt = 0;
            boolean flag = true;
            for (char c:curSkill.toCharArray()){
                if (map.containsKey(c)) {
                    if (map.get(c)<=skillCnt+1) {
                        if (map.get(c)>skillCnt) skillCnt++;
                    } else {
                        flag=false;
                        break;
                    }
                }
            }
            if (flag) cnt++;
        }
        
        return cnt;
    }
}