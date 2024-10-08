import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i : arr){
            queue.offer(i);
        }
        
        List<Integer> resultList = new ArrayList<>();
        int top = -1;
        while (!queue.isEmpty()){
            if (queue.peek()!=top){
                top = queue.poll();
                resultList.add(top);
            } else {
                queue.poll();
            }
        }
        
        int[] answer = new int[resultList.size()];
        for (int i=0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
       }

        return answer;
    }
}